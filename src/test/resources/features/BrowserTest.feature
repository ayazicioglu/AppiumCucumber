@browser
Feature: Kullanici browser testlerini gerçeklestiri

  Scenario: Kullanici basarili bir sekilde amazon web sitesindeki gorevleri yerine getirir

    Given Kullanici "https://www.amazon.com" adresine gider
    Then Kullanici arama kutusuna "Nutella" yazar ve aratir