package Com.Pages;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import Com.BaseTest.BaseTest;

public class ExcelUtilities extends BaseTest{
	
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFCell cell;
	public XSSFRow row;
	public XSSFSheet sheet;
	public XSSFWorkbook workbook;
	public String path = null;
	
	public ExcelUtilities(String ExcelPath) {
		path = ExcelPath;
	}
	
	public int getrowcount(String Sheet) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(Sheet);
		int rows = sheet.getLastRowNum();
		
		workbook.close();
		fi.close();
		return rows;
	}
	public int getcellcount(String Sheet,int rownum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(Sheet);
		row = sheet.getRow(rownum);
		int cols = row.getLastCellNum();
		
		workbook.close();
		fi.close();
		return cols;
	}
	public String getcelldata(String Sheet,int rownum,int colnum) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(Sheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String Data;
		
		try {
		Data = formatter.formatCellValue(cell);
		}catch(Exception e) {
			Data = "";
		}
		
		workbook.close();
		fi.close();
		return Data;
	}
	
	public void setcellvalue(String Sheet, int rownum, int colnum, String data) throws IOException {
		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);
		sheet = workbook.getSheet(Sheet);
		row = sheet.getRow(rownum);
		cell = row.getCell(colnum);
		cell.setCellValue(data);
		
		fo = new FileOutputStream(path);
		workbook.write(fo);
		
		workbook.close();
		fi.close();
		fo.close();
		
	}

}
