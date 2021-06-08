package com.revature.WebApp.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonIgnoreProperties
@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class OMDbSearchResultsDTO {
    private List<OMDbElementDTO> search;
    private String totalResults;
    private String response;
    private String error;


    public OMDbSearchResultsDTO() {

    }

    public List<OMDbElementDTO> getSearch() {
        return search;
    }

    public void setSearch(List<OMDbElementDTO> search) {
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
        return "OMDbSearchResultsDTO{" +
                "search=" + search.toString() +
                ", totalResults='" + totalResults + '\'' +
                ", response='" + response + '\'' +
                ", error='" + error + '\'' +
                '}';
    }
}
