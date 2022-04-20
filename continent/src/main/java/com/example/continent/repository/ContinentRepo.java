package com.example.continent.repository;

import com.example.continent.entity.Continent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContinentRepo extends JpaRepository<Continent,Long> {
}
