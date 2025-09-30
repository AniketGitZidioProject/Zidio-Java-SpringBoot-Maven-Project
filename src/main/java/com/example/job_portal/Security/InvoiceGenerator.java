package com.example.job_portal.Security;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.time.format.DateTimeFormatter;



import com.example.job_portal.Entity.PaidSubscription;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;


public class InvoiceGenerator {
	
	public static ByteArrayInputStream generateInvoice(PaidSubscription sub) {
		
		Document doc = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		try {
			
			PdfWriter.getInstance(doc, out);
			doc.open();
			
//			Font titleFont = new Font(Font.ITALIC, 14, Font.BOLDITALIC);
			Font titleFont = new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC);
//			Paragraph title =  Paragraph("Subscription Invoice", titleFont);
			Paragraph title = new Paragraph("Subscription Invoice", titleFont);

			title.setAlignment(Element.ALIGN_CENTER);
			doc.add(title);
			doc.add(new Paragraph(" "));
			
			PdfPTable table = new PdfPTable(2);
			
			table.setWidthPercentage(80);
			table.setSpacingBefore(20);
			
			table.addCell("Subscription ID");
			table.addCell(sub.getId().toString());
			
			table.addCell("Recruiter Id");
			table.addCell(sub.getRecruiterId().toString());
			
			table.addCell("Employee Id");
			table.addCell(sub.getEmployeeId().toString());
			
			table.addCell("Plan ID");
			table.addCell(sub.getPlanId().toString());
			
			table.addCell("Amount");
			table.addCell(sub.getAmount().toString());
			
			table.addCell("currency");
			table.addCell(sub.getCurrency().toString());
			
			table.addCell("Payment Status");
			table.addCell(sub.getPaymentStatus().toString());
			
			DateTimeFormatter fmt  = DateTimeFormatter.ofPattern("dd-MM-yyyy");
			
			table.addCell("Start Date");
			table.addCell(sub.getStartDate().format(fmt));
			
			table.addCell("End Date");
			table.addCell(sub.getEndDate().format(fmt));
			
			doc.add(table);
			doc.close();
			
			
		}catch (Exception e ) {
			e.printStackTrace();
		}
		
		return new ByteArrayInputStream(out.toByteArray());
		
	}

//	private static Paragraph Paragraph(String string, Font titleFont) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
