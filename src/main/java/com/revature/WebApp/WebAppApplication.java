
package com.revature.WebApp;

import com.revature.WebApp.utils.AppProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class WebAppApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WebAppApplication.class);
        Map<String, Object> settingsMap = new HashMap<>();
        settingsMap.put("server.port", AppProperties.getAppProperties().getServerPort());
        settingsMap.put("spring.h2.console.enabled", AppProperties.getAppProperties().getH2consoleEnabled());
        app.setDefaultProperties(settingsMap);
        app.run(args);
    }

}