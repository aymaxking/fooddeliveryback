package com.blackhole.fooddelivery.demo.service.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Data
@Table(name = "type")
@NoArgsConstructor
public class Type {
    @Id
    @GeneratedValue
    @Column(name = "type_id")
    private Long id;
    @Column(name = "type")
    String title;
    @Lob
    byte[] icon;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "category_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Category category;

    public Type(String title, byte[] icon,Category category) {
        this.title = title;
        this.icon = icon;
        this.category=category;
    }
}
