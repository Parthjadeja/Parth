package testcases;


	import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
//import static org.testng.Assert.assertSam

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Lib.Exceldataconfig;
import PAGES.Registration;
import PAGES.AccountHistory_attributes;
import PAGES.Loginattributes;
import PAGES.PayViewBill_attributes;
import Helper.BrowserFactory;
import org.openqa.selenium.WebDriver;


public class pagefactory_testcase 
{

	
	@Test (dataProvider="dp1",priority = 1) 
	
	public void Checkloginprocess(String username, String Password) throws InterruptedException
	{
		
		WebDriver driver = BrowserFactory.startBrowser("chrome","http://eversource.com/");
		Loginattributes login = PageFactory.initElements(driver, Loginattributes.class);
		
		login.territory("connecticut");
		
		driver.manage().window().maximize();
	//	Dimension di = new Dimension(400,600);
	//	driver.manage().window().setSize(di);
	
		login.login1(username,Password);
		
		System.out.println("PAGE CHECK - Login is working Fine - PASS");
	}
	
	

	@Test (priority = 4)
	
	public void Checkregistrationprocess() 
	
	{
		
		WebDriver driver = BrowserFactory.startBrowser("chrome","http://eversource.com/");
		Loginattributes login = PageFactory.initElements(driver, Loginattributes.class);
		
		login.territory("newhampshire");
		driver.manage().window().maximize();
		
		Registration reg = PageFactory.initElements(driver, Registration.class);
		
		reg.entername("Tom","Brady");
		reg.enteremail("abc@gmail.com", "abc@gmail.com", "800-222-2000");
		reg.enterusernamepassword("Brady", "#Eversource1", "#Eversource1");

System.out.println("PAGE CHECK - Registeration working fine - PASS");
			
	}

	
	
	@Test (dataProvider="dp2", priority = 2)
	
		public void CheckPayViewBill(String username, String Password) throws InterruptedException
{
		
		WebDriver driver = BrowserFactory.startBrowser("chrome","http://eversource.com/");
		Loginattributes login = PageFactory.initElements(driver, Loginattributes.class);
		login.territory("westernmass");
		driver.manage().window().maximize();
	
		login.login1(username,Password);
		
		
		PayViewBill_attributes pay = PageFactory.initElements(driver, PayViewBill_attributes.class);
		pay.Paybill();
		
		System.out.println("PAGE CHECK - Pay View Bill working fine - PASS");
	}
	
	
	@Test (dataProvider="dp2",priority = 3)
	
	public void CheckAccountHistory(String username, String Password) throws InterruptedException
{
	
	WebDriver driver = BrowserFactory.startBrowser("chrome","http://eversource.com/");
	Loginattributes login = PageFactory.initElements(driver, Loginattributes.class);
	login.territory("easternmass");
	driver.manage().window().maximize();

	login.login1(username,Password);
	
	AccountHistory_attributes accounthistory = PageFactory.initElements(driver, AccountHistory_attributes.class);
	accounthistory.AccountHistory1();
	
	System.out.println("PAGE CHECK - Account History working fine - PASS");
}
	
	
	
	
	@DataProvider (name = "dp1")
	
	public Object[][] getData1()
	
	{
		//i stands for number for times the test case should run
		//j stands for number of parameters it should send in one go
	Exceldataconfig config=new Exceldataconfig("C:\\Users\\iDeliver\\workspace\\frameworkTestNG\\Testdata\\Inputdata.xlsx");
	
	int rows=config.getrowcount(0);
	
				
		Object[][] data1=new Object[rows][2];
	
		for (int i=0;i<rows;i++)
		{
			data1[i][0]=config.getData(0,i,0);
			data1[i][1]=config.getData(0,i,1);
		}
				
		return data1;	
 

	}
	
	@DataProvider (name = "dp2")
	
	
		public Object[][] getData2()
		
   {     //i stands for number for times the test case should run
		//j stands for number of parameters it should send in one go
	Exceldataconfig config=new Exceldataconfig("C:\\Users\\iDeliver\\workspace\\frameworkTestNG\\Testdata\\pocdata.xlsx");
	
	int rows=config.getrowcount(0);
	
				
		Object[][] data=new Object[rows][2];
	
		for (int i=0;i<rows;i++)
		{
			data[i][0]=config.getData(0,i,0);
			data[i][1]=config.getData(0,i,1);
		}
				
		return data;	
 

	}
	
	
}


