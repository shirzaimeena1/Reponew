package core;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
public class Base {
	// WE SHOULD DECLEAR THE  BELOW THINGS.]]
	public static WebDriver driver;
	public static Properties properties;
	public static Logger logger;
	
	private String propertyPath = ".\\src\\test\\resources\\properties\\ProjictProperty.properties";
	
	// create a constructor to load property of this class anytime child classess use its property
	
	public Base () {
		
	
		try {	
			BufferedReader reader;
			reader = new BufferedReader (new FileReader (propertyPath));
			properties = new Properties();
			
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		logger = logger.getLogger("logger_file");
		PropertyConfigurator.configure(".\\src\\test\\resources\\properties\\ProjictProperty.properties");
		
	}
	
	public static String getbroswerName() {
		String browserName = properties.getProperty("browserName");
		return browserName;
	}
	
	public static String getURL () {
		String url = properties.getProperty("url");
		return url;
	}
		
		public static long getPageLoadTime() {
			String pageLoadTime = properties.getProperty("pageloadtime");
			return Long.parseLong(pageLoadTime);
		}
		
		public static long getimplicitwait() {
			String implicitwait =properties.getProperty("implicitlyWait");
			return Long.parseLong(implicitwait);
		}
		
		public static String getUserName () {
			String userName = properties.getProperty("username");
			return userName;
			
		}
		 public static String getPassword() {
			 String password = properties.getProperty("password");
			 return password;
		 }
		
		public static void initializeDriver() {
			if (Base.getbroswerName().equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (Base.getbroswerName().equalsIgnoreCase("ie")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			
		} else if (Base.getbroswerName().equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			
		} else {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Base.getPageLoadTime(), TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(Base.getimplicitwait(), TimeUnit.SECONDS);
			driver.get(Base.getURL());
			
}
		public static void teardown() {
			driver.close();
			driver.quit();
		}
		
}
