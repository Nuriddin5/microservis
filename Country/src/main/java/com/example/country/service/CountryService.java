package com.example.country.service;


// t.me/superJavaDeveloper 15.04.2022;

import com.example.country.dto.ContinentDto;
import com.example.country.dto.CountryDto;
import com.example.country.entity.Country;
import com.example.country.repository.CountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class CountryService {

    @Autowired
    CountryRepo countryRepo;
    @Autowired
    RestTemplate restTemplate;

    public ArrayList<CountryDto> getCountries() {
        List<Country> all = countryRepo.findAll();
       ArrayList<CountryDto> countryDtos = new ArrayList<>();
        for (Country country : all) {
            ContinentDto continentDto = restTemplate.getForObject(
                    "http://continent/continent/1",
                    ContinentDto.class
            );

            assert continentDto != null;
            countryDtos.add(new CountryDto(
                    country.getId(),
                    country.getName(),
                    continentDto.getId(),
                    continentDto.getName()
            ));

        }


        return countryDtos;

    }

    public Country getCountry(Long id) {
        Optional<Country> continentOptional = countryRepo.findById(id);
        return continentOptional.orElse(null);
    }

    public Boolean deleteCountry(Long id) {
        if (!countryRepo.existsById(id)) {
            return null;
        }
        countryRepo.deleteById(id);
        return !countryRepo.existsById(id);

    }

    public Country addCountry(String continentName) {

        return  countryRepo.save(new Country(continentName));

    }


}
