package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.Commande;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommandeRepository extends JpaRepository<Commande, Long> {
    Page<Commande> findAll(Pageable pageable);
    List<Commande> findAllByIdclient(Long aLong);
    List<Commande> findAllByIddelivery(Long aLong);
}
