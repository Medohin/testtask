package com.example.testtask.controllers;

import com.example.testtask.controllers.dto.PersonDto;
import com.example.testtask.models.City;
import com.example.testtask.models.Country;
import com.example.testtask.models.Persons;
import com.example.testtask.repository.CityRepository;
import com.example.testtask.repository.CountryRepository;
import com.example.testtask.repository.PersonRepository;
import com.example.testtask.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;

//Контроллер для сотрудников
@Controller
public class PersonController {

    @Autowired
    private EntityManager em;

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private CountryService countryService;

    @GetMapping("/person")
    public  String allPersonList( Model model){
        List<Persons> personsAll = personRepository.findByAll();
        model.addAttribute("allpersons", personsAll);
        return "persons/persons";
    }

    @GetMapping("/person/add")
    public  String openPersonAddPage(Model model){
        List<Object[]> countryList = countryService.getAllCountries();
        List<Object[]>  cityList = cityRepository.findByCityId(1);
        model.addAttribute("citylist", cityList);
        model.addAttribute("countrylist", countryList);
        return "persons/person-add";

    }

    @PostMapping("/person/save")
    public String insertPerson(@ModelAttribute("persons")
                                 @RequestParam int countryid,
                                 @RequestParam int cities,
                               PersonDto regperson, Model model, BindingResult result){

        Persons persons = new Persons ();
        Country countryId =(Country) em.find(Country.class, countryid);
        City cityid =(City) em.find(City.class, cities);
        persons.setFirstName(regperson.getFirstName());
        persons.setLastName(regperson.getLastName());
        persons.setPatronymic(regperson.getPatronymic());
        persons.setEmail(regperson.getEmail());
        persons.setPhone(regperson.getPhone());
        persons.setCountryId(countryId.getId());
        persons.setCity(cityid);
        if (result.hasErrors()){
            return "persons";
        }
        personRepository.save(persons);
        model.addAttribute("persons", personRepository.findAll());
        return "redirect:/person";
    }

    @GetMapping("/person/{id}")
    public String showPerson(@PathVariable("id") long id, Model model){
        List<Persons> personid = personRepository.findByPersonId(id);
        int countryid = personRepository.findByPersonAllCity(id);
        List<Object[]> countryList = countryService.getAllCountries();
        List<Object[]>  cityList = cityRepository.findByCityId(countryid);
        model.addAttribute("citylist", cityList);
        model.addAttribute("countrylist", countryList);
        model.addAttribute("person", personid);
        return "persons/person-edit";
    }


    @PostMapping("/person/update/{id}")
    public String updatePerson(@ModelAttribute("reqUser")
                                @PathVariable("id")     int id,
                                @RequestParam int countryid,
                                @RequestParam int cities,
                                @Valid Persons persons,PersonDto regperson, BindingResult result,
                                Model model) {
        Country countryId =(Country) em.find(Country.class, countryid);
        City cityid =(City) em.find(City.class, cities);
        persons.setFirstName(regperson.getFirstName());
        persons.setLastName(regperson.getLastName());
        persons.setPatronymic(regperson.getPatronymic());
        persons.setEmail(regperson.getEmail());
        persons.setPhone(regperson.getPhone());
        persons.setCountryId(countryId.getId());
        persons.setCity(cityid);
        personRepository.save(persons);
        model.addAttribute("persons", personRepository.findAll());
        return "redirect:/person/" + id;
    }

    @GetMapping("/person/delete/{id}")
    public String deletePerson(@PathVariable("id") long id, Model model) {
        Persons persons = personRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid persons Id:" + id));
        personRepository.delete(persons);
        model.addAttribute("persons", personRepository.findAll());
        return "redirect:/person";
    }

    @GetMapping("/person/getCities")
    public @ResponseBody String getCities(@RequestParam Integer countryId)
    {
        String json = null;
        List<Object[]> list = countryService.getCityByCountry(countryId);
        try {
            json = new ObjectMapper().writeValueAsString(list);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }

}

