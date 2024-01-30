package aashi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Extract {
	public Object[][] getdatafromexel() throws EncryptedDocumentException, IOException{
		FileInputStream file = new FileInputStream("C:\\Users\\HP\\Documents\\workspace-spring-tool-suite-4-4.21.0.RELEASE\\Assign_project\\src\\main\\resources\\AssiBook1.xlsx");
		
		Workbook book = WorkbookFactory.create(file); //here we are using workbookfactory.create method to access the file after it, i will access sheet of excelsheet that is stored inside the file
		
		 Sheet sheet = book.getSheet("Sheet1");
		
		 short Cellsize = sheet.getRow(0).getLastCellNum();
		
		      int rowcount = sheet.getLastRowNum();
		     
	           Object[][] obj = new Object [rowcount][Cellsize];
		     
		      for(int i=0; i<rowcount; i++) {
		    	  for(int j=0; j<Cellsize; j++) {
		    		obj[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();
		    	  }
		      }
		      return obj;
		
	
	}
}
