package pages;

import org.openqa.selenium.WebDriver;

public class FactoryPage {
	WebDriver driver;

	public static HomePage getHomePage(WebDriver driver) {
		return new HomePage(driver);
	}
	
	public static ArticlePage getArticlePage(WebDriver driver){
		return new ArticlePage(driver);
		
	}
	public static LoginPage getLoginPage(WebDriver driver){
		return new LoginPage(driver);
		
	}
	public static ContentPage getContentPage(WebDriver driver){
		return new ContentPage(driver);
		
	}
	

}
