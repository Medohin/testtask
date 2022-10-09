package com.example.testtask.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@Entity
@Table(name = "city", schema="public")
public class City {
    @Id
    @Column(name = "id")
    private int id;
    private String cityName;
    @ManyToOne
    @JoinColumn(name="country_id", updatable = false)
    private Country country;

    public City() {
    }

    public City(int id, String cityName, Country country) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
