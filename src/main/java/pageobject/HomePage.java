package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	@FindBy(xpath = "//div[@data-label='Email']/input[@type='standard']")
	private WebElement emailID;

	@FindBy(xpath = "//div[@data-label='Password']/input[@type='password']")
	private WebElement passcode;

	@FindBy(xpath = "//div[@data-id='primary-button']")
	private WebElement login;

	@FindBy(xpath = "//div[@data-id='salutation']//div[contains(text(), 'Welcome back')]")
	private WebElement welcomeBackText;

	@FindBy(xpath = "//div[@data-id='help']")
	private WebElement help;

	@FindBy(xpath = "//div[contains(text(),'About Trifacta Wrangler')]")
	private WebElement about;

	@FindBy(xpath = "//div[@class=\"modal-body\"]/p[contains(text(), '7.6.0+52.20200819171647.b26f63d')]")
	private WebElement productVersion;

	@FindBy(xpath = "//button[@class='close tricon']")
	private WebElement closeButton;

	@FindBy(xpath = "//div[@data-id='user-avatar']")
	private WebElement userAvatar;

	@FindBy(xpath = "//div[contains(text(),'Log out')]")
	private WebElement logout;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//This will enter email id
	public void enterEmailId(String emailid) {
		emailID.sendKeys(emailid);
	}

	//This will enter password
	public void enterPassword(String password) {
		passcode.sendKeys(password);
	}

	//This will click on the Login button
	public void clickLogInButton() {
		login.click();
	}

	//This will retrieve the welcome back text from home page
	public String getWelcomeBacktext() {
		return welcomeBackText.getText();
	}


	//This will click on the help bar
	public void clickOnHelp() {
		help.click();
	}

	//This will click on the help bar
	public void selectMenuItemAbout() {
		about.click();
	}

	//This is return the product version
	public String getproductVersion() {
		return productVersion.getText();
	}

	//This clicks on the OK button present in product version
	public void clickOnCloseIcon() {
		 closeButton.click();
	}

	//This will click on User avatar
	public void clickOnUserAvatar() {
		 userAvatar.click();
	}

	//This will click on Logout button
	public void clickOnLogOut() {
		logout.click();
	}
}

