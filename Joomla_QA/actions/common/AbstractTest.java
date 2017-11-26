package common;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class AbstractTest {
	WebDriver driver;

	public WebDriver openBrowser(String browser, String url) {
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "..\\Joomla_QA\\resouces\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		} else {
			System.setProperty("webdriver.ie.driver", "..\\Joomla_QA\\resouces\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		}
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public String randomEmail() {
		Random rand = new Random();
		int number = rand.nextInt(900) + 1;
		String numberString = Integer.toString(number);
		return numberString;
	}
	public String randomArticle() {
		Random rand = new Random();
		int number = rand.nextInt(900) + 1;
		String numberString = Integer.toString(number);
		return numberString;
	}

	public void closeBrowser(WebDriver driver) {
		try {
			driver.quit();
			System.gc();
			if (driver.toString().toLowerCase().contains("chrome")) {
				String cmd = "taskkill/IM chromedriver.exe/F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}
			if (driver.toString().toLowerCase().contains("internetexplorer")) {
				String cmd = "taskkill/IM IEDriverServer.exe/F";
				Process process = Runtime.getRuntime().exec(cmd);
				process.waitFor();
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	public boolean verifyTrue(boolean condition) {
		boolean pass = true;
		try {
			Assert.assertTrue(condition);
			return true;
		} catch (Throwable e) {
			pass = false;
			e.printStackTrace();
			Reporter.getCurrentTestResult().setThrowable(e);
		}
		return pass;
	}

	public boolean verifyFalse(boolean condition) {
		try {
			Assert.assertFalse(condition);
			return true;
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.getCurrentTestResult().setThrowable(e);
			return false;
		}
	}

	public boolean verifyEquals(Object actual, String expect) {
		try {
			Assert.assertEquals(actual, expect);
			return true;
		} catch (Throwable e) {
			e.printStackTrace();
			Reporter.getCurrentTestResult().setThrowable(e);
			return false;

		}

	}

}
