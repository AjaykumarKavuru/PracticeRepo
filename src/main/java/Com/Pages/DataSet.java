package Com.Pages;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import Com.BaseTest.BaseTest;

public class DataSet extends BaseTest{
	@DataProvider(name = "LoginData")
	public String[][] LogintoHomePage() throws IOException {
		
		String Path = "C:\\Users\\ajay7\\eclipse-workspace\\POM\\src\\test\\resources\\TrailData.xlsx";

//		String Path = System.getProperty("user.dir")+"/src/test/resources/TrailData.xlsx";
		
		ExcelUtilities excelutil = new ExcelUtilities(Path);
		int Totalrows = excelutil.getrowcount("Sheet1");
		int Totalcols = excelutil.getcellcount("Sheet1", 0);
		
		System.out.println("No of rows: "+Totalrows+" |  No of columns: "+Totalcols);
		String Logindata[][] = new String[Totalrows][Totalcols];
		

		for(int i=1;i<=Totalrows;i++) {
			for(int j=0;j<Totalcols;j++) {
				Logindata[i-1][j]=excelutil.getcelldata("Sheet1", i, j);
			}
		}
		return Logindata;
	}
}
