package interlentisimo;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

/*
 * @author Brian Moreno
 *  Clase que representa las facturas generadas por los pagos de pedidos
 */
public class facturaPdf 
{
	private static String nombre = "Factura";
	private String idfactura;
	private String[] infoRemi;
	private String[] infoDest;
	private String[][] infoPaq;
	private String[] infoCosto;

	/**
	 * Clase facturaPdf define el modelo de la factura, así como la generación de facturas respecto a
	 * un envío en particular
	 * @author Brian Moreno
	 * @param datos	vector de strings con el id del envío, información del remitente, información del destinatario y costos 
	 * @param datosPaqs	lista de vectores de strings con la información de cada paquete asociado a un envío
	 */
	public facturaPdf(String [] datos, ArrayList <String[]>datosPaqs) 
	{
		/*
		this.idfactura=idfactura;
		this.infoRemi=infoRemi;
		this.infoDest=infoDest;
		this.infoPaq=infoPaq;
		this.infoCosto=infoCosto;
		*/
		this.idfactura=datos[0];
		
		String [] infoRemi = {datos[1],datos[2],datos[3],datos[4],datos[5]};
		this.infoRemi= infoRemi;
		
		String [] infoDest = {datos[6],datos[7],datos[8],datos[9],datos[10]};
		this.infoDest=infoDest;
		
		int cantidadPaqs = datosPaqs.size();
		this.infoPaq=new String[cantidadPaqs][2];
		for(int i = 0;i<cantidadPaqs; i++) 
		{
				infoPaq[i]=datosPaqs.get(i);
		}
		
		String [] infoCosto= {datos[11],datos[12]};
		this.infoCosto=infoCosto;
		
		try {
			crearPDF(idfactura,infoRemi,infoDest,infoPaq,infoCosto);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * crearPDF Genera el fichero .pdf con el modelo de la factura y los datos insertados
	 * @author Brian Moreno
	 * @param idfactura
	 * @param infoRemi
	 * @param infoDest
	 * @param infoPaq
	 * @param infoCosto
	 * @throws FileNotFoundException
	 * @throws DocumentException
	 */
	public static void crearPDF(String idfactura,String[] infoRemi, String[] infoDest, String[][] infoPaq,String[] infoCosto) throws FileNotFoundException, DocumentException {
        // Se crea el documento
        Document documento = new Document();
        
        // Se define el nombre y direccion para el fichero
        String direccion = prodDirec(nombre);
        
        // El OutPutStream para el fichero donde crearemos el PDF
        FileOutputStream ficheroPDF = new FileOutputStream(direccion);
        
        // Se asocia el documento de OutPutStream
        PdfWriter.getInstance(documento, ficheroPDF);
        
        // Se abre el documento
        documento.open();
        
        // titulo
        Paragraph titulo = new Paragraph("FACTURAS FLASH DELIVERIES \n\n", FontFactory.getFont("arial",20,Font.BOLD,BaseColor.BLACK));
        titulo.setAlignment(Element.ALIGN_CENTER);
        documento.add(titulo);
        
        //id de la factura
        Paragraph id = new Paragraph("Envio No."+idfactura);
        id.setAlignment(Element.ALIGN_CENTER);
        documento.add(id);
        
        //datos remitente
        String strInfoRemi = "Información Remitente \n\n"+
        					"ID:"+infoRemi[0]+"\n"+
        					"Nombre:" + infoRemi[1]+"\n"+
        					"Teléfono:" + infoRemi[2]+"\n"+
        					"Dirección:" + infoRemi[3]+"\n"+
        					"Email:" + infoRemi[4] + "\n\n";
        Paragraph infoRemiPg = new Paragraph(strInfoRemi);
        infoRemiPg.setAlignment(Element.ALIGN_LEFT);
        documento.add(infoRemiPg);
        
        //datos Destinatario
        String strInfoDest = "Información Destinatario \n\n"+
							"ID:"+infoDest[0]+"\n"+
							"Nombre:" + infoDest[1]+"\n"+
							"Teléfono:" + infoDest[2]+"\n"+
							"Dirección:" + infoDest[3]+"\n"+
							"Email:" + infoDest[4]+ "\n\n";
        Paragraph infoDestPg = new Paragraph(strInfoRemi);
        infoDestPg.setAlignment(Element.ALIGN_LEFT);
        documento.add(infoDestPg);
        
      //datos Envio 
        Paragraph infoPaquetesTl = new Paragraph("Información Paquetes \n\n");
        infoPaquetesTl.setAlignment(Element.ALIGN_LEFT);
        documento.add(infoPaquetesTl);
        
        String strInfoPaq="";
        int cantidadPaqs = infoPaq.length; 
        for(int i=0;i<cantidadPaqs;i++) 
        {
        	strInfoPaq = strInfoPaq +
        			"Paquete"+ (i+1) +"\n"+ 
					"Peso:"+infoPaq[i][0]+"kg \n"+
					"Volumen:" + infoPaq[i][1]+"m3 \n\n";			
        }
        
        Paragraph infoPaqs = new Paragraph(strInfoPaq);
        infoPaqs.setAlignment(Element.ALIGN_LEFT);
        documento.add(infoPaqs);
        
        //datos costos totales
        String strCosto = "v-----COSTOS-----v \n\n"+
				"Subtotal:"+infoCosto[0]+"\n"+
				"Seguro:" + infoCosto[1]+"\n"+
				"Iva:" + (Integer.parseInt(infoCosto[0])*0.19) +"\n"+
				"TOTAL:" + (Float.parseFloat(infoCosto[0])+ Float.parseFloat(infoCosto[1]) + (Integer.parseInt(infoCosto[0])*0.19))+"\n";
        Paragraph infoCostoPg = new Paragraph(strCosto);
        infoCostoPg.setAlignment(Element.ALIGN_LEFT);
        documento.add(infoCostoPg);

        // Se cierra el documento
        documento.close();
    }
	
	private static String prodDirec(String name) 
	{
		String direccion = System.getProperty("user.dir")+"/src/facturas/"+ name +".pdf";
		int lastPos = direccion.length() - 4;
		
		int i=0;
		while((new File(direccion)).exists()) {
			if(i>0)
			{
				direccion=direccion.substring(0,lastPos)+ "(" + Integer.toString(i) + ").pdf";
			}else {
				direccion = direccion.substring(0, lastPos) + "(1).pdf";
			}
			i++;			
		}
		return direccion;
	}
}

