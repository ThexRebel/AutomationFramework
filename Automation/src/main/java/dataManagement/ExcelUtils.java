package dataManagement;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static void getExcelData(String excelFileName,String sheetName) {
		try
		{
			if(!excelFileName.contains(".xlsx"))
				excelFileName=excelFileName+".xlsx";
			String path = System.getProperty("user.dir")+"\\TestDataTables\\"+excelFileName;
			System.out.println(path);
			FileInputStream file = new FileInputStream(new File(path));

			//Create Workbook instance holding reference to .xlsx file
			XSSFWorkbook workbook = new XSSFWorkbook(file);

			//Get first/desired sheet from the workbook
			XSSFSheet sheet = workbook.getSheet(sheetName);

			//Iterate through each rows one by one
			Iterator<Row> rowIterator = sheet.iterator();
			while (rowIterator.hasNext()) 
			{
				Row row = rowIterator.next();
				//For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();

				while (cellIterator.hasNext()) 
				{
					Cell cell = cellIterator.next();
					//Check the cell type and format accordingly
					switch (cell.getCellType()) 
					{
					case NUMERIC:
						System.out.print(cell.getNumericCellValue() + "t");
						break;
					case STRING:
						System.out.print(cell.getStringCellValue() + "t");
						break;
					case BOOLEAN:
						System.out.print(cell.getBooleanCellValue() + "t");
		                break;
					}
				}
				System.out.println("");
			}
			file.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}
