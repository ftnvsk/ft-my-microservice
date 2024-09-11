package com.ft.mymicroservice.repository;

import com.ft.mymicroservice.model.Order;
import com.ft.mymicroservice.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // Gasesc comenzile asociate unei persoane
    List<Order> findByPerson(Person person);
}
