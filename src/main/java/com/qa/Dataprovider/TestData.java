package com.qa.Dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class TestData {

	public static void main(String[] args) throws IOException {
		TestData ob=new TestData();
		Object[][] obj=ob.getTestData(0);
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				System.out.println(obj[i][j]);
			}
		}
	}

	
	public Object[][] getTestData(int index) throws IOException{
		File file=new File("C:\\Users\\rageaholic\\eclipse-workspace2\\MySeleniumProject\\src\\"
				+ "main\\java\\com\\qa\\TestData\\input7Noutput.xls");
		FileInputStream ip=new FileInputStream(file);
		HSSFWorkbook wb=new HSSFWorkbook(ip);
		HSSFSheet sheet=wb.getSheetAt(0);
		int rownum=2;
		Object[][] Data=new Object[3][];
		for(int i=0;i<3;i++) {
			Row row=sheet.getRow(i+1);
			for(int j=0;j<2;j++) {
				//Cell cell=row.getCell(j);
				if(row==null)
                    Data[i][j]= "";
                else
                {
                    Cell cell= row.getCell(j);
                    if(cell==null)
                        Data[i][j]= ""; //if it get Null value it pass no data 
                    else
                    {
                    	switch(cell.getCellType()) {
                    	case NUMERIC:
                    		  Data[i][j]=cell.getStringCellValue();
                    	case STRING:
                    		System.out.println(cell.getStringCellValue());
                    		Data[i][j]=cell.getStringCellValue();
                    		
                    	}
                                              //This formatter get my all values as string i.e integer, float all type data value
                    }
                }
			}
		}
		
		return Data;
			
}
}