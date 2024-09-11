package com.ft.mymicroservice.repository;

import com.ft.mymicroservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface PersonRepository extends JpaRepository<Person, Long> {
    // Gasesc o persoana dupa nume si prenume
    Optional<Person> findByNumeAndPrenume(String nume, String prenume);
}
