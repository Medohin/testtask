package com.example.testtask.models;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "country", schema="public")
public class Country {
    @Id
    @Column(name = "id")
    private int id;
    private String countryName;


    public Country() {

    }

    public Country(int id, String countryName) {
        this.id = id;
        this.countryName = countryName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }


}
