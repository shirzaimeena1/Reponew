package utilities;

	import java.io.FileInputStream;
	import java.io.FileNotFoundException;
	import java.io.IOException;
	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;
	public class ExcelUtility {
		// taking the pat of excel file that we creat under input data
		public static String pathToExcelfile = ".\\src\\test\\resources\\inputData\\CreatAccountData.xlsx";
		public static Workbook book;  // these are two classes (work book and sheet) which provided by appachi poi to read data from excel
		public static Sheet sheet;    //
		
		// we creat  this methoed of o two dimention array to read from row and coum of excel
		public static Object[][] getExcelData(String sheetName) {
			try {
				FileInputStream file = new FileInputStream(pathToExcelfile); //
				book = WorkbookFactory.create(file); // it open the work book
				sheet = book.getSheet(sheetName);  // we are inside the sheet
				// This line of code will read all values in excel till last row and last column
				Object data[][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
				
				// the below lop get the data and pass to two dimention array.
				for (int i = 0; i < sheet.getLastRowNum(); i++) {
					for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {
						data[i][j] = sheet.getRow(i + 1).getCell(j).toString(); //
					}  // the reason we put i+1 becuae i should read data from second row
				}
				return data;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (InvalidFormatException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
	

}

