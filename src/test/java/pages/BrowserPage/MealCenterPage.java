package pages.BrowserPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserDriver;

public class MealCenterPage {

    public MealCenterPage(){
        PageFactory.initElements((WebDriver) BrowserDriver.getBrowserDriver(),this);
    }


    @FindBy(xpath ="//div[@class='hamburger hamburger--3dx']")
    public WebElement ucCizgiButon;

    @FindBy(xpath = "(//*[text()='Sign in'])[2]")
    public WebElement signInButton;

    @FindBy(xpath = "//img[@src='/themes/karenderia_v2/assets/images/shopping-bag.svg']")
    public WebElement headerCart;

    @FindBy(xpath = "(//img[@class='img-200'])[1]")
    public WebElement headerLogo;

    @FindBy(xpath = "//*[@type='text']")
    public WebElement emailBox;

    @FindBy(xpath = "//*[@type='password']")
    public WebElement passwordBox;

    @FindBy(xpath = "(//*[text()='Sign in'])[2]")
    public WebElement signInLoginButton;

    @FindBy(xpath = "//img[@class='img-30 rounded-pill lozad loaded']")
    public WebElement loginCheck;

    public void loginMethodu(String mail,String password){
        emailBox.sendKeys(mail);
        passwordBox.sendKeys(password);
        signInLoginButton.click();
    }

    @FindBy(xpath = "(//*[text()=' Manage my account '])[2]")
    public WebElement manageMyAccount;


}