package com.crm.data;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class CrmData {
	
	public HSSFSheet getCrmData() throws IOException {
		FileInputStream dfis = new FileInputStream("test data\\CrmData.xls");
		HSSFWorkbook workbook = new HSSFWorkbook(dfis);
		HSSFSheet sheet = workbook.getSheet("sheet1"); 
		return sheet;
	}
	
	
	
	
}
