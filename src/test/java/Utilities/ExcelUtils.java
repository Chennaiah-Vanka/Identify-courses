package Utilities;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static final Exception IOException = null;
	 
	public static String getExcelValue(int row,int col) throws Exception {
		   FileInputStream fi=new FileInputStream(System.getProperty("user.dir") + "\\test-data\\data.xlsx");
		   try (XSSFWorkbook wo = new XSSFWorkbook(fi)) {
			XSSFSheet sh=wo.getSheetAt(0);
			   XSSFRow ro=sh.getRow(row);
			   XSSFCell cell= ro.getCell(col);
			   String data;
			    try {
			    	String data1=cell.toString();
//			    	System.out.println(data1);
			    	data=data1.replaceAll("\\.0$","");
			    }catch(Exception e) {
			    	data="";
			    }
			    return data;
		    }catch(Exception e) {
			 throw IOException;
		    }
		   
	   }
}
