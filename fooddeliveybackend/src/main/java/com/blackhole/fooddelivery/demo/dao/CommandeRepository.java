package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    Page<Commande> findAll(Pageable pageable);
}
