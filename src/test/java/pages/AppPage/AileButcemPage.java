package pages.AppPage;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.ConfigReader;
import utils.Driver;
import utils.ReusableMethods;

import java.time.Duration;

import static org.junit.Assert.assertEquals;

public class AileButcemPage {
    public AileButcemPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getAndroidDriver(), Duration.ofSeconds(15)), this);
    }
    @FindBy(xpath ="//*[@text='E-mail Adresi']")
    public MobileElement mailBox;

    @FindBy(xpath ="//*[@text='Şifre']")
    public MobileElement passwordBox;

    @FindBy(xpath = "//*[@text='Başarıyla giriş yapıldı.']")
    private MobileElement girisBasariliText;

    @FindBy(xpath = "//*[@text='Değişiklikler başarıyla kaydedildi.']")
    private MobileElement degisiklikBasariliText;

    @FindBy(xpath = "(//*[@class='android.widget.ImageView'])[1]")
    public MobileElement menuSol;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[1]")
    public MobileElement menudekiIsim;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[1]")
    public MobileElement isimKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[2]")
    public MobileElement soyisimKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[3]")
    public MobileElement sehirKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[4]")
    public MobileElement yasKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.EditText'])[5]")
    public MobileElement meslekKutusu;

    @FindBy(xpath = "(//*[@class='android.widget.TextView'])[6]")
    public MobileElement gelirDegeri;



    public void basariliGirisTest(){
        String actual=girisBasariliText.getText();
        String expected="Başarıyla giriş yapıldı.";
        assertEquals("Giris basarisiz",expected,actual);
    }
    public void degisiklikBasariTesti(){
        String actual=degisiklikBasariliText.getText();
        String exp="Değişiklikler başarıyla kaydedildi.";
        assertEquals("Degisiklik kaydetme basarisiz",exp,actual);
    }

    public void hesapBilgileriniDegistir(String isim, String soyisim,String sehir, String yas,String meslek){
        isimKutusu.clear();
        isimKutusu.sendKeys(isim);

        soyisimKutusu.clear();
        soyisimKutusu.sendKeys(soyisim);

        sehirKutusu.clear();
        sehirKutusu.sendKeys(sehir);

        yasKutusu.clear();
        yasKutusu.sendKeys(yas);

        meslekKutusu.clear();
        meslekKutusu.sendKeys(meslek);

        ReusableMethods.scrollWithUiScrollable("Kaydet");

    }
    public void hesapBilgiDegisikligiKontrolEt(){
        String actual=isimKutusu.getText();
        String expected= ConfigReader.getProperty("isim");
        assertEquals("Bilgiler uyusmuyor",expected,actual);

        actual=soyisimKutusu.getText();
        expected=ConfigReader.getProperty("soyisim");
        assertEquals("Bilgiler uyusmuyor",expected,actual);

        actual=sehirKutusu.getText();
        expected=ConfigReader.getProperty("sehir");
        assertEquals("Bilgiler uyusmuyor",expected,actual);

        actual=yasKutusu.getText();
        expected=ConfigReader.getProperty("yas");
        assertEquals("Bilgiler uyusmuyor",expected,actual);

        actual=meslekKutusu.getText();
        expected=ConfigReader.getProperty("meslek");
        assertEquals("Bilgiler uyusmuyor",expected,actual);

    }

}
