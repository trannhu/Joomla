package com.joomla.articles;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import pages.ArticlePage;
import pages.ContentPage;
import pages.FactoryPage;
import pages.HomePage;
import pages.LoginPage;

public class TC_Login extends AbstractTest{
	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private ArticlePage articlePage;
	private ContentPage contentPage;
	private String title,text,Message_Saved,attribute,category,state;
	
	@Parameters ({ "browser", "url", "username", "password" })
	@BeforeClass
	public void before(String browser, String url, String username, String password){
		driver=openBrowser(browser, url);
		loginPage=FactoryPage.getLoginPage(driver);
		loginPage.typeUser(username);
		loginPage.typePass(password);
		homePage=loginPage.clickSub();
		homePage.clickContent();
		contentPage=homePage.clickArticleDropdown();
		title="Nhu Tran"+randomArticle();
		text="First Article\n First Article"+randomArticle();
		Message_Saved="Article saved.";
		attribute="value";
		category="- Automation Testing";
		state="Unpublished";
	}
	@Test
	public void TC_01_CreateNewArticle(){	
		articlePage=contentPage.clickNew();
		articlePage.typeTitle(title);
		articlePage.typeText(text);
		articlePage.getArticleCurrent(attribute);
		articlePage.selectCategory(category);
		contentPage=articlePage.clickSaveAndClose();
		verifyEquals(contentPage.isDisplayedMessage(),Message_Saved);
		
	}
	@Test
	public void TC_03_PublishArticle(){
		articlePage=contentPage.clickNew();
		articlePage.typeTitle(title);
		articlePage.typeText(text);
		articlePage.selectStatus(state);
		articlePage.selectCategory(category);
		contentPage=articlePage.clickSaveAndClose();
		verifyEquals(contentPage.isDisplayedMessage(),Message_Saved);
		
	
		
	}
	@AfterClass
	public void CloseBrowser(){
		closeBrowser(driver);
	}

}
