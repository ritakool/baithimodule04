package com.example.thi_md_4.service.country;

import com.example.thi_md_4.model.Country;

import java.util.Optional;

public interface ICountryService {
    Iterable<Country> findAll();
    Optional<Country> findById(Long id);
    void save(Country country);
    void deleteById(Long id);
}
