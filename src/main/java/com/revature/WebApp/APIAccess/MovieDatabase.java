package com.revature.WebApp.APIAccess;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.WebApp.DTO.MDbSearchResultsDTO;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * https://rapidapi.com/rapidapi/api/movie-database-imdb-alternative
 */
public class MovieDatabase {

    public void searchByTitle(String title) throws IOException {

        String URL = "https://movie-database-imdb-alternative.p.rapidapi.com/?s=" + title + "&page=1&r=json";
        System.out.println("URL = " + URL);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(URL)
                .get()
                .addHeader("x-rapidapi-key", "d5c1cba0ccmshc857fda3a3f5cf0p1083ddjsn1ab79e547703")
                .addHeader("x-rapidapi-host", "movie-database-imdb-alternative.p.rapidapi.com")
                .build();

        Response response = client.newCall(request).execute();
        String jsonResults = response.body().string();
        jsonResults = jsonResults.replace("imdbID", "ImdbID");
        jsonResults = jsonResults.replace("totalResults", "TotalResults");
        ObjectMapper mapper = new ObjectMapper();
        MDbSearchResultsDTO results = mapper.readValue(jsonResults, MDbSearchResultsDTO.class);



        System.out.println(results.toString());


    }
}
