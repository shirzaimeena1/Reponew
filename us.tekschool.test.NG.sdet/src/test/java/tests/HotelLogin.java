package tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import core.Base;
import pageObj.HotelLoginPageObj;
import utilities.DriverUtility;
public class HotelLogin extends Base {
	
	HotelLoginPageObj hotelpageObj;
	@BeforeMethod
	public void beforeMethod() {
		Base.initializeDriver();
		logger.info("Browser opened successfully");
	}
	
	// how we can skip from runing this test case. sometime we are asked to run all test case except this one
	// infront of @Test we write (enabled=false) or we can use @ignore we write it under @Test
	@Test (enabled=false)
	public void loginToHotelPage() {
		hotelpageObj = new HotelLoginPageObj();
		hotelpageObj.clickonSignIn();
		logger.info("user clicked on Sign in");
		hotelpageObj.enterEmail(getUserName());
		logger.info("user entered email address");
		
		hotelpageObj.enterPassword(getPassword());
		logger.info("user entered password");
		
		hotelpageObj.clickonSignInButton();
		logger.info("user clicked on sign in button");
		DriverUtility.screenShot();
	}
	
	// this is for sending value from TestNG.xmlfile using parameters
	// after @test we use @parameters annotation
	@Test
	@Parameters ({"userName","password"})// we put the name from testNG.xmal
	
	public void loginToHotelPage(String userName, String password) {
		hotelpageObj = new HotelLoginPageObj();
		hotelpageObj.clickonSignIn();
		logger.info("user clicked on Sign in");
		hotelpageObj.enterEmail(userName);
		logger.info("user entered email address from Parameters");
		
		hotelpageObj.enterPassword(password);
		logger.info("user entered password from Parameters");
		
		hotelpageObj.clickonSignInButton();
		logger.info("user clicked on sign in button");
		DriverUtility.screenShot();
	}
	
	// perioritization: the follow of execution
	
	@Test(priority=1, enabled=false)
	public void testone() {
		logger.info("test one");
	}
	@Test(priority =2)
	
	public void testtwo() {
	logger.info("test two");
	}
	@Test(priority=0)
	@Ignore
	public void testzero() {
		logger.info("this test case will execute before test 1");
	}
	
	// the below test case will execute before test case which has periority zero.
	@Test
	@Ignore
	public void testthree() {
		logger.info("this test case will execute before all test case without priority number");
	}
	
	// how to skip a test case in Test Ng?
	@AfterMethod
	public void afterMethod() {
		Base.teardown();
		logger.info("Browser closed");
	}
}
