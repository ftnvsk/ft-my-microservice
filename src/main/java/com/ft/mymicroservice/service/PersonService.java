package com.ft.mymicroservice.service;

import com.ft.mymicroservice.model.Person;
import com.ft.mymicroservice.model.Order;
import com.ft.mymicroservice.repository.PersonRepository;
import com.ft.mymicroservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Defineste aceasta clasa ca serviciu gestionat de Spring
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private OrderRepository orderRepository;

    // Gasesc o persoana dupa nume si prenume
    public Optional<Person> getPersonByName(String nume, String prenume) {
        return personRepository.findByNumeAndPrenume(nume, prenume);
    }

    // Gasesc comenzile asociate unei persoane
    public List<Order> getOrdersByPerson(Person person) {
        return orderRepository.findByPerson(person);
    }
}
