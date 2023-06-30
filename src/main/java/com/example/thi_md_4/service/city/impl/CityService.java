package com.example.thi_md_4.service.city.impl;

import com.example.thi_md_4.model.City;
import com.example.thi_md_4.model.Country;
import com.example.thi_md_4.repository.CityRepo;
import com.example.thi_md_4.service.city.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CityService implements ICityService {
    @Autowired
    private CityRepo cityRepo;

    @Override
    public Iterable<City> findByCountry(Country country) {
        return cityRepo.findByCountry(country);
    }

    @Override
    public Iterable<City> findAll() {
        return cityRepo.findAll();
    }

    @Override
    public Optional<City> findById(Long id) {
        return cityRepo.findById(id);
    }

    @Override
    public void save(City city) {
        cityRepo.save(city);
    }

    @Override
    public void deleteById(Long id) {
        cityRepo.deleteById(id);
    }
}
