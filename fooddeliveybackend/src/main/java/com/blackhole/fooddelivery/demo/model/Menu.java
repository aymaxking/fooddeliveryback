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
    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;
    @OneToMany(mappedBy="menu")
    private List<SubMenu> subMenus = new ArrayList<SubMenu>();

    public Menu(String title) {
        this.title = title;
    }
}
