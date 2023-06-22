Feature: Bir kullanici olarak siteye kaydoldugum email ve password bilgilerimle login olabilmek istiyorum.

  Background: Kullanicilar bu adimlar sayesinde ayni adimlari yazmalarina gerek kalmadan before mantiginda backrounda da calistirir
    * Kullanici browseri acar adresine
    * Kullanici "https://qa.mealscenter.com/" adresine
    * Kullanici cokkies 406 1654 i kabul eder
    * Uc cizgi butonuna tiklar
    * Kullanici SignIn butonuna tiklar

  Scenario: "Sign in" linkine tiklayinca login sayfasina yonlendirilmeli
    * Kullanici login sayfasina yonlendirildigini dogrular
    * Kullanici sayfayi kapatir

  Scenario:Gecerli email ve password ile login olabilmeli, basarili giris yapildiginde header sag ustte kullanici adı gorulmelidir
    *  Kullanici emailBox a "mailMeal" passwordbox a bir "sifre" gonderir
    *  Kullanici giris islemini dogrular
    *  Kullanici sayfayi kapatir
  @smoke
  Scenario Outline: Kullanici gecersiz mail ve sifre bilgileriyle giris yapmamalidir
    *  Kullanici emailBox a "<mailMeal>" passwordbox a bir "<sifre>" gonderir
    *  Kullanici sayfayi kapatir
    Examples:
      | mailMeal |sifre |
      | olumsuzmail1 |olumsuzsifre1|
      | olumsuzmail2 |olumsuzsifre2|
      | olumsuzmail3 |olumsuzsifre3|

