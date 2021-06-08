package com.revature.WebApp.DTO;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.UpperCamelCaseStrategy.class)
public class MDbSearchResultsDTO {
    private List<MDbElementDTO> search;
    private String totalResults;
    private String response;


    public MDbSearchResultsDTO() {

    }

    public List<MDbElementDTO> getSearch() {
        return search;
    }

    public void setSearch(List<MDbElementDTO> search) {
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

    @Override
    public String toString() {
        return "MDbSearchResultsDTO{" +
                "search=" + search.toString() +
                ", totalResults='" + totalResults + '\'' +
                ", response='" + response + '\'' +
                '}';
    }
}
