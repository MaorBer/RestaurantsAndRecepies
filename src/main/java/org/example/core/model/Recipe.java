package org.example.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "recipe")
public class Recipe {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "difficulty", nullable = false)
    private Difficulty difficulty;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private RecipeType type;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "author_chef")
    private String authorChef;

    // Many recipes belong to one restaurant → recipe.restaurant_id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    // Many-to-many via recipe_ingrediants_scope(recipe_id, ingrediants_id)
    @ManyToMany
    @JoinTable(
            name = "recipe_ingrediants_scope",
            joinColumns = @JoinColumn(name = "recipe_id"),
            inverseJoinColumns = @JoinColumn(name = "ingrediants_id")
    )
    private Set<Ingredient> ingrediants = new HashSet<>();
}
