/*
 * Page level verification , initialize my WebPage Browser object
 */
package generic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class BasePage {
	public static WebDriver driver;			     //global variable of of my driver reference
	public BasePage(WebDriver driver) {				//initialize Browser inside constructor
		this.driver = driver; 						//points to current object reference only
	}
	public static void verifyTitle(String eTitle) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);   //create object of WebDriverWait
			wait.until(ExpectedConditions.titleIs(eTitle)); 
			Reporter.log("Title is matching"+eTitle, true);			//display a message
					
		}
		catch(Exception e) {
			Reporter.log("Title is not matching", true);
		}
	}
	public static void verifyElementPresent(WebElement element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.visibilityOf(element));
			Reporter.log("Element is visible"+element, true);     
		}
		catch(Exception e) {
			Reporter.log("Element is not present", true);
		}
	}
}
