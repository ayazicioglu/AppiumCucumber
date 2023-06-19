package stepDefinitions;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.cucumber.java.en.Given;
import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class apkYuklemeStep {
    AndroidDriver<MobileElement> driver;
    final String cihazAdi = "Pixel_3a_API_33_x86_64";
    final String platformIsmi = "Android";
    final String version = "13.0";
    final String automation = "UiAutomator2";


    @Given("Kullanici gerekli adimlari tamamlayarak {string} yukler")
    public void kullaniciGerekliAdimlariTamamlayarakYukler(String apk) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", cihazAdi);
        capabilities.setCapability("platformName", platformIsmi);
        capabilities.setCapability("platformVersion", version);
        capabilities.setCapability("automationName", automation);
        capabilities.setCapability("app", ConfigReader.getProperty(apk));
        this.driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        this.driver.manage().timeouts().implicitlyWait(20L, TimeUnit.SECONDS);
    }
}
