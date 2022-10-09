package com.example.testtask.repository;


import com.example.testtask.models.City;
import com.example.testtask.models.Persons;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Репозиторий для городов
public interface CityRepository extends JpaRepository<City, Long> {

    @Query("SELECT c.id, c.cityName from City c order by c.id")
    List<Object[]> findAllCity();

    @Query("SELECT c.id, c.cityName from City c where c.country.id= :countryid")
    List<Object[]>  findByCityId(@Param("countryid") int countryid);


}


