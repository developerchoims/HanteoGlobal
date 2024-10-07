package com.hanteo.task1.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Size(max = 255)
    @NotNull
    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "board_id")
    private Integer boardId;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "category_parents",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "parent_id"))
    private Set<Category> categories = new LinkedHashSet<>();

    @OneToMany(mappedBy = "category")
    private Set<Post> posts = new LinkedHashSet<>();


}