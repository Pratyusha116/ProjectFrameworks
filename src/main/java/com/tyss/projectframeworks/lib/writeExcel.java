package com.tyss.projectframeworks.lib;

import java.io.File;
import java.io.FileOutputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class writeExcel {
	public static String writeDataFromExcel() 
	{
		
	
		try {
			File f=new File("D:\\selenium\\projectFrameWork\\src\\test\\resources\\excel\\Book1.xlsx");
			FileOutputStream fos=new FileOutputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook();
			XSSFSheet sh=wb.createSheet();
			sh.createRow(2).createCell(1).setCellValue("admin");
			sh.createRow(2).createCell(2).setCellValue("Test@123");
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return null;
		
	}
	
			

}
