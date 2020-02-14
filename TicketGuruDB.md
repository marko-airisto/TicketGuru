## TicketGuru-tietokanta

> ### _Postcodes_
> _Postcodes-taulu sisältää kaupunkien postinumerot sekä._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> Postcode_ID | varchar(5) PK | Postinumeron id, postinumero
> City | varchar(100) |  Postinumeroon liitetty kaupunki
> Country | varchar(100) |  Maa, jossa postinumero sekä postinumeroon liitetty kaupunki sijaitsee

> ### _EventTypes_
> _EventTypes-taulu sisältää tapahtumien tyyppiluokat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> EventType_ID | int PK | Tapahtumatyypin id
> EventTypeName | varchar(100) |  Tapahtumatyypin nimi
> EventTypeInfo | varchar(500) | Tapahtumatyypin kuvaus (jätetään pois?)

> ### _AgeLimits_
> _AgeLimits-taulu sisältää ikärajaluokat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> AgeLimit_ID | int PK | Ikärajaluokan id
> AgeLimitName | varchar(50) |  Ikärajaluokan nimi
> AgeLimitSpecifier | varchar(500) | Ikärajaluokan tarkenne

> ### _TicketTypes_
> _TicketTypes-taulu sisältää lippujen tyyppiluokat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> TicketType_ID | int PK | Lipputyypin id
> TicketTypeName | varchar(100) |  Lipputyypin nimi

> ### _TicketStatuses_
> _TicketStatuses-taulu sisältää lippujen tilanneluokat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> TicketStatus_ID | int PK | Lipun tilanne id
> TicketStatusName | varchar(10) |  Lipun tilanteen nimi

> ### _UserGroups_
> _UserGroups-taulu sisältää käyttäjäryhmätiedot._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> UserGroup_ID | int PK | Käyttäjäryhmä id
> UserGroupName | varchar(100) |  Käyttäjäryhmän nimi

> ### _Users_
> _Users-taulu sisältää käyttäjät._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> User_ID | int PK | Käyttäjä id
> UserGroup_ID | int FK |  Käyttäjän käyttäjäryhmä, viittaus [UserGroups](#UserGroups)-tauluun
> UserName | varchar(50) | Käyttäjän nimi 
> Password | varchar(100) | Käyttäjän salasana

> ### _EventOrganizers_
> _EventOrganizers-taulu sisältää tapahtumajärjestäjät._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> EventOrganizer_ID | int PK | Tapahtumajärjestäjä id
> CompanyName | varchar(100) |  Tapahtumajärjestäjän yritysnimi
> CompanyStreetAddress | varchar(150) |  Tapahtumajärjestäjän osoite
> Postcode_ID | int FK | Tapahtumajärjestäjän postinumero, viittaus [Postcodes](#Postcodes)-tauluun
> CompanyTel | varchar(25) |  Tapahtumajärjestäjän puhelinnumero
> CompanyEmail | varchar(150) |  Tapahtumajärjestäjän sähköpostiosoite
> CompanyWWW | varchar(250) |  Tapahtumajärjestäjän www-osoite
> CompanyContactPerson | varchar(150) |  Tapahtumajärjestäjän edustajan nimi

> ### _Venues_
> _Venues-taulu sisältää tapahtumapaikat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> Venue_ID | int PK | Tapahtumapaikka id
> VenueName | varchar(100) |  Tapahtumapaikan nimi
> VenueStreetAddress | varchar(150) |  Tapahtumapaikan osoite
> Postcode_ID | int FK | Tapahtumajärjestäjän postinumero, viittaus [Postcodes](#Postcodes)-tauluun
> VenueTel | varchar(25) |  Tapahtumapaikan puhelinnumero
> VenueEmail | varchar(150) |  Tapahtumapaikan sähköpostiosoite
> VenueWWW | varchar(250) |  Tapahtumapaikan www-osoite
> VenueContactPerson | varchar(150) |  Tapahtumapaikan edustajan nimi

> ### _Events_
> _Events-taulu sisältää tapahtumat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> Event_ID | int PK | Tapahtuma id
> EventName | varchar(250) |  Tapahtuman nimi
> EventType_ID | int FK | Tapahtuman tyyppi, viittaus [EventTypes](#EventTypes)-tauluun
> EventDateTime | datetime |  Tapahtuman päivämäärä ja aika
> EventOrganizer_ID | int FK | Tapahtuman järjestäjä, viittaus [EventOrganizers](#EventOrganizers)-tauluun
> Venue_ID | int FK | Tapahtuman tapahtumapaikka, viittaus [Venues](#Venues)-tauluun
> TicketCapacity | int |  Tapahtumaan maksimissaan myytävien lippujen määrä
> AgeLimit_ID | int FK | Tapahtuman mahdollinen ikärajaluokka, viittaus [AgeLimits](#AgeLimits)-tauluun
> EventInfo | varchar(500) |  Tapahtuman tiedot

> ### _EventTickets_
> _EventTickets-taulu sisältää tapahtumakohtaiset liput._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> EventTicket_ID | int PK | Tapahtumakohtaisen lipun id
> Event_ID | int FK | Lippuun liitetty tapahtuma, viittaus [Events](#Events)-tauluun
> TicketType_ID | int FK | Lippun lipputyyppi, viittaus [TicketTypes](#TicketTypes)-tauluun
> TicketCount | int |  Lipun uniikki yksilöintitieto
> Price | varchar(10) |  Lipun hintatieto

> ### _SaleEvents_
> _SaleEvents-taulu sisältää myyntitapahtumat._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> SaleEvent_ID | int PK | Myyntitapahtuma id
> SaleEventDateTime | datetime |  Myyntitapahtuman päivämäärä ja aika
> User_ID | int FK | Myyntitapahtuman käsittelijätieto, viittaus [Users](#Users)-tauluun

> ### _SaleRows_
> _SaleRows-taulu sisältää myyntitapahtumat yksittäiset myyntirivit._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> SaleRow_ID | int PK | Myyntirivi id
> SaleEvent_ID | int FK | Myyntitapahtumatiedot, viittaus [SaleEvents](#SaleEvents)-tauluun
> Ticket_ID | int FK | Myyntiriviin liitetty lippu, viittaus [Tickets](#Tickets)-tauluun
> Discount | int |  Myyntirivin mahdollinen hinnan alennus tieto

> ### _Tickets_
> _Tickets-taulu sisältää yksittäiset liput._
>
> Kenttä | Tyyppi | Kuvaus
> ------ | ------ | ------
> Ticket_ID | int PK | Lippu id
> EventTicket_ID | int FK | Lippuun liitetyt tapahtumakohtaiset lipputiedot, viittaus [EventTickets](#EventTickets)-tauluun
> TicketStatus_ID | int FK | Lipun tilanne, viittaus [TicketStatuses](#TicketStatuses)-tauluun
> TicketCheckSum | varchar(20) |  Yksittäisen lipun tarkastustieto
