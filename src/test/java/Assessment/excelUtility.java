package Assessment;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelUtility {
	
	public ArrayList<String> getExcel() throws IOException {
	FileInputStream fi = new FileInputStream("C://Users//Tawanda//Documents//Automation//Datasheet//TestData.xlsx");
	XSSFWorkbook workbook= new XSSFWorkbook(fi);
	
	ArrayList<String> dataStore= new ArrayList<String>();
	
	int sheets= workbook.getNumberOfSheets();
	
	for(int i=0;i<sheets;i++) {
		
		
		if(workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
			
		XSSFSheet sheet= workbook.getSheetAt(i);
		
		Iterator<Row> rows = sheet.iterator();
		
		while(rows.hasNext()) {
		Row firstrow= rows.next();
		
		Iterator<Cell> cell= firstrow.cellIterator();
		while(cell.hasNext()) {
			
			Cell value= cell.next();
			
			if(value.getStringCellValue().equalsIgnoreCase("FName1")||value.getStringCellValue().equalsIgnoreCase("FName2")) {
				
				dataStore.add(value.getStringCellValue());
			
				//
			}
			
		}
		
		}
		}
		
	}
	for(int k=0;k<dataStore.size();k++) {
		
		System.out.println(dataStore.get(k));
		
	}
	
	return dataStore;
	}
//aa
}
