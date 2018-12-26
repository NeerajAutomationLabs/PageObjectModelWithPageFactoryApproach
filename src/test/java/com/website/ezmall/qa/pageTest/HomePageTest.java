package com.website.ezmall.qa.pageTest;

import org.testng.Assert;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.website.ezmall.qa.base.TestBase;
import com.website.ezmall.qa.pages.Homepage;
import com.website.ezmall.qa.pages.SearchListingpage;
import com.website.ezmall.qa.utils.TestUtil;

public class HomePageTest extends TestBase

{
	Homepage objHomePage;
	String sheetName = "LoginData";
	String sheetName1="SearchData";
	Logger log = Logger.getLogger(HomePageTest.class);
	
	
	

	public HomePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		objHomePage = new Homepage();
	}

	@Test(priority=1)
	public void validateEzmalogo() {
		log.info("checking for ezmall logo");
		Assert.assertTrue(objHomePage.validateEzmallLogo());
		log.info("Ezmall logo Found");
	}

	
	@DataProvider
	public Object[][] getSearchData() {
		Object[][] data = TestUtil.getTestData(sheetName1);
		return data;

	}
	@Test(priority=2,dataProvider="getSearchData")
	public void validateSearchFuntionalityTest(String SearchKey) throws InterruptedException {
		//objHomePage.enterKeywordToSearchAndSearchProduct("saree");
		log.info("Search box found and Entering keyword to seaarch");
		objHomePage.enterKeywordToSearchAndSearchProduct(SearchKey);
		log.info("Search is working fine.");
		Thread.sleep(5000);

	}

	@DataProvider
	public Object[][] getLoginData() {
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}

	@Test(priority=3,dataProvider="getLoginData")
	public void validateLoginFunctionalityTest(String userN, String passW) throws InterruptedException {
		log.info("Moving to Signin Modal & Cliking on Signin Button");
		objHomePage.moveToSignInModal();
		//objHomePage.login(prop.getProperty("username"), prop.getProperty("password"));
		log.info("Entering user name and password to signin");
		objHomePage.login(userN, passW);
		log.info("Login Successfull");
		Thread.sleep(5000);

	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}

}
