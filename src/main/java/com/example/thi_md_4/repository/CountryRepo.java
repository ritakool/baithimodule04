package com.example.thi_md_4.repository;

import com.example.thi_md_4.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepo extends JpaRepository<Country, Long> {
}
