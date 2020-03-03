package stepdefinition;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageObjects {

	WebDriver driver;

	public PageObjects(WebDriver driver) {

		this.driver = driver;

		// This initElements method will create all WebElements

		PageFactory.initElements(driver, this);

	}
	
	@FindBy(css="li[class^='ajax_block_product']")

	List<WebElement> itemsList;

	@FindBy(css="span[class='continue btn btn-default button exclusive-medium']>span")

	WebElement continueShopping;
	

	@FindBy(css="a[title='Proceed to checkout']")

	WebElement proceedToCheckout;

	@FindBy(css="p[class^='cart_navigation']>a")

	WebElement proceedToCheckoutSummaryPage;
	
	
	

	@FindBy(name="processAddress")

	WebElement proceedToCheckoutAddressPage;
	

	@FindBy(name="processCarrier")

	WebElement proceedToCheckoutShippingPage;
	
	@FindBy(css="input[type='checkbox']")

	WebElement agreeToTerms;
	
	@FindBy(css="a[title='Pay by check.']")

	WebElement payByCheck;
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")

	WebElement confirmOrder;

	@FindBy(xpath="//p[contains(text(),'Your order on My Store is complete.')]")

	WebElement orderSuccess;
	
	
	
	@FindBy(id="email")

	WebElement emailObj;
	
	@FindBy(id="passwd")

	WebElement passwordObj;

	@FindBy(id="SubmitLogin")

	WebElement signInBtn;
	

	
	
}
