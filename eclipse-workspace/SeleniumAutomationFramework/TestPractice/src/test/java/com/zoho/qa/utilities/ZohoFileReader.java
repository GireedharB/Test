package com.zoho.qa.utilities;

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

public class ZohoFileReader {
	
	@DataProvider(name = "logintestdata")
	public String[][] getdata(Method m) throws EncryptedDocumentException, IOException   {
		String execelSheetName = m.getName();
		File f = new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\zoho\\qa\\testdata\\zohologindata.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(execelSheetName);
		int totalrows = sheetName.getLastRowNum();
		System.out.println(totalrows);
		Row rowcells = sheetName.getRow(0);
		int totalcolumns = rowcells.getLastCellNum();
		System.out.println(totalcolumns);
		DataFormatter format = new DataFormatter();
		String testData[][] = new String [totalrows][totalcolumns];
		
		for(int i=1;i<=totalrows;i++){
			for(int j=0;j<totalcolumns; j++ ) {
				testData[i-1][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i-1][j]);
				
				}
		}
		return testData;

}
}



