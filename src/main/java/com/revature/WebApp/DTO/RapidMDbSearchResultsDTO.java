package com.revature.WebApp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonIgnoreProperties
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class RapidMDbSearchResultsDTO {
    private List<RapidMDBElementDTO> search;
    private String totalResults;
    private String response;
    private String error;


    public RapidMDbSearchResultsDTO() {

    }

    public List<RapidMDBElementDTO> getSearch() {
        return search;
    }

    public void setSearch(List<RapidMDBElementDTO> search) {
        this.search = search;
    }

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "RapidMDbSearchResultsDTO{" +
                "search=" + search.toString() +
                ", totalResults='" + totalResults + '\'' +
                ", response='" + response + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
