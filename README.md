Stworzenie aplikacji serwerowej z wykorzystaniem frameworka Spring (Spring Boot)
serwującej użytkownikowi historyczne (miniony tydzień) dane meteorologiczne z publicznego API (https://open-meteo.com).
Serwer powinien wystawiać endpoint akceptujący długość i szerokość geograficzną.
Zwracane informacje muszą zawierać w sobie średnią ilość opadów danego dnia oraz czas wschodu/zachodu słońca.
Aplikacja powinna każdorazowo zapisywać w relacyjnej bazie danych czas oraz parametry wywołania endpointu.

Example of the urls:
http://localhost:8090/weather/search?latitude=10.52&longitude=20.41&timeZone=EAT
http://localhost:8090/weather/search?latitude=52.52&longitude=13.41
