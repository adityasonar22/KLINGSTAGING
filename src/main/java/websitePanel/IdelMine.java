package websitePanel;


import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;




import utilityPackage.MyMethods;


public class IdelMine extends ParentWebsitePanel1  {
	
	@BeforeTest
	public void checkTestCase() {
		
	boolean output = MyMethods.checkTestCaseEcecution(tsa, "Sheet1",this.getClass().getSimpleName());
	
	if(!output) {
		
		throw new SkipException("Execution mode of the test cases"+this.getClass().getSimpleName()+"is set to NO");
	}
}
	
	@Test(dataProvider="getTestDataFromXLS")
	public void testIdelMine(String userName) throws InterruptedException {
		
		driver.get(sitedata.getProperty("url"));
		logs.info("Admin URL is loaded");
		Thread.sleep(3000);
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userlist/div[2]/div[1]/label/input"));
		email.sendKeys(userName);
		Thread.sleep(1000);
		email.sendKeys(Keys.ENTER);
		logs.info("Admin enter user email address: "+userName);
		Thread.sleep(5000);
		
		WebElement clickUseremail =driver.findElement(By.linkText(userName));
		Thread.sleep(2000);
		clickUseremail.click();
		logs.info("Admin click on user email id to edit the profile");
		Thread.sleep(1000);
		
		Set<String> windowID = driver.getWindowHandles();
		Iterator<String> it = windowID.iterator();
		String mainWindow = it.next();
		String userWindow = it.next();
		driver.switchTo().window(userWindow);
		
		Thread.sleep(3000);
		
		String beforeUserBalance = driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userdetails/div[3]/div[6]/div/div/div/p[2]")).getText();
		logs.info("User Balance is: "+beforeUserBalance);
		
		Thread.sleep(2000);
		
		// Convert the string to a double (assuming it contains a numeric value)
		double userBalance = Double.parseDouble(beforeUserBalance);

		// Divide the userBalance by 2
		double result = userBalance / 2;

		// Convert the result back to a string
		String resultAsString = Double.toString(result);

		// Log the result as info
		logs.info("After division Balance of USER: " + resultAsString);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userdetails/div[4]/form/div/div[1]/input[2]")).click();
		logs.info("Admin click on Minus Button");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userdetails/div[4]/form/div/div[2]/label/input")).sendKeys(resultAsString);
		logs.info("Admin enter after division User balance:"+resultAsString);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userdetails/div[4]/form/div/app-state-button/button")).click();
		logs.info("Admin click on Submit Button");
		Thread.sleep(2000);
		
		driver.close();
		Thread.sleep(2000);
		driver.switchTo().window(mainWindow);
		
		driver.navigate().refresh();
		Thread.sleep(2000);
		
		WebElement email1=driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userlist/div[2]/div[1]/label/input"));
		email1.sendKeys(userName);
		Thread.sleep(2000);
		email1.sendKeys(Keys.ENTER);
		logs.info("Admin Enter Email Address");
		Thread.sleep(2000);
		
		WebElement click2 =driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userlist/div[3]/div/ngx-datatable/div/datatable-body/datatable-selection/datatable-scroller/datatable-row-wrapper/datatable-body-row/div[2]/datatable-body-cell[2]/div/a"));
	    click2.click();
	    logs.info("Admin Click on 1V1 account button");
	    Thread.sleep(2000);
	    
	    Set<String> windowID1 = driver.getWindowHandles();
		Iterator<String> it1 = windowID1.iterator();
		String mainWindow1 = it1.next();
		String userWindow1 = it1.next();
		driver.switchTo().window(userWindow1);
		
		String v1BeforeBal=driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userdetails1v1/div[3]/div[6]/div/div/div/p[2]")).getText();	
	    logs.info("Before addition in 1v1 Total Balance"+v1BeforeBal);
	    Thread.sleep(2000);
	    
	    driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userdetails1v1/div[4]/form/div/div[1]/input[1]")).click();
	    logs.info("Admin click on Add Button");
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userdetails1v1/div[4]/form/div/div[2]/label/input")).sendKeys(resultAsString);
	    logs.info("Admin enter amount in 1V1: "+resultAsString);
	    Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userdetails1v1/div[4]/form/div/app-state-button/button")).click();
	    logs.info("Admin click on Submit Button");
	    Thread.sleep(5000);
	    
	    String v1AfterBal=driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userdetails1v1/div[3]/div[6]/div/div/div/p[2]")).getText();	
	    logs.info("After addition in 1v1 Total Balance"+v1AfterBal);
	    Thread.sleep(2000);
	    
	    driver.close();
	    
	    Thread.sleep(2000);
	    
	    driver.switchTo().window(mainWindow);
	    
	    Thread.sleep(1000);
	    
	    email = driver.findElement(By.xpath("//*[@id=\"app-container\"]/main/div/app-userlist/div[2]/div[1]/label/input"));
	    email.clear();
	    
	}
	
	@DataProvider
	public Object[][] getTestDataFromXLS() {
		
		return MyMethods.getTestData(tsa, "IdelMine");
	}
	
}	
		
		
	
	


