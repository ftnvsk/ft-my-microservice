package com.ft.mymicroservice.model;

import jakarta.persistence.*;

@Entity // Defineste clasa asta ca entitate JPA
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cheie primara generata automat
    private Long id;

    private String detaliiComanda; // Detalii despre comanda

    @ManyToOne // Relatie de tip Many-to-One cu entitatea Person
    @JoinColumn(name = "person_id") // Coloana "person_id" pentru asocierea comenzii cu persoana
    private Person person; // Persoana asociata acestei comenzi

    // Getteri si Setteri pentru toate campurile
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDetaliiComanda() { return detaliiComanda; }
    public void setDetaliiComanda(String detaliiComanda) { this.detaliiComanda = detaliiComanda; }

    public Person getPerson() { return person; }
    public void setPerson(Person person) { this.person = person; }
}
