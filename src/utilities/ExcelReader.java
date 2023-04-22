package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	
	public ExcelReader(String filepath) throws IOException
	{
		FileInputStream fis;
				
		try {
			
			fis = new FileInputStream(filepath);
			workbook =new XSSFWorkbook(fis);
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		}
	}

	public String getData(int Sheetnumber, int row, int col) 
	{
		sheet = workbook.getSheetAt(Sheetnumber);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		// return the data
		return data;
	}
	public int  getRowCount(int sheetNumber) {
		int rowCount = workbook.getSheetAt(sheetNumber).getLastRowNum();
		// return the rowCount
		return rowCount;
		
	}
}
