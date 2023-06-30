package com.example.thi_md_4.service.country.impl;

import com.example.thi_md_4.model.Country;
import com.example.thi_md_4.repository.CountryRepo;
import com.example.thi_md_4.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryService implements ICountryService {
    @Autowired
    private CountryRepo countryRepo;
    @Override
    public Iterable<Country> findAll() {
        return countryRepo.findAll();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return countryRepo.findById(id);
    }

    @Override
    public void save(Country country) {
        countryRepo.save(country);
    }

    @Override
    public void deleteById(Long id) {
        countryRepo.deleteById(id);
    }
}
