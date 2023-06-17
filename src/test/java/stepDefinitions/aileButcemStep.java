package stepDefinitions;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AppPage.AileButcemPage;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class aileButcemStep {
    AndroidDriver<AndroidElement> driver=Driver.getAndroidDriver();
    TouchAction action=new TouchAction<>(driver);
    AileButcemPage page=new AileButcemPage();
    public String acilisSayfaGelirDegeri ="";

    @Given("Kullanici kurulumlari tamamlar")
    public void kullanici_kurulumlari_tamamlar() {
        Driver.getAndroidDriver();
    }

    @Then("ilk ekran ayarlarini yapin ve ardindan login sayfasina ulasin")
    public void ilkEkranAyarlariniYapinVeArdindanLoginSayfasinaUlasin() {
        driver.findElementByXPath("//*[@text='Don’t allow']").click();
        for (int i=0;i<6;i++){
            action.press(point(947,1367)).
                    waitAction(waitOptions(Duration.ofMillis(500))).
                    moveTo(point(104,1367)).release().perform();
        }
        driver.findElementByXPath("//*[@text='Giriş Yap']").click();

    }

    @Then("{string} ve {string} bilgilerini girerek kullanici bilgileriyle {string} a tiklayin")
    public void veBilgileriniGirerekKullaniciBilgileriyleATiklayin(String mail, String sifre, String girisYap) {
        page.mailBox.sendKeys(ConfigReader.getProperty(mail));
        page.passwordBox.sendKeys(ConfigReader.getProperty(sifre));
        ReusableMethods.scrollWithUiScrollable(girisYap);
    }

    @Then("uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin")
    public void uygulamayaKullaniciBilgileriyleGirisYapildiginiDogrulayin() {
        page.basariliGirisTest();
    }

    @Then("sol kisimdaki menuden {string} bolumune gidin")
    public void solKisimdakiMenudenBolumuneGidin(String str) {
        ReusableMethods.bekle(5);
        ReusableMethods.koordinataTikla(115,144);
        ReusableMethods.scrollWithUiScrollable(str);
    }

    @Then("hesabim sayfasindaki bilgileri {string},{string},{string},{string},{string} degistirerek degisikleri kaydedin")
    public void hesabimSayfasindakiBilgileriDegistirerekDegisikleriKaydedin(String isim, String soyisim, String sehir, String yas, String meslek) {
        page.hesapBilgileriniDegistir(ConfigReader.getProperty(isim)
                                        ,ConfigReader.getProperty(soyisim)
                                        ,ConfigReader.getProperty(sehir)
                                        ,ConfigReader.getProperty(yas),
                                        ConfigReader.getProperty(meslek));

    }

    @And("ardindan degisiklerin yapildigini dogrulayin")
    public void ardindanDegisiklerinYapildiginiDogrulayin() {
        page.hesapBilgiDegisikligiKontrolEt();

    }

//*********************************************************************************************************************
    @Then("anasayfadaki arti butonuna tiklayin")
    public void anasayfadaki_arti_butonuna_tiklayin() {
        acilisSayfaGelirDegeri =page.gelirDegeri.getText();
        ReusableMethods.koordinataTikla(535,2016);

    }

    @Then("gelir ekle bolumune tiklayin")
    public void gelir_ekle_bolumune_tiklayin() {
        ReusableMethods.scrollWithUiScrollable("Gelir Ekle");

    }

    @When("aciklama,gelir tip, kategori, tarih ve tutari belirleyin ve kaydedin")
    public void aciklama_gelir_tip_kategori_tarih_ve_tutari_belirleyin_ve_kaydedin() {
        ReusableMethods.bekle(3);
        ReusableMethods.scrollWithUiScrollable("Açıklama");
        driver.getKeyboard().sendKeys("Car Selling");
        ReusableMethods.koordinataTikla(997,1999);

        ReusableMethods.scrollWithUiScrollable("Gelir Tipi");
        ReusableMethods.scrollWithUiScrollable("Düzensiz");

        ReusableMethods.scrollWithUiScrollable("Kategori");
        ReusableMethods.scrollWithUiScrollable("Serbest Gelir");

        ReusableMethods.koordinataTikla(958,1302);
       // ReusableMethods.koordinataTikla(251,775);
        ReusableMethods.scrollWithUiScrollable("28");
        ReusableMethods.scrollWithUiScrollable("OK");

        ReusableMethods.scrollWithUiScrollable("Tutar");
        driver.getKeyboard().sendKeys("350000");
        ReusableMethods.koordinataTikla(940,1995);

        ReusableMethods.scrollWithUiScrollable("Kaydet");

    }

    @Then("basariyla eklendigini dogrulayin")
    public void basariyla_eklendigini_dogrulayin() {
        String gelirSonDeger=page.gelirDegeri.getText();
        Assert.assertNotEquals("Gelir ekleme basarisiz",acilisSayfaGelirDegeri,gelirSonDeger);
    }


}
