package com.ft.mymicroservice.controller;

import com.ft.mymicroservice.model.Person;
import com.ft.mymicroservice.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Optional;

@RestController // Defineste un REST Controller
@RequestMapping("/api/person") // Specifica ruta de baza pentru operatiile pentru toate persoanele
public class PersonController {

    @Autowired
    private PersonService personService;

    // Endpoint ca sa gasim o persoana dupa nume si prenume
    @GetMapping
    public ResponseEntity<Person> getPerson(@RequestParam String nume, @RequestParam String prenume) {
        Optional<Person> person = personService.getPersonByName(nume, prenume);
        if (person.isPresent()) {
            return ResponseEntity.ok(person.get()); // Returneaza persoana daca este gasita
        } else {
            return ResponseEntity.notFound().build(); // Returneaza 404 daca persoana nu este gasita
        }
    }
}
