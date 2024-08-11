package Day32;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class CreatingandWritingDatainExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"//testdata//myfile.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		
		XSSFSheet sheet = workbook.createSheet();
		
		//Creating row and cells and updating data in cells Without Looping statement 
		
		
		/*  XSSFRow row1 = sheet.createRow(0);
		  
		  row1.createCell(0).setCellValue("Welcome");
		  row1.createCell(1).setCellValue("Neelu");
		  row1.createCell(2).setCellValue("From Mom");
		  
		  XSSFRow row2 = sheet.createRow(1);
		  
		  row2.createCell(0).setCellValue("Hai");
		  row2.createCell(1).setCellValue("This is ");
		  row2.createCell(2).setCellValue("ASP");
		  */
		
		//Creating Rows, Cells and Updating Data With Looping Statement
		
		Scanner sc = new Scanner (System.in);
		
		for(int r=0; r<=3; r++)
			
		{
			XSSFRow CurrentRow = sheet.createRow(r);
			
			for(int c=0; c<3; c++)
			{
				System.out.println("Enter the data");
				
				String Value = sc.next();
				
				CurrentRow.createCell(c).setCellValue(Value);
			}
		}
		 
		
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("Writing Done......");

	}

}
