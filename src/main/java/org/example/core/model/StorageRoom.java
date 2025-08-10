package org.example.core.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

@Getter @Setter @NoArgsConstructor
@Entity @Table(name = "storage_room")
public class StorageRoom {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // inverse side of the 1–1; FK lives on Restaurant.storage_id
    @OneToOne(mappedBy = "storageRoom")
    @JsonIgnore
    private Restaurant restaurant;
}
