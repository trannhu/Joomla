package com.joomla.articles;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import common.AbstractTest;
import pages.ArticlePage;
import pages.FactoryPage;
import pages.HomePage;
import pages.LoginPage;

public class TC_Login extends AbstractTest{
	WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private ArticlePage articlePage;
	private String title,text,Message_Saved,attribute,article,category,state;
	
	@Parameters ({ "browser", "url", "username", "password" })
	@BeforeClass
	public void before(String browser, String url, String username, String password){
		driver=openBrowser(browser, url);
		loginPage=FactoryPage.getLoginPage(driver);
		loginPage.typeUser(username);
		loginPage.typePass(password);
		homePage=loginPage.clickSub();
		homePage.clickContent();
		articlePage=homePage.clickArticle();
		title="Nhu Tran"+randomArticle();
		text="First Article\n First Article"+randomArticle();
		Message_Saved="Article saved.";
		attribute="value";
		category="- Automation Testing";
		state="Unpublished";
	}
	@Test
	public void TC_01_CreateNewArticle(){	
		articlePage.clickNew();
		articlePage.typeTitle(title);
		article=articlePage.getArticleCurrent(attribute);
		articlePage.selectCategory(category);
		articlePage.typeText(text);
		articlePage.clickSaveAndClose();
		verifyEquals(articlePage.isDisplayedMessage(),Message_Saved);
		
	}
	@Test
	public void TC_03_PublishArticle(){
		articlePage.clickNew();
		articlePage.typeTitle(title);
		articlePage.selectStatus(state);
		articlePage.selectCategory(category);
		articlePage.typeText(text);
		articlePage.clickSaveAndClose();
		verifyEquals(articlePage.isDisplayedMessage(),Message_Saved);
		
	
		
	}
	@AfterClass
	public void CloseBrowser(){
		closeBrowser(driver);
	}

}
