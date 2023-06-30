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
public class CityController {
    @Autowired
    private ICityService iCityService;
    @Autowired
    private ICountryService iCountryService;
    @ModelAttribute("country")
    public Iterable<Country> provinces(){
        return iCountryService.findAll();
    }

    @GetMapping("/create-city")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("views/city/create");
        modelAndView.addObject("city", new City());
        return modelAndView;
    }

    @PostMapping("/create-city")
    public ModelAndView saveCustomer(@ModelAttribute("customer") City city) {
        iCityService.save(city);
        ModelAndView modelAndView = new ModelAndView("views/city/create");
        modelAndView.addObject("city", new City());
        modelAndView.addObject("message", "New city created successfully");
        return modelAndView;
    }

    @GetMapping("/city")
    public ModelAndView listCustomers() {
        Iterable<City> cities = iCityService.findAll();
        ModelAndView modelAndView = new ModelAndView("views/city/list");
        modelAndView.addObject("city", cities);
        return modelAndView;
    }

    @GetMapping("/edit-city/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<City> city = iCityService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/city/edit");
            modelAndView.addObject("city", city.get());
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("views/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/edit-city")
    public ModelAndView updateCustomer(@ModelAttribute("city") City city) {
        iCityService.save(city);
        ModelAndView modelAndView = new ModelAndView("views/city/edit");
        modelAndView.addObject("city", city);
        modelAndView.addObject("message", "city updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete-city/{id}")
    public ModelAndView showDeleteForm(@PathVariable Long id) {
        Optional<City> city = iCityService.findById(id);
        if (city.isPresent()) {
            ModelAndView modelAndView = new ModelAndView("views/city/delete");
            modelAndView.addObject("city", city.get());
            return modelAndView;

        } else {
            ModelAndView modelAndView = new ModelAndView("views/error.404");
            return modelAndView;
        }
    }

    @PostMapping("/delete-city")
    public String deleteCustomer(@ModelAttribute("city") City city) {
        iCityService.deleteById(city.getId());
        return "redirect:city";
    }
}
