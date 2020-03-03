package stepdefinition;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AddItemsToCart {

	Properties prop = new Properties();
	FileInputStream fis;
	WebDriver driver;
	PageObjects pageObjects;

	//Load ObjectRepository properties file to read the test data and element locators from application under test and also initialize the Chrome driver
	@Before
	public void setUp() throws IOException {
		fis = new FileInputStream("ObjectRepository.properties");

		prop.load(fis);

		System.setProperty("webdriver.chrome.driver", prop.getProperty("chromeDriverPath"));

		driver = new ChromeDriver();
	}

	//Open the application url in chrome browser and load the page factory class
	@Given("^user navigated to automationpractice webpage homepage$")
	public void user_navigated_to_automationpractice_webpage_homepage() {

		driver.get(prop.getProperty("applicationUrl"));

		driver.manage().window().maximize();

		pageObjects = new PageObjects(driver);

	}

	//Add items to cart and navigate to checkout page
	@When("^user adds two items to cart and proceed to checkout$")
	public void user_adds_two_items_to_cart_and_proceed_to_checkout() throws InterruptedException {

		List<WebElement> ele = pageObjects.itemsList;

		for (int i = 0; i < ele.size(); i++) {

			WebElement itemSize = ele.get(i).findElement(By.cssSelector(prop.getProperty("itemObjectCssSelector")));

			if (itemSize != null) {
				Actions actionObj = new Actions(driver);

				actionObj.moveToElement(itemSize).perform();

				Thread.sleep(2000);

				ele.get(i).findElement(By.cssSelector(prop.getProperty("addToCartCssSelector"))).click();

				

				Thread.sleep(5000);

				waitForPresenceBycssSelector(driver, 60000, prop.getProperty("continueShoppingCssSelector"));

				pageObjects.continueShopping.click();

				break;
			}

		}

		List<WebElement> ele1 = pageObjects.itemsList;

		for (int j = 0; j < ele1.size(); j++) {

			WebElement itemSize = ele1.get(j).findElement(By.cssSelector(prop.getProperty("itemObjectCssSelector")));

			if (itemSize != null) {
				Actions actionObj = new Actions(driver);

				actionObj.moveToElement(itemSize).perform();

				Thread.sleep(2000);

				ele1.get(j).findElement(By.cssSelector(prop.getProperty("addToCartCssSelector"))).click();

				

				Thread.sleep(5000);

				waitForPresenceBycssSelector(driver, 60000, prop.getProperty("proceedToCheckoutCssSelector"));

				pageObjects.proceedToCheckout.click();

				break;
			}

		}

		pageObjects.proceedToCheckoutSummaryPage.click();
	}

	//user logged into application with valid email id and password before placing the order.
	@And("^user logged into application with valid emailid and password$")
	public void user_logged_into_application_with_valid_emailid_and_password() throws InterruptedException {

		pageObjects.emailObj.sendKeys(prop.getProperty("emailId"));

		pageObjects.passwordObj.sendKeys(prop.getProperty("password"));

		pageObjects.signInBtn.click();

		Thread.sleep(3000);

		pageObjects.proceedToCheckoutAddressPage.click();

		pageObjects.agreeToTerms.click();

		pageObjects.proceedToCheckoutShippingPage.click();
	}

	//Mode of payment used is check
	@And("^user pays by check and click on confirm order$")
	public void user_pays_by_check_and_click_on_confirm_order() {

		pageObjects.payByCheck.click();

		pageObjects.confirmOrder.click();
	}

	//verify if the order is placed successfully
	@Then("^verify if the order is placed successfully$")
	public void verify_if_the_order_is_placed_successfully() {

		WebElement orderSuccessMessage = pageObjects.orderSuccess;

		assertEquals("Your order on My Store is complete.", orderSuccessMessage.getText());

	}

	//common reusable function to wait for an object if the application is responding slowly
	public static boolean waitForPresenceBycssSelector(WebDriver driver, int timeLimitInSeconds,
			String targetResourceId) {

		boolean isElementPresent;
		try {
			WebElement webElement;
			WebDriverWait wait = new WebDriverWait(driver, timeLimitInSeconds);

			webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(targetResourceId)));
			isElementPresent = webElement.isDisplayed();
			return isElementPresent;
		} catch (Exception e) {
			isElementPresent = false;
			System.out.println(e.getMessage());
			return isElementPresent;
		}
	}
	
	//close the chrome browser after the execution is completed
	@After
	public void tearDown()
	{
		driver.close();
	}

}
