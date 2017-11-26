package pages;

import org.openqa.selenium.WebDriver;
import Joomla.LoginUI;

public class LoginPage extends AbstractPage {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	public void typeUser(String username) {
		waitForControlVisible(driver, LoginUI.UserName_txt);
		sendkeyToElement(driver, LoginUI.UserName_txt, username);

	}

	public void typePass(String password) {
		waitForControlVisible(driver, LoginUI.PassWord_txt);
		sendkeyToElement(driver, LoginUI.PassWord_txt, password);

	}

	public HomePage clickSub() {
		waitForControlVisible(driver, LoginUI.Login_bt);
		clickToElement(driver, LoginUI.Login_bt);
		return FactoryPage.getHomePage(driver);

	}

}
