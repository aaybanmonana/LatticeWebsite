package TestCase.Utilities;

import java.awt.Desktop;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.Base;

public class ExtentReportNG implements ITestListener {
	String reportName;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent; 
	public ExtentTest test;
	
	@Override  
	public void onStart(ITestContext context) {  
	String currentTimeStamp=new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
	
	reportName="Test Summary Report-" +currentTimeStamp+".html";
	//UI of the report
	sparkReporter=new ExtentSparkReporter(".\\reports\\"+reportName );  //location of the report
	// title of the report
	//sparkReporter.config().setDocumentTitle("Codenbox Automation Report");
	//name of the report 
	sparkReporter.config().setReportName("Lattice Web Test Summary");
	sparkReporter.config().setTheme(Theme.DARK); //select UI look or theme type
	
	// generate common info in to the report. Ex: application+module+tester+environment name, 
	extent=new ExtentReports();
	extent.attachReporter(sparkReporter);
	extent.setSystemInfo("Application", "LatticeWeb");
	extent.setSystemInfo("Module", "Admin");
	extent.setSystemInfo("Environment", "QA");
	extent.setSystemInfo("User Name", System.getProperty("user.name"));
	
	//automatically get OS & Browser name from testNG xml file
	String osName=context.getCurrentXmlTest().getParameter("OS");
	extent.setSystemInfo("Operating System", osName);
	
	String browserName=context.getCurrentXmlTest().getParameter("Browser");
	extent.setSystemInfo("Browser Name", browserName);
	
	//add groups name into the report if available in testng.xml file
	List <String>includedGroups=context.getCurrentXmlTest().getIncludedGroups();
	if(!includedGroups.isEmpty()) {
		extent.setSystemInfo("Groups Name", includedGroups.toString());
	}
	
	}  
	 
	@Override  
	public void onTestSuccess(ITestResult result) {  
	 // creating test case entries & update status of the test method
 // in to the report using ExtentTest class
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups()); //display groups in report
		test.log(Status.PASS, result.getName()+"_"+"got successfully executed");
	}  
	  
	@Override  
	public void onTestFailure(ITestResult result) {  
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.FAIL, result.getName()+"_"+"got failed.The error is_"+result.getThrowable());
		
		Base bs = new Base(); // <-------------------------------------------------------------- try
		
//		 try {
//			String screenshotpath= bs.getScreenshot(result.getName());
//			test.addScreenCaptureFromPath(screenshotpath);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		try {
			String screenPath= bs.getScreenshot(result.getName());
			test.addScreenCaptureFromPath(screenPath);
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}  
	  
	@Override  
	public void onTestSkipped(ITestResult result) {  
		test=extent.createTest(result.getTestClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName()+"_"+"got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage()); 
	}  
	  
	@Override  
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {  
	  
	}  
	  
	@Override  
	public void onFinish(ITestContext context) {  
		extent.flush();
		
		// auto open the generated report
		String reportPath=System.getProperty("user.dir")+"\\reports\\"+reportName;
		File extentReport=new File(reportPath);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		}catch (Exception e) {
			e.printStackTrace();
		}
	}  

}

	

