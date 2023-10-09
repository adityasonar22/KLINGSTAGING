package websitePanel;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import utilityPackage.MyMethods;


public class KlingsStaging extends ParentWebsitePanel1  {
	
	@BeforeTest
	public void checkTestCase() {
		
	boolean output = MyMethods.checkTestCaseEcecution(tsa, "Sheet1",this.getClass().getSimpleName());
	
	if(!output) {
		
		throw new SkipException("Execution mode of the test cases"+this.getClass().getSimpleName()+"is set to NO");
	}
}
	
	@Test
	public void testKlingsStaging() throws InterruptedException {
		
		driver.get(sitedata.getProperty("url"));
		logs.info("URL is Loaded..!");
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/div/div/div/div/button[1]")).click();
		logs.info("User click on Login Button on Home Page");
		
		driver.findElement(By.xpath("//*[@id=\"controlled-tab-example-tabpane-login\"]/div/form/div/div[1]/input")).sendKeys("demo1");
		logs.info("User enter Email/UserName");
		
		driver.findElement(By.xpath("//*[@id=\"controlled-tab-example-tabpane-login\"]/div/form/div/div[2]/input")).sendKeys("demo@123");
		logs.info("User enter Password");
		
		driver.findElement(By.xpath("//*[@id=\"controlled-tab-example-tabpane-login\"]/div/form/div/button")).click();
		logs.info("User LogIN Sucessfully");
		Thread.sleep(10000);
		
		WebElement spimmwheels = driver.findElement(By.xpath("//*[@id=\"justify-tab-example-tabpane-Inhouse\"]/div/div[1]/div/a"));
		spimmwheels.click();
		Thread.sleep(5000);
		logs.info("User click on Spinn Wheels Game");
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[1]/div/div[2]/form/div[1]/input")).clear();
		Thread.sleep(3000);
		logs.info("User clear existing amount");
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[1]/div/div[2]/form/div[1]/input")).sendKeys("3");
		Thread.sleep(1000);
		logs.info("User enter amount");
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[2]/div[1]/div[1]/button")).click();
		logs.info("User Select Spinn Wheels");
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[1]/div[2]/div[2]/div[1]/div[1]/div/div[1]/div/div[2]/form/button")).click();
		logs.info("User click on Spinn Wheels Button");
	}
}	
		
		
	
	


