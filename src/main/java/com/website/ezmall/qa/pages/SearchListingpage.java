package com.website.ezmall.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.website.ezmall.qa.base.TestBase;
import com.website.ezmall.qa.utils.CommonMethods;

public class SearchListingpage  extends TestBase{
	
	
	
	@FindBy(xpath="//h1[@id='productCountCategory']")
	private WebElement searchedKeywordName;
	
	
	public SearchListingpage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String getSearchKeywordNameText(){
		return CommonMethods.getText(searchedKeywordName);
		
		
	}
	
	

}
