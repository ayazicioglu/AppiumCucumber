@but
Feature:Aile butcem gelir page
  Scenario:  Kullanici gelir durmunda degisiklik yapar ve sonuclari gorur

    Given ilk ekran ayarlarini yapin ve ardindan login sayfasina ulasin
    When "mail" ve "password" bilgilerini girerek kullanici bilgileriyle "Giriş Yap" a tiklayin
    And uygulamaya kullanici bilgileriyle giris yapildigini dogrulayin
    And anasayfadaki arti butonuna tiklayin
    And  gelir ekle bolumune tiklayin
    And aciklama,gelir tip, kategori, tarih ve tutari belirleyin ve kaydedin
    Then basariyla eklendigini dogrulayin

