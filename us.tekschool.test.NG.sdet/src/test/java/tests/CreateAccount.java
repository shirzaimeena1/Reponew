
	// we use this to read data from excelsheet
	
	//we creat this class to use datadriven concept to read from Excel and creat account 
	// by adding data provider here test NG knows that what ever data we need int this test case will be get it from belwo method.
	// data provider help us to read data from excel
	// we pass these paramater from excel
			// we should creat objict of hotel page becuse sing in is there
			
	// then we have creat objict of creatAccount page becuase we are creating account there.
//  we create data provide help us to read data from exceel and add the data in the above 
// this method is to provide data from excel
	package tests;

	import org.testng.annotations.AfterMethod;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.DataProvider;

	import org.testng.annotations.Test;

	import core.Base;
	import pageObj.CreateAccountPageObj;
	import pageObj.HotelLoginPageObj;
	import utilities.ExcelUtility;

	
	public class CreateAccount extends Base {

		HotelLoginPageObj hotelpageObj;
		CreateAccountPageObj createAccountPageObj;

		@BeforeMethod
		public void beforeMethod() {
			Base.initializeDriver();
			logger.info("Browser opened successfully");

		}

		@Test(dataProvider = "getInfoData")
		public void createAccount(String email, String title, String firstname, String lastname, String password,
				String day, String month, String year) {
			hotelpageObj = new HotelLoginPageObj();
			createAccountPageObj = new CreateAccountPageObj();
			hotelpageObj.clickonSignIn();
			logger.info("User clicked on Sign in");
			createAccountPageObj.enterCreateEmail(email);
			logger.info("User entered: " + email);
			createAccountPageObj.clickOnCreateAnAccount();
			logger.info("User clicked on Create Account");
			createAccountPageObj.selectTitle(title);
			logger.info("User selected Title: " + title);
			createAccountPageObj.fillPersonalInformation(firstname, lastname, password, email);
			logger.info("User filled personal information");
			createAccountPageObj.dateOFBirthInfo(day.substring(0, 1), month.substring(0, 1), year.substring(0, 4));
			logger.info("User filled DOB information ");
			createAccountPageObj.registerAccount();
			logger.info("User clicked on Register Account");

		}

		@DataProvider()
		public Object[][] getInfoData() {
			Object data[][] = ExcelUtility.getExcelData("info");
			return data;
		}

		@AfterMethod
		public void afterMethod() {
			Base.teardown();
			logger.info("Browser closed");

		}

	}