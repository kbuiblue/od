package com.onlydan.od.services;

import com.onlydan.od.dto.CountriesDTO;
import com.onlydan.od.entities.Countries;
import com.onlydan.od.exceptions.AllExceptions;
import com.onlydan.od.mappers.CountriesMapper;
import com.onlydan.od.repositories.CountriesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CountriesService {

    private final CountriesRepository countriesRepository;

    private final CountriesMapper countriesMapper;

    //POST REQUEST
    public CountriesDTO createCountry(CountriesDTO countriesDTO) {
        Countries countries = Countries.builder()
                .countryName(countriesDTO.getCountryName())
                .build();

        Countries savedCountries = countriesRepository.save(countries);

        return countriesMapper.INSTANCE.toDTO(savedCountries);
    }

    //PUT REQUEST
    public CountriesDTO updateCountryById(String countryId, CountriesDTO countriesDTO) {
        Countries countries = countriesRepository.getCountryByCountryId(countryId)
                .orElseThrow(AllExceptions::CountryNotFound);

        countries.setCountryName(countriesDTO.getCountryName());

        return countriesMapper.INSTANCE.toDTO(countriesRepository.save(countries));
    }

    // GET REQUEST
    public CountriesDTO getCountryByCountryId(String countryId) {
        Countries countries = countriesRepository.getCountryByCountryId(countryId)
                .orElseThrow(AllExceptions::CountryNotFound);

        return countriesMapper.INSTANCE.toDTO(countries);
    }

    // DELETE REQUEST
    public void deleteCountryByCountryId(String countryId) {
        countriesRepository.deleteById(countryId);
    }
}
