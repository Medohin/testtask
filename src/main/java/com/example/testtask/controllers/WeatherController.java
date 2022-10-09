package com.example.testtask.controllers;

import com.example.testtask.controllers.dto.PersonDto;
import com.example.testtask.models.City;
import com.example.testtask.models.Country;
import com.example.testtask.models.Persons;
import com.example.testtask.models.Weather;
import com.example.testtask.repository.CityRepository;
import com.example.testtask.repository.CountryRepository;
import com.example.testtask.repository.PersonRepository;
import com.example.testtask.repository.WeatherRepository;
import com.example.testtask.service.CountryService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.validation.Valid;
import java.util.List;

@Controller
public class WeatherController {

    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping("/weather")
    public  String weather( Model model){
        List<Object[]> weather = weatherRepository.findAllWeather();
    //    List<Weather> temp = weatherRepository.findAllTemp();
    //    model.addAttribute("temp", temp);
        model.addAttribute("allweather", weather);
        return "weather";
    }


}

