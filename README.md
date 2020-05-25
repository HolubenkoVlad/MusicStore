## RockShop
Projekt bol stvorený s pomocou Spring Boot + Hibernate + MySQL + Bootstrap a použitý MVC pattern.
### Ako spustiť?
  1)	Potrebujete uložiť databázu do serveru. Pre tohto spustite script database_v1.sql na MySQL Workbench , alebo MySQL Command Line. Svoj login a heslo do databazu uveďte v src\main\resources\application.properties v 
  ``` 
  spring.datasource.username
  spring.datasource.password
  ```
  2)	Ak chcete spustiť projekt z Eclipsu, to potrebujete inštalovať Spring Tool Suite. Pre tohto v Eclipse->Help->Eclipse Marketplace uveďte STS a inštalujte Spring Tool 4. Alebo môžete  rozmiestniť subor .war z priečinku target na svojom Tomcat Servere.
  3)	V prehliadači uveďte localhost.
### Hierarchia
V baliku *repositories* sú triedy, ktoré pracujú z databázou.\
V baliku *services* sú triedy, ktoré pracujú z triedami repositoriu.\
V baliku *controllers* sú triedy, ktoré pracujú z triedami servisov.\
 ### Javadoc
 Javadoc je uložená v doc/sk/musicstore/
