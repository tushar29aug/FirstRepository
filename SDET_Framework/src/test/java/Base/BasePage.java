package Base;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.framework.testCases.LoginTest;

public class BasePage {

	public WebDriver driver;
	public String baseUrl = "http://demo.guru99.com/v4/";
	public String user = "mngr136913";
	public String pass = "bath1234@";
	public static Logger log = Logger.getLogger(LoginTest.class);
	
	@BeforeClass
	public void setUp(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	@AfterClass
	public void tearDown(){
		driver.quit();
	}
}
