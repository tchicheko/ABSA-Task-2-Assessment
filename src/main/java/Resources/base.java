package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class base {
	
	public WebDriver driver;
	public Properties prop;
	//Browser initialization
	public WebDriver initializeDriver() throws IOException {
		
		 prop= new Properties();
		FileInputStream fis= new FileInputStream("C:\\Users\\Tawanda\\eclipse-workspace\\ABSA_Assessment\\src\\main\\java\\Resources\\data.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		
		if(browserName.equals("chrome")) {
			
			//
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tawanda\\Documents\\Automation\\chromedriver_win32\\chromedriver.exe");
			driver= new ChromeDriver();

		}
		else if(browserName.equals("IE")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tawanda\\Documents\\Automation\\chromedriver_win32\\chromedriver.exe");
			driver= new FirefoxDriver();
						
		}
		else if(browserName.equals("firefox")) {
			
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tawanda\\Documents\\Automation\\chromedriver_win32\\chromedriver.exe");
			driver= new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
}
}
