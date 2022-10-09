package com.example.testtask.models;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;


@Data
@Entity
@Table(name = "weather", schema="public")
public class Weather {

    @Id
    @Column(name = "id")
    private int id;
    private Date createdAt;
    private int temperature;

    public Weather(int id, Date createdAt, int temperature) {
        this.id = id;
        this.createdAt = createdAt;
        this.temperature = temperature;
    }

    public Weather() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }
}
