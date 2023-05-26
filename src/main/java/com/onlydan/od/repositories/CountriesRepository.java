package com.onlydan.od.repositories;

import com.onlydan.od.entities.Countries;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountriesRepository extends JpaRepository<Countries, String> {

}
