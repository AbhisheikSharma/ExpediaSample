package utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReaderClass {
	protected static XSSFWorkbook wb;
	protected static String testdatafilepath = "./TestData/testdata.xlsx";
	
	
	public static void initializeDataReaderClass() {
		File file = new File(testdatafilepath);
		try {
			FileInputStream fis = new FileInputStream(file);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Issues with reading test data");
			e.printStackTrace();
		}
		System.out.println("Connection to Test Data file established");
	}
	
	public static String getData(int sheetindex, int rownum, int colnum) {
		String data = wb.getSheetAt(sheetindex).getRow(rownum).getCell(colnum).getStringCellValue();
		return data;
		
	}
}
