package com.revature.WebApp.entities;

import javax.persistence.*;
import java.time.LocalDate;


@Entity
@Table(name="api_calls")
public class APICallsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(name = "date", columnDefinition = "DATE")
    private LocalDate date;

    @Column(name = "api")
    private String api;

    @Column(name = "request")
    private String request;

    public APICallsEntity() {
        date = LocalDate.now();
    }

    public APICallsEntity(String api, String request) {
        this();
        this.api = api;
        this.request = request;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getApi() {
        return api;
    }

    public void setApi(String api) {
        this.api = api;
    }

    public String getRequest() {
        return request;
    }

    public void setRequest(String request) {
        this.request = request;
    }
}
