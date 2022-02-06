package com.blackhole.fooddelivery.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@Inheritance(strategy=InheritanceType.JOINED)
@DiscriminatorColumn(name="user_type")
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String username;

    private String password;

    private String role;

    @Lob
    @Column(name = "picture", length = 100000)
    byte[] img;


}