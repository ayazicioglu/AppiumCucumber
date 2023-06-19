package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.BrowserPage.AmazonPage;
import utils.BrowserDriver;
import utils.Driver;

public class amazonBrowserSteps {
    AmazonPage amazonPage=new AmazonPage();

    @Given("Kullanici {string} adresine gider")
    public void kullanici_adresine_gider(String url) {
        BrowserDriver.getBrowserDriver().get(url);
    }

    @Then("Kullanici arama kutusuna {string} yazar ve aratir")
    public void kullaniciAramaKutusunaYazarVeAratir(String kelime) {
        amazonPage.amazonAramaKutusu.sendKeys("Nutella");
    }
}
