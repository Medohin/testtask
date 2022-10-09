package com.example.testtask.service;

import com.example.testtask.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

//Сервис для привязки стран и городов
@Service
public class CountryService {
	
	@Autowired
	private CountryRepository repo;
	
	public List<Object[]> getAllCountries(){
		return repo.getAllCountries();
	}
	
	public List<Object[]> getCityByCountry(Integer id){return repo.getCityByCountry(id);
	}
}
