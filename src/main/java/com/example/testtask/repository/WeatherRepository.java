package com.example.testtask.repository;


import com.example.testtask.models.City;
import com.example.testtask.models.Weather;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<Weather, Long> {

    @Query("SELECT w.id, w.createdAt, w.temperature from Weather w order by w.createdAt desc")
    List<Object[]> findAllWeather();

  //  @Query("SELECT w.temperature from Weather w order by w.createdAt desc")
 //   List<Weather> findAllTemp();


}


