package com.example.testtask.repository;

import com.example.testtask.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
// Репозиторий для стран
public interface CountryRepository extends JpaRepository<Country, Long> {

    @Query("from Country c")
    List<Country> findByAll();

    @Query("from Country c where c.id= :id order by c.id")
    List<Country> findByCountryId(@Param("id") int id);

    @Query("SELECT c.id,c.countryName FROM Country c order by c.id")
    List<Object[]> getAllCountries();

    @Query("SELECT s.id,s.cityName FROM City s WHERE s.country.id=:id order by s.id")
    List<Object[]> getCityByCountry(Integer id);

}


