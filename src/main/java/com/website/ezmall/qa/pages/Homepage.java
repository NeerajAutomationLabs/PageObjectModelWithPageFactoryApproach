package com.website.ezmall.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.website.ezmall.qa.base.TestBase;
import com.website.ezmall.qa.utils.CommonMethods;

public class Homepage extends TestBase {

	@FindBy(xpath = "//img[@src='https://cdn2.ezmall.com/0/media/css/frontend/images/logo1.png']")
	private WebElement logoImage;

	@FindBy(xpath = "//input[@id='searchkey']")
	private WebElement searchInputBox;

	@FindBy(xpath = " //input[@id='searchBtn']")
	private WebElement searchIcon;
	

	@FindBy(xpath = "//div[@class='head-login-icon flt desktop-only']//*[@id='Layer_1']")
	private WebElement loginIcon;

	
	@FindBy(xpath = "//div[@class='user-link']//div[@class='login-head']//a[@title='Sign In'][contains(text(),'Sign In')]")
	private WebElement signButton;
	
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	
	@FindBy(xpath = "//input[@id='mobileNo']")
	private WebElement userName;


	@FindBy(xpath = "//input[@id='octa_login_Id']")
	private WebElement continueButton;
	

	public Homepage() {
		PageFactory.initElements(driver, this);
	}

	public boolean validateEzmallLogo() {
		boolean imgDisFlag = logoImage.isDisplayed();
		return imgDisFlag;

	}

	public SearchListingpage enterKeywordToSearchAndSearchProduct(String Keyword) throws InterruptedException {
		CommonMethods.enterTextInWebelement(searchInputBox, Keyword);
		Thread.sleep(5000);
		CommonMethods.clickElementUsingJavascript(searchIcon);
		return new SearchListingpage();
		

	}
	
	public void moveToSignInModal(){
	    CommonMethods.mouseHoverToElemnet(loginIcon);
	    CommonMethods.clickElementUsingJavascript(signButton);	
		
	}
	
	
	public Homepage login(String inputUserName,String inputPassword){
		
		CommonMethods.enterTextInWebelement(userName, inputUserName);
		CommonMethods.enterTextInWebelement(password, inputPassword);
		CommonMethods.clickElementUsingJavascript(password);
		return new Homepage();
		
		
	}
	
	
	
	
	
	
	
	

}
