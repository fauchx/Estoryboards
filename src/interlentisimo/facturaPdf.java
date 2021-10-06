package interlentisimo;

import java.awt.Font;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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
	/*
	 * facturaPdf - constructor
	 * @param idfactura id de la factura generada
	 * @param infoRemi datos del remitente (id*,nombre*,teléfono*, dirección,email* )
	 * @param infoDest datos del destinatario (id*,nombre*,teléfono*, dirección*,email*)
	 * @param infoPaq datos del paquete enviado (peso*,volumen*)
	 * @param infoCosto datos  de costos finales (subtotal,seguro, iva)
	 */
	public facturaPdf(String idfactura,String[] infoRemi, String[] infoDest, String[][] infoPaq,String[] infoCosto) 
	{
		this.idfactura=idfactura;
		this.infoRemi=infoRemi;
		this.infoDest=infoDest;
		this.infoPaq=infoPaq;
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
	 * prueba factura
	 
	String[] remitente= {"1830990","brian","3158475","calle siempre viva","mroen@correo.co"};
	String[] destinatario= {"1626819","fabian","346813","calle pis","fabia@correo.co"};
	String[][] paq= {{"528","232"},
					{"674","584"}};
	String[] cost= {"15000.0","si","5000.0"};
	facturaPdf.crearPDF("123456",remitente,destinatario,paq,cost);
	/**
	 * 
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
        Paragraph id = new Paragraph("Factura No."+idfactura);
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
        			"Paquete"+ i +"\n"+ 
					"Peso:"+infoPaq[i][0]+"kg \n"+
					"Volumen:" + infoPaq[i][1]+"m3 \n\n";			
        }
        
        Paragraph infoPaqs = new Paragraph(strInfoPaq);
        infoPaqs.setAlignment(Element.ALIGN_LEFT);
        documento.add(infoPaqs);
        
        //datos costos totales
        String strCosto = "v-----COSTOS-----v \n\n"+
				"Subtotal:"+infoCosto[0]+"\n"+
				"Iva:" + infoCosto[1]+"\n"+
				"Seguro:" + infoCosto[2]+"\n"+
				"TOTAL:" + (Float.parseFloat(infoCosto[0])+ Float.parseFloat(infoCosto[1]))+"\n";
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

