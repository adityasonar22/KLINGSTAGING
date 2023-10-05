package utilityPackage;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;



import basePackage.BaseInit;

	public class MyMethods extends BaseInit {
		
		public static void signIn() throws InterruptedException {
			
		}
		
		public static void signOUT() {
			
		}
		
		/*
		
		public static boolean checkTestExecution() {
			ExcelFileReader data = new ExcelFileReader("Path of your TestSuite.xlsx");
			int rows = data.totalRow("sheetName");
			 for(int row=1;row<rows;row++) {
			  String testSuiteName = data.getData("SheetName", row, 0);
			   if(testSuiteName.equalsIgnoreCase("TestSuiteC")){
			    String exeMode=data.getData("testSuiteName", row, 2);
			     if(exeMode.equalsIgnoreCase("Y"))
			      return true;
			      else
			      return false;
		}
	}return false;
}
		*/
		
		public static boolean checkTestSuiteExecution(ExcelFileReader data, String sheetName, String testSuiteName) {
			int rows = data.totalRow(sheetName);
			for(int row=1;row<rows;row++) {
				String testsuiteName = data.getData(sheetName, row, 0);
					if(testSuiteName.equalsIgnoreCase(testsuiteName)) {
						String exeMode = data.getData(sheetName, row, 2);{
							if(exeMode.equalsIgnoreCase("Y")) 
								return true;
							else 
								return false;
				}
			}
		}return false;
	}	
			
			
		public static boolean checkTestCaseEcecution(ExcelFileReader data, String sheetName, String testCaseName) {
				int rows =data.totalRow(sheetName);
				for(int row=1;row<rows;row++) {
					String testcaseName = data.getData(sheetName, row, 0);
						if(testCaseName.equalsIgnoreCase(testcaseName)) {
							String exeMode = data.getData(sheetName, row, 2);{
								if(exeMode.equalsIgnoreCase("Y"))
									return true;
								else
									return false;
						 }
			         }
	              }return false;
			}	
		
		
		public static Object[][] getTestData(ExcelFileReader data, String sheetName) {
			
			int cols = data.totalColumn(sheetName);
			int rows = data.totalRow(sheetName);
			
			Object[][] myData = new Object[rows-1][cols];
			
			for(int row=1;row<rows;row++) {
				
				for(int col=0;col<cols;col++) {
					
					myData[row-1][col] = data.getData(sheetName, row, col);
				}
			}
			
			return myData;
		}
		
		
		public static String getScreenShot(String imageName, WebDriver driver) {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File scrFile = ts.getScreenshotAs(OutputType.FILE);
				String path = System.getProperty("user.dir") + "\\src\\main\\resources\\screenShots\\" + imageName + System.currentTimeMillis() + ".png";
				// System.out.println(path);
				File destination = new File(path);
				try {
					FileHandler.copy(scrFile, destination);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
				return path;
			}
		
}
		
	
		
	




