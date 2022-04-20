package com.example.continent.entity;


// t.me/superJavaDeveloper 15.04.2022;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Continent {
    @Id
    @Column(name = "id", nullable = false)

    private Long id;

    String name;

    public Continent(String name) {
        this.name = name;
    }
}
