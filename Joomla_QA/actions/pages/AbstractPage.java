package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AbstractPage {
	WebDriver driver;

	public void openWeb(WebDriver driver, String URL) {
		driver.get(URL);
	}

	public String getURLBrowser(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getTitleBrowser(WebDriver driver) {
		return driver.getTitle();
	}

	public void backBrowser(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardBrowser(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshBrowser(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void clickToElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.click();
	}

	public void clearText(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {
		WebElement element = driver.findElement(By.xpath(locator));
		element.clear();
		element.sendKeys(value);

	}

	public String getTextElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getText();
	}

	public String getAttributeElement(WebDriver driver, String locator, String attribute) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.getAttribute(attribute);
	}

	public boolean isSelectedElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isSelected();
	}

	public boolean isEnabledElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isEnabled();
	}

	public boolean isDisplayedElement(WebDriver driver, String locator) {
		WebElement element = driver.findElement(By.xpath(locator));
		return element.isDisplayed();
	}

	public void uncheckCheckbox(WebDriver driver, String locator) {
		WebElement checkbox = driver.findElement(By.xpath(locator));
		if (checkbox.isSelected()) {
			checkbox.click();
		}

	}
	public void checkCheckbox(WebDriver driver, String locator) {
		WebElement checkbox = driver.findElement(By.xpath(locator));
		if (checkbox.isSelected()) {
			checkbox.click();
		}

	}


	public void getFirstOptiondropdown(WebDriver driver, String locator, String value, String expectedText) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByValue(value);
		String actualText = select.getFirstSelectedOption().getText();
		Assert.assertEquals(actualText, expectedText);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByValue(value);
	}
	public void selectItemInDropdownByName(WebDriver driver, String locator, String value) {
		locator=String.format(locator, value);
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);
	}
	public void selectItemInDropdownByName1(WebDriver driver, String locator, String value) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(value);
	}
	public void acceptAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();

	}

	public void dimissAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void sendKeyToElementAlert(WebDriver driver, String value, String locator) {
		Alert alert = driver.switchTo().alert();
		driver.findElement(By.xpath(locator)).clear();
		alert.sendKeys(value);
		alert.accept();
	}

	public void switchWindowbyID(WebDriver driver, String parentwd) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			if (!childWindows.equals(parentwd)) {
				driver.switchTo().window(childWindows);
				break;
			}
		}

	}

	public void switchWindowbyTitle(WebDriver driver, String title) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String childWindows : allWindows) {
			driver.switchTo().window(childWindows);
			String childTitle = driver.getTitle();
			if (childTitle.equals(title)) {
				break;
			}
		}
	}


	public void doubleClickElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.doubleClick(driver.findElement(By.xpath(locator))).build().perform();
	}

	public void rightClickElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.contextClick(driver.findElement(By.xpath(locator))).build().perform();

	}

	public void dragAndDropElement(WebDriver driver, String source, String destination) {
		Actions action = new Actions(driver);
		action.dragAndDrop(driver.findElement(By.xpath(source)), driver.findElement(By.xpath(destination))).build()
				.perform();
	}

	public void keyPressElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.keyDown(driver.findElement(By.xpath(locator)), Keys.TAB);
		action.keyUp(driver.findElement(By.xpath(locator)), Keys.TAB);

	}

	public void hoverElement(WebDriver driver, String locator) {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath(locator))).build().perform();
	}

	public void uploadByRobot(WebDriver driver, String path, String locator) throws AWTException {
		StringSelection selectpath = new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selectpath, null);
		driver.findElement(By.xpath(locator)).click();
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);

		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);

		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

	public void uploadByAutoIt(WebDriver driver, String path, String locator, String pathexe) throws Exception {
		driver.findElement(By.xpath(locator)).click();
		Runtime.getRuntime().exec(new String[] { pathexe, path });
	}

	public void exeJavascriptToBrowser(WebDriver driver, String url) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location=" + url);
	}

	public void exeJavascriptToElement(WebDriver driver, String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(locator)));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.xpath(locator)));
	}

	public void scrollToBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public WebElement waitForControlPresence(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		return element;

	}

	public boolean waitForControlVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator)));
		return element.isDisplayed();

	}

	public boolean waitForControlClickable(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		return element.isEnabled();
	}

	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		Alert alert = driver.switchTo().alert();
		alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		return alert;

	}

	public String getTextAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		String textAlert = alert.getText();
		return textAlert;
	}

	public void switchIframe(WebDriver driver, String locator) {
		driver.switchTo().frame(driver.findElement(By.id(locator)));
		
	}
	 public boolean isSelectedElement1(WebDriver driver, String locator, String value) {
		  locator = String.format(locator, value);
		  WebElement element = driver.findElement(By.xpath(locator));
		  return element.isSelected();
		 }

}
