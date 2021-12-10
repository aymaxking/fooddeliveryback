package com.blackhole.fooddelivery.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "menu")
@NoArgsConstructor
public class Menu {
    @Id
    @GeneratedValue
    @Column(name = "menu_id")
    private Long id;
    @Column(name = "menu")
    String title;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "menu_id", nullable = false)
    private List<SubMenu> subMenus = new ArrayList<SubMenu>();

    public Menu(String title) {
        this.title = title;
    }
}
