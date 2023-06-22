package stepDefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import io.cucumber.java.en.Given;
import org.junit.Assert;
import pages.BrowserPage.MealCenterPage;
import utils.BrowserDriver;
import utils.ConfigReader;
import utils.ReusableMethods;

public class mealCenterSteps {
    MealCenterPage meal=new MealCenterPage();

    @Given("Kullanici browseri acar adresine")
    public void kullanici_browseri_acar_adresine() {
        BrowserDriver.getBrowserDriver();
    }
    @Given("Kullanici {string} adresine")
    public void kullanici_adresine(String url) {
        BrowserDriver.getBrowserDriver().get(url);
    }

    @Given("Kullanici cokkies {int} {int} i kabul eder")
    public void kullanici_cokkies_i_kabul_eder(Integer x, Integer y) {
        TouchAction action=new TouchAction<>(BrowserDriver.getBrowserDriver());
        action.press(PointOption.point(x,y)).release().perform();
    }
    @Given("Uc cizgi butonuna tiklar")
    public void uc_cizgi_butonuna_tiklar() {
        ReusableMethods.bekle(2);
        meal.ucCizgiButon.click();
    }
    @Given("Sign in butonun gorulebilir oldugunu dogrular")
    public void sign_in_butonun_gorulebilir_oldugunu_dogrular() {

        Assert.assertTrue(meal.signInButton.isDisplayed());
    }
    @Given("Kullanici header kisminda bulunan logonun gorulebilir oldugunu dogrular")
    public void kullanici_header_kisminda_bulunan_logonun_gorulebilir_oldugunu_dogrular() {

        Assert.assertTrue(meal.headerLogo.isDisplayed());
    }

    @Given("Kullanici sayfayi kapatir")
    public void kullanici_sayfayi_kapatir() {
        BrowserDriver.quitAppiumDriver();
    }
    @Given("Kullanici SignIn butonuna tiklar")
    public void kullanici_sign_in_butonuna_tiklar() {
        meal.signInButton.click();
    }
    @Given("Kullanici login sayfasina yonlendirildigini dogrular")
    public void kullanici_login_sayfasina_yonlendirildigini_dogrular() {
        String actualUrl= BrowserDriver.getBrowserDriver().getCurrentUrl();
        String expected= ConfigReader.getProperty("expected");
        Assert.assertEquals("LOGIN SAYFASINA YONLENDIREMEDI",expected,actualUrl);
    }

    @Given("Kullanici emailBox a {string} passwordbox a bir {string} gonderir")
    public void kullanici_email_box_a_passwordbox_a_bir_gonderir(String mail, String password) {
        meal.loginMethodu(ConfigReader.getProperty(mail),ConfigReader.getProperty(password));
    }
    @Given("Kullanici giris islemini dogrular")
    public void kullanici_giris_islemini_dogrular() {
        ReusableMethods.bekle(2);

        Assert.assertTrue("kullanici giris yapamadi",meal.loginCheck.isDisplayed());
    }

}