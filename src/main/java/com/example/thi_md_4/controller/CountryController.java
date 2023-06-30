package com.example.thi_md_4.controller;

import com.example.thi_md_4.model.City;
import com.example.thi_md_4.model.Country;
import com.example.thi_md_4.service.city.ICityService;
import com.example.thi_md_4.service.country.ICountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class CountryController {

    @Autowired
    private ICityService iCityService;

    @Autowired
    private ICountryService iCountryService;

    @GetMapping("/country")
    public ModelAndView listProvinces() {
        Iterable<Country> countries = iCountryService.findAll();
        ModelAndView modelAndView = new ModelAndView("/country/list");
        modelAndView.addObject("country", countries);
        return modelAndView;
    }

    @GetMapping("/create-country")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("/country/create");
        modelAndView.addObject("country", new Country());
        return modelAndView;
    }

    @PostMapping("/create-country")
    public ModelAndView saveProvince(@ModelAttribute("province") Country country) {
        iCountryService.save(country);

        ModelAndView modelAndView = new ModelAndView("/country/create");
        modelAndView.addObject("country", new Country());
        modelAndView.addObject("message", "New country created successfully");
        return modelAndView;
    }

    @GetMapping("/edit-province/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Country> country = iCountryService.findById(id);
        if (country.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/country/edit");
            modelAndView.addObject("country", country.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-province")
    public ModelAndView updateProvince(@ModelAttribute("province") Country country) {
        iCountryService.save(country);
        ModelAndView modelAndView = new ModelAndView("/country/edit");
        modelAndView.addObject("country", country);
        modelAndView.addObject("message", "Country updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-country/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<Country> country = iCountryService.findById(id);
        if (country.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("/country/delete");
            modelAndView.addObject("country", country.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-country")
    public String deleteProvince(@ModelAttribute("province") Country country) {
        iCountryService.deleteById(country.getId());
        return "redirect:country";
    }

    @GetMapping("/view-country/{id}")
    public ModelAndView viewProvince(@PathVariable("id") Long id){
        Optional<Country> countryOptional = iCountryService.findById(id);
        if(!countryOptional.isPresent()){
            return new ModelAndView("/error.404");
        }

        Iterable<City> cities = iCityService.findByCountry(countryOptional.get());

        ModelAndView modelAndView = new ModelAndView("/country/view");
        modelAndView.addObject("country", countryOptional.get());
        modelAndView.addObject("city", cities);
        return modelAndView;
    }
}
