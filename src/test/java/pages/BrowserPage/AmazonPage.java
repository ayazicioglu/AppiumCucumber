package pages.BrowserPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;

public class AmazonPage {

    public AmazonPage(){
        PageFactory.initElements((WebDriver) BrowserDriver.getBrowserDriver(),this);
    }

    @FindBy(xpath = "//*[@type='text']")
    public WebElement amazonAramaKutusu;
}