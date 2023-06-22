
Feature: Bir ziyaretci olarak headr kismindaki fonnksiyonlar erisilebilir olmalidir


  Background: Kullanicilar bu adimlar sayesinde ayni adimlari yazmalarina gerek kalmadan before mantiginda backrounda da calistirir
    * Kullanici browseri acar adresine
    * Kullanici "https://qa.mealscenter.com/" adresine


  Scenario: "Sign in"butonu gorunur oldugu dogrulanmali
    * Uc cizgi butonuna tiklar
    * Sign in butonun gorulebilir oldugunu dogrular
    * Kullanici sayfayi kapatir



  Scenario: header kismindaki logonun gorulebilir oldugu dogulanmali
    * Kullanici header kisminda bulunan logonun gorulebilir oldugunu dogrular
    * Kullanici sayfayi kapatir

