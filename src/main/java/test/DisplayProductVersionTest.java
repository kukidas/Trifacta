/* this test script contains 3 test scenarios
1. log in to the application
2. display the product version
3. log out of the application
 */

package test;
import java.io.IOException;
import java.util.ResourceBundle;


import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageobject.HomePage;
import util.ResourceLoader;
import util.ScreenshotHelper;

public class DisplayProductVersionTest extends BaseTest{
	
	WebDriver driver;
	HomePage homePage;
	String emailid;
	String password;
	String URL;
    private static final String EMAIL_ID_KEY="trifacta.emailid";
    private static final String PASSWORD_KEY="trifacta.password";
    private static final String TRIFACTA_URL="trifacta.URL";


    //TakesScreenshot scrShot =((TakesScreenshot) driver);

	
	public DisplayProductVersionTest(){
		super();
		driver = getDriver();
        homePage = new HomePage(driver);
        emailid= ResourceLoader.getValue(EMAIL_ID_KEY);
        password=ResourceLoader.getValue(PASSWORD_KEY);
        URL=ResourceLoader.getValue(TRIFACTA_URL);
	}


    @Test(priority=1)
    public void testLoginFlow() throws IOException {
	    driver.get(URL);

        //waiting until login page is loaded
        waitForElementToBePresent(By.xpath("//div[@data-label='Email']/input[@type='standard']"));

        homePage.enterEmailId(emailid);
        homePage.enterPassword(password);
        homePage.clickLogInButton();
        ScreenshotHelper.takeScreenshot(driver,"Login_page");

        //waiting until element is present in DOM
        waitForElementToBePresent(By.xpath("//div[@data-id='salutation']//div[contains(text(), 'Welcome back')]"));
    }

    @Test(priority=2)
    public void testToDisplayTheProductVersion() throws IOException {
        //verify that user is navigated to Home Page
        String welcomeText = homePage.getWelcomeBacktext();
        Assert.assertTrue(welcomeText.contains("Welcome back"));

        homePage.clickOnHelp();
        homePage.selectMenuItemAbout();

        //waiting until element is present in DOM
        waitForElementToBePresent(By.xpath("//div[@class='modal-dialog']"));

        System.out.println("The product version is"+ homePage.getproductVersion());
        ScreenshotHelper.takeScreenshot(driver,"Product_version");
        WebElement productVersion = driver.findElement(By.xpath("//button[@class='close tricon']"));
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", productVersion);
    }

    @Test(priority=3)
    public void testLogOut() throws IOException {
        //waiting until element is present in DOM
        waitForElementToBePresent(By.xpath("//div[@data-id='user-avatar']"));

        WebElement userAvatar = driver.findElement(By.xpath("//div[@data-id='user-avatar']"));
        JavascriptExecutor executor1 = (JavascriptExecutor)driver;
        executor1.executeScript("arguments[0].click();", userAvatar);

        //waiting until element is present in DOM
      //  waitForElementToBePresent(By.xpath("//div[@data-id='salutation']//div[contains(text(), 'Welcome back')]"));

        homePage.clickOnLogOut();
        ScreenshotHelper.takeScreenshot(driver,"Logout");


        //wait until the login page appears
        waitForElementToBePresent(By.xpath("//div[@data-id='page-title']"));

        //close the browser
        driver.quit();
    }

}
