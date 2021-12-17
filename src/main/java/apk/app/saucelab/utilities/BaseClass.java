package apk.app.saucelab.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	
	public static AndroidDriver<AndroidElement> fn_setUp() throws MalformedURLException {

		// Provide file location
		File appDir = new File("./application");
		File app = new File(appDir, "SauceLab.apk");

		// Reading a Properties file
		File file =  new File("");
		File f = new File(file.getAbsoluteFile() + "//config.properties");
		String deviceType = "";
		
		Properties prop = new Properties();
		 try {
			prop.load(new FileInputStream(f));
			deviceType = prop.getProperty("deviceType");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		// Start setting up Desired capabilities
		DesiredCapabilities desCap = new DesiredCapabilities();

		// Device Name
		if (deviceType.equalsIgnoreCase("EMU")) {
			desCap.setCapability(MobileCapabilityType.DEVICE_NAME, "AbhiDeviceEmulator");
		} else if (deviceType.equalsIgnoreCase("PHY")) {
			desCap.setCapability(MobileCapabilityType.DEVICE_NAME, "Android Device");
		}

		// APK file path
		desCap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());

		// Automator name (Automation Testing Framework)
		desCap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
		desCap.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");

		// Initialize Android driver with URL and desired capabilities
		AndroidDriver<AndroidElement> mobileDriver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
				desCap);
		mobileDriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return mobileDriver;

	}

}
