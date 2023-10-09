package utilityPackage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
		
		
		
		
		
		
		public static Object[][] getTestData(ExcelFileReader data, String sheetName) {
		    List<List<Object>> testData = new ArrayList<>();
		    List<Integer> integers = data.readIntegers(sheetName, 0); // Integers in the first column
		    List<String> xpaths = data.readXPaths(sheetName, 1); // Xpaths in the second column

		    int size = Math.min(integers.size(), xpaths.size());

		    for (int i = 0; i < size; i++) {
		        List<Object> rowData = new ArrayList<>();
		        rowData.add(integers.get(i));
		        rowData.add(xpaths.get(i));
		        testData.add(rowData);
		    }

		    Object[][] myData = new Object[testData.size()][2]; // 2 columns: integer and xpath

		    for (int i = 0; i < testData.size(); i++) {
		        myData[i] = testData.get(i).toArray();
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
		
	
		
	




