# ft-my-microservice
My Java Learning and First MicroService project


SPRING proiect creat cu https://start.spring.io/

Structura proiectului:

Controller:
- PersonController.java: Controleaza cererile de tip GET si returneaza informatii despre persoana.

Serviciu:
- PersonService.java: Contine logica de business si acceseaza datele prin intermediul repository-urilor.

Repository-uri:
- PersonRepository.java: Acceseaza baza de date pentru entitatea Person.
- (optional) OrderRepository.java: Accesează baza de date pentru entitatea Order.

Modele:
- Person.java: Definirea modelului pentru o persoana. Este necesar. 
- (optional) Order.java: Definirea modelului pentru comenzi asociate persoanelor. 

Test unitare:
- PersonServiceTest.java: Testeaza daca serviciul returneaza corect persoana.

Test de integrare:
- PersonControllerIntegrationTest.java: Verifica comportamentul complet al endpoint-ului GET, inclusiv integrarea cu baza de date.