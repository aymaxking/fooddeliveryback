package com.blackhole.fooddelivery.demo.dao;

import com.blackhole.fooddelivery.demo.model.Category;
import com.blackhole.fooddelivery.demo.model.Client;
import com.blackhole.fooddelivery.demo.model.Place;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {
    Page<Client> findAll(Pageable pageable);

    List<Client> findByUsernameContainsOrNameContainsOrCINContains(String username, String name,String cin);

    Page<Client> findByUsernameContainsOrNameContainsOrCINContains(String username, String name,String cin,Pageable pageable);

}
