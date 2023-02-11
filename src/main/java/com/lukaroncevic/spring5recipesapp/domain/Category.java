package com.lukaroncevic.spring5recipesapp.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    @ManyToMany(mappedBy = "categories")
    @EqualsAndHashCode.Exclude private Set<Recipe> recipes = new HashSet<Recipe>();

}
