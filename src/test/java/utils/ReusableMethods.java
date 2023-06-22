package utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class ReusableMethods {
    static AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();
    static TouchAction action=new TouchAction<>(driver);
    public static void scrollWithUiScrollable(String elementText) {
        AndroidDriver driver = (AndroidDriver)  Driver.getAndroidDriver();
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + elementText + "\"))");
        driver.findElementByXPath("//*[@text='" + elementText + "']").click();
    }
    public static String getScreenshot(String name) throws IOException {
        // naming the screenshot with the current date to avoid duplication
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        // TakesScreenshot is an interface of selenium that takes the screenshot
        TakesScreenshot ts = (TakesScreenshot)Driver.getAndroidDriver();

        File source = ts.getScreenshotAs(OutputType.FILE);
        // full path to the screenshot location
        String target = System.getProperty("user.dir") + "/target/Screenshots/" + name + date + ".png";
        File finalDestination = new File(target);
        // save the screenshot to the path given
        FileUtils.copyFile(source, finalDestination);
        return target;
    }
    public static void bekle(int saniye){
        try {
            Thread.sleep(saniye*1000);
        } catch (InterruptedException e) {
        }
    }
    public static void koordinataTikla(int xKoordinat,int yKoordinat){
        action.press(PointOption.point(xKoordinat,yKoordinat)).release().perform();
    }
    public static void birNoktadanDigerineSurukle(int x1, int y1, int x2, int y2){
        action.press(PointOption.point(x1,y1)).            //Baslangic koordinatlarini belirle
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).// bekleme suresini belirle
                moveTo(PointOption.point(x2,y2)).            //Bitis koordinatlarini belirle
                release().perform();
    }
    public static void yazilanlariBackspaceleSil(){
        for (int i = 0; i < 50; i++) {
            driver.getKeyboard().sendKeys(Keys.BACK_SPACE);
        }
    }

}
