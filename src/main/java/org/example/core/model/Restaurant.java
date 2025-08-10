package org.example.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "restaurant")
public class Restaurant {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "expertise level", nullable = false)  // column name with space as requested
    private ExpertiseLevel expertiseLevel;

    @Column(name = "age")
    private Integer age;

    // One-to-one: restaurant.storage_id → storage_room.id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "storage_id", unique = true)
    private StorageRoom storageRoom;

    // One restaurant → many recipes (the FK is in Recipe.restaurant_id)
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Recipe> recipes = new ArrayList<>();
}
