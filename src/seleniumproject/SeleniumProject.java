package seleniumproject;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumProject {

	public static void main(String[] args) throws IOException, InterruptedException, ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		// Code for removing push notification:
				//Create a class to handle external elements.  (Alerts)
				
		ChromeOptions options = new ChromeOptions();
				
		options.addArguments("--disable-notifications");
		
	
				
		WebDriver driver = new ChromeDriver(options);
				
		driver.manage().window().maximize();
				
		driver.manage().deleteAllCookies();
				
		driver.get("https://www.redbus.com/");
		
		String title = driver.getTitle();
		String url = driver.getCurrentUrl();
		
		String dburl = "jdbc:mysql://localhost:3306/seleniumproject";
		String username = "root";
		String password = "root";
		
         Class.forName("com.mysql.cj.jdbc.Driver");
			
		Connection con = DriverManager.getConnection(dburl,username,password);
		PreparedStatement ps = con.prepareStatement("insert into webtabs values(?,?)"); // execute query
		ps.setString(1,title);
		ps.setString(2,url);
		ps.executeUpdate();

		// Updated code -> SONAL MITTAL

				// Clear the source text box
				
		driver.findElement(By.xpath("//div[@class='main-wrapper search-box-wrapper']/descendant::input[1]")).clear();
			
			// enter input string in text box
				
		driver.findElement(By.xpath("//div[@class='main-wrapper search-box-wrapper']/descendant::input[1]")).sendKeys("Chennai");
						
		Thread.sleep(2000);
						// capture element form the list
		//driver.findElement(By.xpath("//div[@class='autoFill autosuggest-ul rdc-src']/descendant::li[3]")).click();
						
						// destination
		driver.findElement(By.xpath("//div[@class='main-wrapper search-box-wrapper']/descendant::input[2]")).clear();
				
		driver.findElement(By.xpath("//div[@class='main-wrapper search-box-wrapper']/descendant::input[2]")).sendKeys("Mumbai");
					
		Thread.sleep(2000);
				
		//driver.findElement(By.xpath("//div[@class='autoFill autosuggest-ul rdc-dest']/descendant::li[3]")).click();
					
				//calander
				
		Thread.sleep(3000);
				
		driver.findElement(By.id("date-box")).click();
				
		Thread.sleep(5000);
				
				//Select date
				
		driver.findElement(By.xpath("//div[@class='DatePicker__CalendarContainer-sc-1x9sb82-0 bkhtIz']/descendant::span[41]")).click();
				
		Thread.sleep(5000);	
						   
						   //click on search button
		driver.findElement(By.id("search_butn")).click();

				
				// Upload file using autoIT
		driver.navigate().to("https://www.remove.bg/");
		driver.get("https://www.remove.bg/");
		
		Thread.sleep(3000);
		
		title= driver.getTitle();
		
		url = driver.getCurrentUrl();
		
		ps = con.prepareStatement("insert into webtabs values(?,?)"); // execute query
		ps.setString(1,title);
		ps.setString(2,url);
		ps.executeUpdate();
				
				
		WebElement e1 = driver.findElement(By.xpath("//div[@class='mx-auto w-full px-8 max-w-5xl relative']/descendant::button[1]"));
				
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
				
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='mx-auto w-full px-8 max-w-5xl relative']/descendant::button[1]")));
				
		e1.click();
				
		Runtime.getRuntime().exec("C:\\Users\\USER\\Desktop\\AutoITScripts\\AutoITScript1");
		
		Thread.sleep(10000);
				
		driver.get("https://www.amazon.com/");
		
		title= driver.getTitle();
		
		url = driver.getCurrentUrl();
		
		ps = con.prepareStatement("insert into webtabs values(?,?)"); // execute query
		ps.setString(1,title);
		ps.setString(2,url);
		ps.executeUpdate();
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
				
		WebElement e2 = driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
				
				
		Actions a = new Actions(driver);
				
				
		a.moveToElement(e2).perform();
				
		Thread.sleep(5000);
				
		driver.findElement(By.xpath("(//span[@class='nav-text'])[7]")).click();
				
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
		File destFile = new File("./Screenshots/project.png");

		FileUtils.copyFile(srcFile, destFile); 


	}

}
