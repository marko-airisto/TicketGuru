## TicketGuru - lipunmyyntijärjestelmä 

Projektin tarkoituksena on tuottaa lipunmyyntijärjestelmä TicketGuru –nimiselle toimitsijalle. Toimitsija toimii projektin aloittaessa kivijalkaliike-periaatteella, mutta toimitsijan tarkoituksena on jatkokehittää ja laajentaa palveluitaan myös verkkokaupan suuntaan, jonka myötä asiakkaat voivat itse ostaa ja tulostaa lippuja suoraan järjestelmän verkkokaupasta. 

 

Toimitsijan tulee pystyä määrittelemään järjestelmään tapahtumat tietoineen (tapahtuma, lippukapasiteetti, lipputyypit, aika ja paikka, jne.), joihin lippuja myydään. Liput tulee pystyä tulostamaan järjestelmästä asiakkaalle myynnin yhteydessä. Lisäksi, ennakkomyynnin loputtua, jäljellä olevien lippujen tulostus, ovella myynti sekä lippujen tarkastaminen ovella lipulla olevan koodin perusteella tulee mahdollistaa järjestelmän kautta. 

  

TicketGurun tilaaman lipunmyyntijärjestelmän tarkoituksena on koota tiedot järjestettävistä tilaisuuksista (tilaisuuden laji, paikka, ikärajat, lippuryhmät, jne.) yhden ja saman tietojärjestelmän sisälle, joka mahdollistaa lippumyynnin helposti. 

Lipunmyyntijärjestelmä on tarkoitettu aluksi käytettäväksi TicketGurun myyntipisteessä TicketGurun työntekijöiden toimesta, myöhemmin tarkoitus laajentaa käytettäväksi myös asiakkaiden toimesta verkkokaupan muodossa. 

Toteutus- ja toimintaympäristö: 

Java 

SpringBoot 

Thymeleaf / React 

MariaDB 

Järjestelmä on tarkoitettu käytettäväksi selaimen kautta päätteellä, ja sen on tarkoitus olla selainriippumaton. 

  

## Järjestelmän määrittely 

  

-   TicketGuru-järjestelmän käyttäjinä ovat pääasiassa lippupisteiden jälleenmyyjät sekä lippupisteiden myyntikoordinaattorit: jälleenmyyjät toimivat kivijalkaliikkeessä myynnin puolella, myyntikoordinaattorit puolestaan toimivat linkkinä tapahtumien järjestäjiin, syöttäen tapahtumat ja niiden tiedot järjestelmään. 

 

- [User case diagram](https://github.com/marko-airisto/TicketGuru/blob/master/Usercase__NZ_30012010.pdf) 

 

### Käyttäjätarinat: 

- Myyjänä haluan, että saan esille tapahtumien listauksen, jotta näen koko valikoiman 

- Myyjänä haluan, että saan tapahtumien listan järjestetty eri tavalla, jotta saan valita tarvittavan 

- Myyjänä haluan, että saan esille valitun tapahtuman tiedot, jotta voin selvittää myyntiehdot 

- Myyjänä haluan, että saan luoda uuden myyntitapahtuman (Osto), jotta voin aloittaa asiakaspalvelun 

- Myyjänä haluan, että saan lisätä tapahtumalle eri tapahtumien liput, jotta valmistan asiakkaan ostoskorin 

- Myyjänä haluan, että pystyn muokkaamaan ja poistamaan tapahtumissa olevat liput, jotta kykenen korjaamaan asiakkaan ostoskorin 

- Myyjänä haluan, että pystyn siirtymään helposti yhdestä napista takaisin edelliseen näkymään. 

- Myyjänä haluan, että valmistan (tallennan, vahvistan) myyntitapahtuman asiakkaan ostoskorista, jotta suoritan maksun ja tulostan liput 

- Myyjänä haluan, että jo olleet tapahtumat eivät näy myyntinäkymässä, mutta voin silti tarvittaessa etsiä myös vanhoja tapahtumia. 

- Asiakkaana haluan, että saan maksetut liput tulostettuna myyjältä, jotka esitän tarkastajalle 

- Tarkastajana haluan, että liput voidaan yksinkertaisesti ja yksiselitteisesti tarkista tapahtumaan sisäänpääsyä varten 

- Myyjänä haluan, että saan ostotapahtuman peruttua, jos ostaja peruu kaupan, tai myyjänä teen virheen. 

- Myyntikoordinaattorina haluan, että saan tapahtumia tallennettu järjestelmään, jotta lippuja ko. tapahtumiin voidaan myydä jälleenmyyntipisteessä 

- Myyntikoordinaattorina haluan, että myyntipisteissä ei voida muuttaa tapahtumien tietoja, jottei myyntiprosessi keskeydy. 

- Myyntikoordinaattorina haluan, että pystyn syöttämään tietoja massana (excel, csv), jottei jokaista tapahtumaa pidä syöttää rivi kerrallaan. 

 

 ## Käyttöliittymä 

  

[Homepage](https://github.com/marko-airisto/TicketGuru/blob/master/Homepage.png) 

[Ticket Window](https://github.com/marko-airisto/TicketGuru/blob/master/ChooseTicket.png) 

[Edit Event](https://github.com/marko-airisto/TicketGuru/blob/master/EditTicket.png) 
