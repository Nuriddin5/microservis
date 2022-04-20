package com.example.continent.dto;


// t.me/superJavaDeveloper 15.04.2022;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity

public class Country {
    @Id
    @Column(name = "id", nullable = false)

    private Long id;

    String name;

    Long continentId;

    public Country(String name) {
        this.name = name;
    }
}
