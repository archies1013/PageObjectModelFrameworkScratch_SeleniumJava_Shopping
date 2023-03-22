package rahulshettyacademy.AbstractComponents;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

import rahulshettyacadamy.PageObjects.CartPage;

public class AbstractComponents {
	
	/**this will be the Parent Class of all PageObjectClasses, that is holding all reusable stuff
	 * Here instead of creating a object we will use concept called Inheritance
	 * (By.cssSelector(".mb-3"))) = this is By locator and return type is By
	 * driver.findElement(By.locator("value of locator")) ==this is webElement
	 * Only constructor can catch the variables
	 */
	
	WebDriver driver;
	public AbstractComponents(WebDriver driver)
	{
		super();
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	@FindBy(css="[routerlink*='cart']")
			WebElement cartHeader;
	
	
	public void waitForElementToAppear(By findBy)
	{
		
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));//this is reusable code, synchronization code for every test case
	//	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		
		
	}
	
	public void waitForElementToDisAppear(WebElement ele) throws InterruptedException
	{
		//Thread.sleep(5000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions.invisibilityOf(ele));		
	}
	
	/**WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));//this is reusable code, synchronization code for every test case
	*wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
	 * @return 
	*/

	public CartPage goToCartPage()
	{
		cartHeader.click();
		CartPage cartPage=new CartPage(driver);
		return cartPage;
	}
}
