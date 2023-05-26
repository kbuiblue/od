package com.onlydan.od.restapi.admin;

import com.onlydan.od.dto.CountriesDTO;
import com.onlydan.od.services.CountriesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CountriesAdminResource implements CountriesAdminAPI {

    private final CountriesService countriesService;

    // POST
    @Override
    public ResponseEntity<CountriesDTO> createCountry(CountriesDTO countriesDTO) {
        log.info("Country: " + countriesDTO.getCountryName() + " added");
        CountriesDTO countriesDto = countriesService.createCountry(countriesDTO);
        return ResponseEntity.created(URI.create("/api/countries" + countriesDto.getCountryId())).body(countriesDto);
    }

    // PUT
    @Override
    public ResponseEntity<CountriesDTO> updateCountryByCountryId(String countryId, CountriesDTO countriesDTO) {
        log.info("Country id #{} updated", countryId);
        CountriesDTO countriesDto = countriesService.updateCountryById(countryId, countriesDTO);
        return ResponseEntity.ok(countriesDto);
    }

    // GET
    @Override
    public ResponseEntity<CountriesDTO> getCountryByCountryId(String countryId) {
        return ResponseEntity.ok(countriesService.getCountryByCountryId(countryId));
    }

    // DELETE
    @Override
    public ResponseEntity<Void> deleteCountryByCountryId(String countryId) {
        log.info("Country id #{} deleted", countryId);
        countriesService.deleteCountryByCountryId(countryId);
        return ResponseEntity.noContent().build();
    }
}
