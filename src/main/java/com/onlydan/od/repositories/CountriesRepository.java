package com.onlydan.od.repositories;

import com.onlydan.od.entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CountriesRepository extends JpaRepository<Countries, String> {
    Optional<Countries> getCountryByCountryId(String countryId);
}
