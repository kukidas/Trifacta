package test;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
//import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseTest {
	
	WebDriver driver;
	
	public BaseTest(){
		setDriverPath();
		this.driver = new ChromeDriver();
	}
	
	protected WebDriver getDriver(){
		return this.driver;
	}
	
	//this method is used to set the driver path for different platform
	protected void setDriverPath() {
		String OS = System.getProperty("os.name").toLowerCase();

        if (isMac(OS)) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_mac");
        }
        if (isWindows(OS)) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_win.exe");
        }
        if (isLinux(OS)) {
            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
        }
    }


    public void waitForElementToBePresent(By element) {
		WebDriverWait waitForLoginPage = new WebDriverWait(driver, 15);
		waitForLoginPage.until(ExpectedConditions.visibilityOfElementLocated(element));
	}
	public static boolean isWindows(String OS) {
		return OS.contains("win");
	}

	public static boolean isMac(String OS) {
		return OS.contains("mac");
	}

	public static boolean isLinux(String OS) {
		return OS.contains("nux");
	}

}
