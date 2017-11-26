package pages;

import org.openqa.selenium.WebDriver;

import Joomla.ArticleUI;

public class ArticlePage extends AbstractPage{
	WebDriver driver;
	public ArticlePage (WebDriver driver){
		this.driver=driver;
		
	}
	public void clickNew(){
		waitForControlVisible(driver, ArticleUI.New_bt);
		clickToElement(driver, ArticleUI.New_bt);
	}
	public void selectCategory(String category){
		waitForControlVisible(driver, ArticleUI.Category_dropdown);
		selectItemInDropdownByName(driver, ArticleUI.Category_dropdown, category);
	}
	public void selectStatus(String status){
		waitForControlVisible(driver, ArticleUI.Status_dropdown);
//		selectItemInDropdownByName(driver, ArticleUI.Status_dropdown, status);
		isSelectedElement1(driver, ArticleUI.Status_dropdown, status);
	}
	public void typeTitle(String title){
		waitForControlVisible(driver, ArticleUI.Title_txt);
		sendkeyToElement(driver, ArticleUI.Title_txt, title);
		
	}
	public void typeText(String text){
		switchIframe(driver, ArticleUI.Iframe_Textarea);
		sendkeyToElement(driver, ArticleUI.TextArea, text);
		driver.switchTo().defaultContent();

	}
	public void clickSaveAndClose(){
		clickToElement(driver, ArticleUI.SaveAndClose_bt);
	}
	public Object isDisplayedMessage(){
		isDisplayedElement(driver, ArticleUI.Message_success);
		return getTextElement(driver, ArticleUI.Message_success);
	}
	public String getArticleCurrent(String attribute){
		return getAttributeElement(driver, ArticleUI.Title_txt,attribute);
		
	}
	public void clickPublish(){
		isDisplayedElement(driver, ArticleUI.Publish_button);
		clickToElement(driver, ArticleUI.Publish_button);
	}

	public void checkbox(){
		
		
	}
	
	
}
