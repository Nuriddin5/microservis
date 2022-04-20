package com.example.country.controller;


// t.me/superJavaDeveloper 15.04.2022;


import com.example.country.service.CountryService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/country")
@RestController
public class CountryCon {

    @Autowired
    CountryService countryService;

    @HystrixCommand(fallbackMethod = "fallbackMethod")
    @GetMapping
    public HttpEntity<?> getCountries() {
        if (countryService.getCountries() == null) {
            return ResponseEntity.internalServerError().body("error");
        }
        return ResponseEntity.ok().body(countryService.getCountries());
    }

    @GetMapping("{id}")
    public HttpEntity<?> getCountry(@PathVariable Long id) {
        if (countryService.getCountry(id) == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(countryService.getCountry(id));
    }

    @DeleteMapping("{id}")
    public HttpEntity<?> deleteCountry(@PathVariable Long id) {
        if (countryService.deleteCountry(id) == null) {
            return ResponseEntity.badRequest().body("bad request");
        }
        if (countryService.deleteCountry(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public HttpEntity<?> addCountry(String countryName) {
        return ResponseEntity.ok().body(countryService.addCountry(countryName));
    }

    public HttpEntity<?> fallbackMethod() {
        return new ResponseEntity<>("Try again later", HttpStatus.REQUEST_TIMEOUT);
    }

}
