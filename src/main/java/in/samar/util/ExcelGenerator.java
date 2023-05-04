package in.samar.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;

import in.samar.entity.PersonPlan;

@Component
public class ExcelGenerator {

	public void generate(HttpServletResponse resp,List<PersonPlan> records,File file) throws Exception {
		
		File f=new File("Reports.xls");
		
		Workbook workbook = new HSSFWorkbook();
		Sheet sheet = workbook.createSheet("Reports-data");
		Row headerRow = sheet.createRow(0);

		headerRow.createCell(0).setCellValue("ID");
		headerRow.createCell(1).setCellValue("Person Name");
		headerRow.createCell(2).setCellValue("Plan Name");
		headerRow.createCell(3).setCellValue("Plan Status");
		headerRow.createCell(4).setCellValue("Plan Start Date");
		headerRow.createCell(5).setCellValue("Plan End Date");
		headerRow.createCell(6).setCellValue("Benifit Amount");

		

		int dataRowIndex = 1;

		for (PersonPlan plan : records) {
			Row dataRow = sheet.createRow(dataRowIndex);
			dataRow.createCell(0).setCellValue(plan.getPersonId());
			dataRow.createCell(1).setCellValue(plan.getPersonName());
			dataRow.createCell(2).setCellValue(plan.getPlanName());
			dataRow.createCell(3).setCellValue(plan.getPlanStatus());
			dataRow.createCell(4).setCellValue(plan.getStartDate());
			dataRow.createCell(5).setCellValue(plan.getEndDate());
			
			if(plan.getBenifitAmt()!=null) {
				dataRow.createCell(6).setCellValue(plan.getBenifitAmt());
			}else {
				dataRow.createCell(6).setCellValue("N/A");
			}
			
			
			dataRowIndex++;
		}
		
		FileOutputStream fos=new FileOutputStream(f);
		workbook.write(fos);
		fos.close();
		
		ServletOutputStream outputStream = resp.getOutputStream();
		workbook.write(outputStream);
		workbook.close();
	}
}
