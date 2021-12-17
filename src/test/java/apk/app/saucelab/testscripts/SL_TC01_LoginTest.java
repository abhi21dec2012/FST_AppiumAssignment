package apk.app.saucelab.testscripts;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import apk.app.saucelab.utilities.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class SL_TC01_LoginTest extends BaseClass{

	@Test
	public void verifyUserCanLoginSuccessfully() throws MalformedURLException {
		
		AndroidDriver<AndroidElement> mobileDriver = fn_setUp();
		MobileElement userName = (MobileElement) mobileDriver.findElementByAccessibilityId("test-Username");
		userName.sendKeys("standard_user");
		MobileElement userPassword = (MobileElement) mobileDriver.findElementByAccessibilityId("test-Password");
		userPassword.sendKeys("secret_sauce");
		MobileElement loginBTN = (MobileElement) mobileDriver.findElementByAccessibilityId("test-LOGIN");
		loginBTN.click();
		MobileElement logoutLINK = (MobileElement) mobileDriver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView");
		logoutLINK.click();

	}
	
	


}
