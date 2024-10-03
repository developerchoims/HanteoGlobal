package com.hanteo.task1.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "parent")
    private List<Category> children;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Category parent;

}
