package pages;

import org.openqa.selenium.WebDriver;
import Joomla.ContentUI;

public class ContentPage extends AbstractPage {
	WebDriver driver;

	public ContentPage(WebDriver driver) {
		this.driver = driver;

	}

	public ArticlePage clickNew() {
		waitForControlVisible(driver, ContentUI.New_bt);
		clickToElement(driver, ContentUI.New_bt);
		return FactoryPage.getArticlePage(driver);

	}
	public void clickPublish(){
		isDisplayedElement(driver, ContentUI.Publish_button);
		clickToElement(driver, ContentUI.Publish_button);
	}
	public Object isDisplayedMessage() {
		isDisplayedElement(driver, ContentUI.Message_success);
		return getTextElement(driver, ContentUI.Message_success);
	}

}
