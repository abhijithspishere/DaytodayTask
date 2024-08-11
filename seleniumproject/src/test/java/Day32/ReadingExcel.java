package Day32;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {
	
	//File-->Workbook-->Sheets-->Rows-->Cells

	public static void main(String[] args) throws IOException {
	
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1"); // or we can use index of sheet starts from 0
		//workbook.getSheetAt(0);
		int totalRows = sheet.getLastRowNum();//identifies how many no of Rows Row numbering starts from 0
		
		int totalCol = sheet.getRow(1).getLastCellNum();	//only getting row we can find the cell thats why getRow(1) used.
		
		System.out.println("Total Rows : "+totalRows);
		
		System.out.println("Total Coloumns : "+totalCol);
		
		for(int r=0;r<=totalRows;r++)
		{
			XSSFRow currentRow = sheet.getRow(r);
			
			for(int c =0; c<totalCol;c++)
			{
				XSSFCell currentCell = currentRow.getCell(c);
				
				String CurrentCellValue = currentCell.toString()	;	
				
				//OR
				//String CurrentCellValue = currentRow.getCell(c).toString();
				
				System.out.print(CurrentCellValue+"          ");
			}
			
			System.out.println();
		}
		
		workbook.close();
		
		file.close();
				
	}

}
