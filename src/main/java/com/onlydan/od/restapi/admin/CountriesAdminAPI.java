package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.CountriesDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping(value = "/api/admin/countries")
public interface CountriesAdminAPI {

    //POST REQUESTS
    @PostMapping
    ResponseEntity<CountriesDTO> createCountry(@RequestBody CountriesDTO countriesDTO);

    //PUT REQUESTS
    @PutMapping("/{country-id}")
    ResponseEntity<CountriesDTO> updateCountryByCountryId(@PathVariable("country-id") String countryId,
                                                   @RequestBody CountriesDTO countriesDTO);

    //GET REQUESTS
    @GetMapping
    ResponseEntity<CountriesDTO> getCountryByCountryId(@RequestParam("country-id") String countryId);

    //DELETE REQUESTS
    @DeleteMapping("/{country-id}")
    ResponseEntity<Void> deleteCountryByCountryId(@PathVariable("country-id") String countryId);
}
