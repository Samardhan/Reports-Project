package in.samar.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import in.samar.entity.PersonPlan;

@Component
public class PdfGenerator {

	public void generate(HttpServletResponse resp, List<PersonPlan> records,File f) throws Exception {

		Document doc = new Document(PageSize.A4);

		PdfWriter.getInstance(doc, resp.getOutputStream());
		PdfWriter.getInstance(doc, new FileOutputStream(f));
		
		
		doc.open();

		Font font = FontFactory.getFont(FontFactory.TIMES_ITALIC);
		font.setSize(20);

		Paragraph p = new Paragraph("Persons Plan", font);

		p.setAlignment(p.ALIGN_CENTER);

		doc.add(p);

		PdfPTable table = new PdfPTable(6);

		table.addCell("ID");
		table.addCell("Person Name");
		table.addCell("Plan Name");
		table.addCell("Plan Status");
		table.addCell("Start Date");
		table.addCell("End Date");
		table.addCell("Benifit Amount");

		
		for (PersonPlan plan : records) {
			table.addCell(String.valueOf(plan.getPersonId()));
			table.addCell(plan.getPersonName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getStartDate() + "");
			table.addCell(plan.getEndDate() + "");
			table.addCell(plan.getBenifitAmt() + "");
		}
		doc.add(table);

		doc.close();
	}

}
