package com.website.ezmall.qa.pageTest;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.website.ezmall.qa.base.TestBase;
import com.website.ezmall.qa.pages.Homepage;
import com.website.ezmall.qa.pages.SearchListingpage;
import com.website.ezmall.qa.utils.TestUtil;

public class SearchListingpageTest  extends TestBase{

	Homepage objHomePage;
	SearchListingpage objSearchListingPage;

	public SearchListingpageTest() {
		super();
	}
	
	

	@BeforeMethod
	public void setUp() throws InterruptedException {
		initialization();
		objHomePage = new Homepage();
		objSearchListingPage=objHomePage.enterKeywordToSearchAndSearchProduct("Saree");
	}


	@Test
    public void validateSearchKeywordonSearchListingPageTest(){
		String keyword=objSearchListingPage.getSearchKeywordNameText();
		System.out.println(objSearchListingPage.getSearchKeywordNameText());
		Assert.assertEquals(keyword, "Saree");
		
		
		
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}


}
