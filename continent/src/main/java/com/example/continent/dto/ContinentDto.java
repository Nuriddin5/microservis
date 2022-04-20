package com.example.continent.dto;


// t.me/superJavaDeveloper 19.04.2022;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
//@Entity

public class ContinentDto {
    Long continentId;
    String name;
    List<Country> countries;
}
