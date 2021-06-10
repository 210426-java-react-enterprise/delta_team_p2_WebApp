package com.revature.WebApp.APIAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.DTO.OMDbSearchResultsDTO;
import com.revature.WebApp.DTO.RapidMDbSearchResultsDTO;
import com.revature.WebApp.entities.APICallsEntity;
import com.revature.WebApp.utils.APICallTracker;
import com.revature.WebApp.utils.AppProperties;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * http://omdbapi.com/
 */
@Component
public class OMDbAPI {
    private APICallTracker apiTracker;
    private String URL;
    private String apiKey;

    @Autowired
    private OMDbAPI(APICallTracker apiCallTracker) {
        apiTracker = apiCallTracker;
        apiKey = AppProperties.getAppProperties().getOmdbAPIKey();
        URL = "http://www.omdbapi.com/?apikey=" + apiKey + "&";
    }


    public OMDbSearchResultsDTO searchByImdbId(String imdbId) throws IOException {
        String searchString = URL + "i=" + imdbId;
        OkHttpClient client = new OkHttpClient();

        System.out.println("DEBUG: " + searchString);

        APICallsEntity apiCall = new APICallsEntity("OMDb", searchString);
        if(apiTracker.trackApiCall(apiCall)) {
            Request request = new Request.Builder()
                    .url(searchString)
                    .get()
                    .build();

            Response response = client.newCall(request).execute();
            String jsonResults = response.body().string();
            jsonResults = jsonResults.replace("imdb", "Imdb");
            jsonResults = jsonResults.replace("DVD", "Dvd");
            ObjectMapper mapper = new ObjectMapper();
            OMDbSearchResultsDTO searchResults = mapper.readValue(jsonResults, OMDbSearchResultsDTO.class);
            return searchResults;
        }

        return null;
    }

}
