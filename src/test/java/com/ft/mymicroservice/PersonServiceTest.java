package com.ft.mymicroservice;

import com.ft.mymicroservice.model.Person;
import com.ft.mymicroservice.repository.PersonRepository;
import com.ft.mymicroservice.service.PersonService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Optional;

@ExtendWith(MockitoExtension.class) // Extensie JUnit pentru Mockito
public class PersonServiceTest {

	@InjectMocks
	private PersonService personService;

	@Mock
	private PersonRepository personRepository;

	// Testeaza scenariul in care persoana exista
	@Test
	public void testGetPersonByName_PersonExists() {
		Person person = new Person();
		person.setNume("Ion");
		person.setPrenume("Popescu");

		when(personRepository.findByNumeAndPrenume("Ion", "Popescu")).thenReturn(Optional.of(person));

		Optional<Person> result = personService.getPersonByName("Ion", "Popescu");

		assertTrue(result.isPresent()); // Verifica daca persoana a fost gasita
		assertEquals("Ion", result.get().getNume()); // Verifica numele persoanei
	}

	// Testeaza scenariul in care persoana nu exista
	@Test
	public void testGetPersonByName_PersonNotExists() {
		when(personRepository.findByNumeAndPrenume("Ion", "Popescu")).thenReturn(Optional.empty());

		Optional<Person> result = personService.getPersonByName("Ion", "Popescu");

		assertFalse(result.isPresent()); // Verifica daca persoana nu a fost gasita
	}
}
