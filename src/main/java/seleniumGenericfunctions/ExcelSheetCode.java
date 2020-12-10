package seleniumGenericfunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelSheetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		File file = new File(
				"C:/Users/Pratik/Desktop/RestAssured/SeleniumFramework/src/main/resources/ExcelData/challenge.xlsx");
		try {
			FileInputStream fis = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		try {
			XSSFWorkbook wb = new XSSFWorkbook(file);
			XSSFSheet sheet = wb.getSheet("Sheet1");
			
			 int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
			for(int rowdata = 0; rowdata<rowCount+1; rowdata++)
			{
				Row row = sheet.getRow(rowdata);
				for(int coldata = 0; coldata< row.getLastCellNum(); coldata++)
				{
					if(row.getCell(coldata).getCellType() == CellType.NUMERIC)
					{
						System.out.println(row.getCell(coldata).getNumericCellValue() + "||");
					}
					
					else
					{
						System.out.println(row.getCell(coldata).getStringCellValue() + "||");
					}
				}
				System.out.println();
			}
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
}
