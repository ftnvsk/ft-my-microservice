package com.ft.mymicroservice.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity // Defineste aceasta clasa ca entitate JPA
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Cheie primara generata automat
    private Long id;

    private String nume; // Numele persoanei
    private String prenume; // Prenumele persoanei
    private String adresa; // Adresa persoanei
    private String oras; // Orasul persoanei
    private LocalDate dataNasterii; // Data nasterii persoanei

    @OneToMany(mappedBy = "person") // Relatie de tip One-to-Many cu entitatea Order
    private List<Order> orders; // Lista de comenzi asociata acestei persoane

    // Getteri si Setteri pentru toate campurile
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }

    public String getPrenume() { return prenume; }
    public void setPrenume(String prenume) { this.prenume = prenume; }

    public String getAdresa() { return adresa; }
    public void setAdresa(String adresa) { this.adresa = adresa; }

    public String getOras() { return oras; }
    public void setOras(String oras) { this.oras = oras; }

    public LocalDate getDataNasterii() { return dataNasterii; }
    public void setDataNasterii(LocalDate dataNasterii) { this.dataNasterii = dataNasterii; }

    public List<Order> getOrders() { return orders; }
    public void setOrders(List<Order> orders) { this.orders = orders; }
}
