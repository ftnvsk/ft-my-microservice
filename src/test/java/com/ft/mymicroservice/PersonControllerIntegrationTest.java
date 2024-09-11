package com.ft.mymicroservice;

import com.ft.mymicroservice.model.Person;
import com.ft.mymicroservice.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest // Ruleaza testele intr-un context Spring Boot complet
@AutoConfigureMockMvc // Configureaza automat MockMvc pentru testarea controllerelor
public class PersonControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PersonRepository personRepository;

    // Testeaza scenariul in care persoana exista
    @Test
    public void testGetPerson_PersonExists() throws Exception {
        Person person = new Person();
        person.setNume("Ion");
        person.setPrenume("Popescu");
        personRepository.save(person);

        mockMvc.perform(get("/api/person")
                        .param("nume", "Ion")
                        .param("prenume", "Popescu"))
                .andExpect(status().isOk()) // Verifica daca statusul este 200 OK
                .andExpect(jsonPath("$.nume").value("Ion")) // Verifica daca numele este corect
                .andExpect(jsonPath("$.prenume").value("Popescu")); // Verifica daca prenumele este corect
    }

    // Testeaza scenariul in care persoana nu exista
    @Test
    public void testGetPerson_PersonNotExists() throws Exception {
        mockMvc.perform(get("/api/person")
                        .param("nume", "Ion")
                        .param("prenume", "Popescu"))
                .andExpect(status().isNotFound()); // Verifica daca statusul este 404 Not Found
    }
}
