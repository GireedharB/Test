package com.tutorialpoint.qa.utlities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class TutorialPointRe {
	@DataProvider(name= "tutorialpointdata")
	public String[][] getdata(Method m) throws EncryptedDocumentException, IOException {
		String execelSheetName = m.getName();
		File fe = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialpoint\\qa\\testdata\\tutorialpoint.xlsx");
		FileInputStream fis = new FileInputStream(fe);
		Workbook wb = WorkbookFactory.create(fe);
		Sheet sheetName	 = wb.getSheet(execelSheetName);
		int TotalRows = sheetName.getLastRowNum();
		Row rowCells = sheetName.getRow(0);
		int TotalColumns = rowCells.getLastCellNum();
		System.out.println("Total no of rows:"+TotalRows );
		System.out.println("Total no of columns :" +TotalColumns);
		DataFormatter format = new DataFormatter();
		String testData[][] = new String [TotalRows][TotalColumns];
		for(int i=1; i<=TotalRows; i++) {
			for(int j=0;j< TotalColumns; j++) {
				testData[i-1][j]= format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
				
			}
		}
		return testData;
		
		
	}

}


