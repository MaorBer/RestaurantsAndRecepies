package org.example.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "ingrediants")
public class Ingredient {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "is_kosher", nullable = false)
    private boolean isKosher;

    @ManyToMany(mappedBy = "ingrediants")
    @JsonIgnore
    private Set<Recipe> recipes = new HashSet<>();
}
