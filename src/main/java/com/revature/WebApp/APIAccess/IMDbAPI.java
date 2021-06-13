package com.revature.WebApp.APIAccess;

import com.revature.WebApp.utils.APICallTracker;
import com.revature.WebApp.utils.AppProperties;
import org.springframework.stereotype.Component;


/**
 * https://rapidapi.com/amrelrafie/api/movies-tvshows-data-imdb
 */
@Component
public class IMDbAPI {
    private APICallTracker apiTracker;
    private String URL;
    private String apiKey;
    
    private IMDbAPI(APICallTracker apiCallTracker){
        apiTracker = apiCallTracker;
        URL="";
        apiKey= AppProperties.getAppProperties().
    }
}
