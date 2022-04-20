package com.example.continent.controller;


// t.me/superJavaDeveloper 15.04.2022;

import com.example.continent.entity.Continent;
import com.example.continent.service.ContinentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/continent")
@RestController
public class ContinentCon {

    @Autowired
    ContinentService continentService;

    @GetMapping
    public HttpEntity<?> getContinents() {
        if (continentService.getContinents() == null) {
            return ResponseEntity.internalServerError().body("error");
        }
            return ResponseEntity.ok().body(continentService.getContinents());
    }

    @GetMapping("{id}")
    public HttpEntity<?> getContinent(@PathVariable Long id) {
        if (continentService.getContinent(id) == null) {
            return ResponseEntity.notFound().build();
        }
            return ResponseEntity.ok().body(continentService.getContinent(id));
    }

    @DeleteMapping("{id}")
    public HttpEntity<?> deleteContinent(@PathVariable Long id) {
        if (continentService.deleteContinent(id) == null) {
            return ResponseEntity.badRequest().body("bad request");
        }
        if (continentService.deleteContinent(id)) {
            return ResponseEntity.noContent().build();
        }
            return ResponseEntity.notFound().build();
    }

    @PostMapping
    public HttpEntity<?> addContinent(String continentName) {
        return ResponseEntity.ok().body(continentService.addContinent(continentName));
    }


}
