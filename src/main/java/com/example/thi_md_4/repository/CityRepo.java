package com.example.thi_md_4.repository;

import com.example.thi_md_4.model.City;
import com.example.thi_md_4.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepo extends JpaRepository<City, Long> {
    Iterable<City> findByCountry(Country country);
}
