package com.superinc.europe.onlineshopping.gu.web.httpUtils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.superinc.europe.onlineshopping.gu.entities.dto.Bucket;
import com.superinc.europe.onlineshopping.gu.entities.dto.QuantityAndSum;

@ResponseBody
public class PdfGenerator extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	HttpServletResponse response;

	public static void getReport(HttpServletResponse response, List<Bucket> bucket, List<QuantityAndSum> quantitySum) throws ServletException, IOException {
		String [] dataUsers = {"", "", "", ""};	
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String line = auth.getPrincipal().toString();
		String [] dataUsers2 = line.split(" "); 
		if (dataUsers2.length!=1){
			dataUsers = line.split(" ");}
		else {
			dataUsers[0] = "";
			dataUsers[1] = "";
			dataUsers[2] = "";
			dataUsers[3] = "";
		}
		try {
            com.itextpdf.text.Document pdfDocument = new com.itextpdf.text.Document();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PdfWriter.getInstance(pdfDocument, baos);
            pdfDocument.open();
            pdfDocument.add(new Paragraph("                                                                                                        Dear ,  " + dataUsers[1]));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("            Congratulations, you just made the order. Within 2 hours you will be contacted by our"));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("  courier and you will be able to discuss with him convenient for you the delivery time.   "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("                                                                      Report"));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("            Ordered goods: "));
            pdfDocument.add(new Paragraph("    "));
            for (Bucket ob : bucket) {
            	pdfDocument.add(new Paragraph("   Product:   " + ob.getName() + ",        Model:   " + ob.getDescription() + ",        Quantity:   "  + ob.getQuantity() + ",       Price for one:   " + ob.getPrice()));
            	pdfDocument.add(new Paragraph("    "));
            }
            pdfDocument.add(new Paragraph("                                                                                                                        _______________   "));
            pdfDocument.add(new Paragraph("                                                                                                                        Total price:  " + quantitySum.get(0).getSum()));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.add(new Paragraph("            Best regards, your Super Incorporated."));
            pdfDocument.add(new Paragraph("    "));
            pdfDocument.close();
            response.setHeader("Expires", "0");
            response.setHeader("Content-disposition","attachment;filename="+ "MyOrderReport.pdf"); 
            response.setHeader("Pragma", "public");
            response.setContentType("application/pdf");   
            response.setContentLength(baos.size());   
            ServletOutputStream os = response.getOutputStream();
            baos.writeTo(os);
            os.flush();
            os.close();
        }
        catch(DocumentException e) {
        	throw new IOException(e.getMessage());
        }
	}
	
}