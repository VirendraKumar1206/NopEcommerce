package NopCommerce_Project;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Extract {
	//It returns a two-dimensional array of Objects (Object[][]).
	public Object[][] getdatafromexel() throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\HP\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\Assign_project\\src\\test\\resources\\project1.xlsx");

		/*
		 * here we are creating a new object of FileInputStream class, named file , to
		 * read the data from the Excel file located at the specified path.
		 * 
		 */

		Workbook book = WorkbookFactory.create(file);

		/*
		 * here we have created a Workbook object (book) by using the
		 * WorkbookFactory.create() method, which takes the FileInputStream (file) as
		 * input. This allows the program to read and manipulate the contents of the
		 * Excel file.
		 */

		Sheet sheet = book.getSheet("Sheet1");

		short Cellsize = sheet.getRow(0).getLastCellNum();
		                             /*
									 * 
									 * here we are retrieving the number of cells (columns) present in the first row of
									 * an Excel sheet and stores that value in a variable named Cellsize.
									 *
									 */

		int rowcount = sheet.getLastRowNum(); /*
												 * here we are getting the total number of rows in an Excel spreadsheet
												 * and stores that value in a variable named rowcount.
												 */
		Object[][] obj = new Object[rowcount][Cellsize];

		/*
		 * here we are creating an object and initializes a two-dimensional array obj to
		 * store data retrieved from the Excel file,
		 */

		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < Cellsize; j++) {
				obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;

	}
}
