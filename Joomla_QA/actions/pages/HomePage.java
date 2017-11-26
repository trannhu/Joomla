package pages;

import org.openqa.selenium.WebDriver;

import Joomla.HomePageUI;

public class HomePage extends AbstractPage {
	WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;

	}
	public void clickContent(){
		waitForControlVisible(driver, HomePageUI.Content_dropdown);
		clickToElement(driver, HomePageUI.Content_dropdown);
	}
	public ArticlePage clickArticle(){
		waitForControlVisible(driver, HomePageUI.Article_subdropdown);
		clickToElement(driver, HomePageUI.Article_subdropdown);
		return FactoryPage.getArticlePage(driver);
	}
}
