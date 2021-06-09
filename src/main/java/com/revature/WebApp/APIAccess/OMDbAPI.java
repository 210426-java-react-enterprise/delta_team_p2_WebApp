package com.revature.WebApp.APIAccess;
import com.revature.WebApp.utils.AppProperties;
import org.springframework.stereotype.Component;


/**
 * http://omdbapi.com/
 */
@Component
public class OMDbAPI {
    private static OMDbAPI apiAccess;

    private String URL;
    private String apiKey;


    private OMDbAPI() {
        apiKey = AppProperties.getAppProperties().getOmdbAPIKey();
        URL = "http://www.omdbapi.com/?apikey=" + apiKey + "&";
    }

    //TODO: Implement search functions on this API


}
