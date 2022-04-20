package com.example.continent.service;


// t.me/superJavaDeveloper 15.04.2022;

import com.example.continent.dto.ContinentDto;
import com.example.continent.entity.Continent;
import com.example.continent.repository.ContinentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class ContinentService {

    @Autowired
    ContinentRepo continentRepo;

    public List<Continent> getContinents() {
        List<Continent> all;
        try {
            all = continentRepo.findAll();
        } catch (Exception e) {
            return null;
        }
        return all;

    }

    public List<ContinentDto> getContinentsWithCountries() {
        ArrayList<ContinentDto> continentDtoArrayList = new ArrayList<>();


        return  null;
    }

    public Continent getContinent(Long id) {
        Optional<Continent> continentOptional = continentRepo.findById(id);
        return continentOptional.orElse(null);
    }

    public Boolean deleteContinent(Long id) {
        if (!continentRepo.existsById(id)) {
            return null;
        }
        continentRepo.deleteById(id);
        return !continentRepo.existsById(id);

    }

    public Continent addContinent(String continentName) {

        return  continentRepo.save(new Continent(continentName));

    }


}
