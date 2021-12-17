package apk.app.saucelab.testscripts;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import apk.app.saucelab.utilities.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SL_TC03_CheckoutWithAProduct extends BaseClass{

	
	@Test
	public void checkOutWithAProduct() throws MalformedURLException, InterruptedException {
		
		AndroidDriver<AndroidElement> mobileDriver = fn_setUp();
		MobileElement userName = (MobileElement) mobileDriver.findElementByAccessibilityId("test-Username");
		userName.sendKeys("standard_user");
		MobileElement userPassword = (MobileElement) mobileDriver.findElementByAccessibilityId("test-Password");
		userPassword.sendKeys("secret_sauce");
		MobileElement loginBTN = (MobileElement) mobileDriver.findElementByAccessibilityId("test-LOGIN");
		loginBTN.click();
		
		MobileElement product = (MobileElement) mobileDriver.findElementByXPath("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[1]/android.view.ViewGroup/android.widget.ImageView");
		product.click();

		Thread.sleep(5000);
		mobileDriver.findElementByAndroidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"ADD TO CART\"));");
		  
		MobileElement addToCartCTA = (MobileElement) mobileDriver.findElementByAccessibilityId("test-ADD TO CART");
		addToCartCTA.click();
		
		
		MobileElement cartIcon = (MobileElement) mobileDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.view.ViewGroup");
		cartIcon.click();
		MobileElement checkOutCTA = (MobileElement) mobileDriver.findElementByAccessibilityId("test-CHECKOUT");
		checkOutCTA.click();
		MobileElement firstName_INP = (MobileElement) mobileDriver.findElementByAccessibilityId("test-First Name");
		firstName_INP.sendKeys("Abhinav");
		MobileElement lastName_INP = (MobileElement) mobileDriver.findElementByAccessibilityId("test-Last Name");
		lastName_INP.sendKeys("Srivastava");
		MobileElement zipCode_INP = (MobileElement) mobileDriver.findElementByAccessibilityId("test-Zip/Postal Code");
		zipCode_INP.sendKeys("201301");
		MobileElement continueCTA = (MobileElement) mobileDriver.findElementByAccessibilityId("test-CONTINUE");
		continueCTA.click();

		Thread.sleep(5000);
		mobileDriver.findElementByAndroidUIAutomator("new UiScrollable (new UiSelector()).scrollIntoView(text(\"FINISH\"));");
		  
		Thread.sleep(3000);
		MobileElement finishCheckoutCTA = (MobileElement) mobileDriver.findElementByAccessibilityId("test-FINISH");
		finishCheckoutCTA.click();
		Thread.sleep(5000);
		
	}
	
	
}
