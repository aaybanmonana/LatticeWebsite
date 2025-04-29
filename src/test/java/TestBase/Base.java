package TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;


public class Base {
	public static WebDriver driver;
	public Logger logger;

	@BeforeMethod
	@Parameters({"Browser"})
	public void setup(String browserName) {
		
		Properties prop =new  Properties();
		
		logger = LogManager.getLogger();
		
		switch(browserName.toLowerCase()) {
		case "chrome": driver = new ChromeDriver(); break;
		case "firefox": driver = new FirefoxDriver(); break;
		case "edge": driver = new EdgeDriver(); break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://www.latticesemi.com/");
		}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	public String getScreenshot(String methodName) throws IOException {
		String currentTimeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		File srcFile =((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String targetFilepath = System.getProperty("user.dir") + "\\screenshot\\" + methodName + "_" + currentTimeStamp+".png";
		File targetFile = new File(targetFilepath);
		FileUtils.copyFile(srcFile, targetFile);
		return targetFilepath;
	}
	
}
