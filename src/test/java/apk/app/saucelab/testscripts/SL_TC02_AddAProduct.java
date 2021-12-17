package apk.app.saucelab.testscripts;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import apk.app.saucelab.utilities.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SL_TC02_AddAProduct extends BaseClass{

	SL_TC01_LoginTest loginTest;
	
	
	
	@Test
	public void verifyUserCanAddAProductSuccessfully() throws MalformedURLException, InterruptedException {
		
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
		
	}
	
}
