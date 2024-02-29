package Utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	static XSSFWorkbook book=new XSSFWorkbook();
	static XSSFSheet sheet;
	
	public static void createSheet(String sheetName) {
		//creating sheet
		sheet=book.createSheet(sheetName);
	}
	static FileOutputStream fo;
	static FileInputStream fi;
	public static String[] readCarEmiData() throws IOException {
		//reading CarEmi Input Data
		fi=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\input_Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet1 = workbook.getSheet("InputData");
		XSSFRow row1 = sheet1.getRow(0);
		String[] carEmiData= {row1.getCell(0).toString(),row1.getCell(1).toString(),row1.getCell(2).toString()};
		return carEmiData;
	}
	public static String[] readHomeEmiData() throws IOException {
		//reading HomeEmi Input Data
		fi=new FileInputStream(System.getProperty("user.dir")+"\\TestData\\input_Data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet1 = workbook.getSheet("InputData");
		XSSFRow row1 = sheet1.getRow(1);
		String[] homeEmiData= {row1.getCell(0).toString(),row1.getCell(1).toString(),row1.getCell(2).toString(),
				row1.getCell(3).toString(),row1.getCell(4).toString(),row1.getCell(5).toString()};
		return homeEmiData;
	}
	
	public static void write(int rownum, String[] data)throws IOException {

		//Creating  the row
		XSSFRow row =sheet.createRow(rownum); 
		//Setting the data in the column
		for(int i=0;i<data.length;i++) {
			row.createCell(i).setCellValue(data[i]);
		}
		//writing to results file
		fo=new FileOutputStream(System.getProperty("user.dir")+"\\TestData\\results.xlsx");
		book.write(fo);
		

	}
	public static void closeBook() throws IOException {
		//closing workbook and files
		book.close();
		fo.flush();
		fo.close();
	}
}
