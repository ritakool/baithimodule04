package com.example.thi_md_4.service.city;

import com.example.thi_md_4.model.City;
import com.example.thi_md_4.model.Country;

import java.util.Optional;

public interface ICityService {
    Iterable<City> findByCountry(Country country);
    Iterable<City> findAll();
    Optional<City> findById(Long id);
    void save(City city);
    void deleteById(Long id);
}
