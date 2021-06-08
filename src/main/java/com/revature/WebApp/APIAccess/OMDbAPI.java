package com.revature.WebApp.APIAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.DTO.OMDbSearchResultsDTO;
import com.revature.WebApp.utils.AppProperties;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * https://rapidapi.com/rapidapi/api/movie-database-imdb-alternative
 */
public class OMDbAPI {
    private static OMDbAPI apiAccess;

    private String URL;
    private String apiKey;
    private String host;

    public static OMDbAPI getAPIAccess() {
        if(apiAccess == null) {
            apiAccess = new OMDbAPI();
        }
        return apiAccess;
    }

    private OMDbAPI() {
        URL = "https://movie-database-imdb-alternative.p.rapidapi.com/";
        apiKey = AppProperties.getAppProperties().getRapidAPIKey();
        host = "movie-database-imdb-alternative.p.rapidapi.com";
    }


    public OMDbSearchResultsDTO searchByTitle(String title) throws IOException {

        String searchString = URL + "?s=" + title + "&page=1&r=json";
        //System.out.println("URL = " + URL);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(searchString)
                .get()
                .addHeader("x-rapidapi-key", apiKey)
                .addHeader("x-rapidapi-host", host)
                .build();

        Response response = client.newCall(request).execute();
        String jsonResults = response.body().string();
        jsonResults = jsonResults.replace("imdbID", "ImdbID");
        jsonResults = jsonResults.replace("totalResults", "TotalResults");
        ObjectMapper mapper = new ObjectMapper();
        OMDbSearchResultsDTO searchResults = mapper.readValue(jsonResults, OMDbSearchResultsDTO.class);


        return searchResults;
    }
}
