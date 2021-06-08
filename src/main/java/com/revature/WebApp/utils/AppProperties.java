package com.revature.WebApp.utils;

import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.util.Optional;
import java.util.Properties;

public class AppProperties {
    private static String appPropsFilePath;
    private static AppProperties appProperties;

    //data source
    private DataSource dataSource;

    //Server Configs
    private String serverPort;
    private String h2consoleEnabled;

    //API Configs
    private String rapidAPIKey;

    public static AppProperties getAppProperties() {
        if(appProperties == null) {
            appPropsFilePath = "src/main/resources/application.properties";
            appProperties = new AppProperties(appPropsFilePath);
        }
        return appProperties;
    }

    public static AppProperties getAppProperties(String filePath) {
        if(appProperties == null) {
            appPropsFilePath = filePath;
            appProperties = new AppProperties(appPropsFilePath);
        }
        return appProperties;
    }

    private AppProperties(String filePath) {
        String dataSourceURL = System.getenv("SPRING_DATASOURCE_URL");
        String dataSourceUsername = System.getenv("SPRING_DATASOURCE_USERNAME");
        String dataSourcePassword = System.getenv("SPRING_DATASOURCE_PASSWORD");
        String dataSourceDriver = System.getenv("SPRING_DATASOURCE_DRIVER");

        serverPort = System.getenv("SPRING_SERVER_PORT");
        rapidAPIKey = System.getenv("RAPIDAPI_KEY");
        h2consoleEnabled = System.getenv("SPRING_H2_CONSOLE_ENABLED");

        File checkFile = new File(appPropsFilePath);
        if(checkFile.exists()) {
            try (FileReader propFile = new FileReader(appPropsFilePath)) {
                Properties appProperties = new Properties();
                appProperties.load(propFile);

                dataSourceURL = appProperties.getProperty("spring.datasource.url");
                dataSourceUsername = appProperties.getProperty("spring.datasource.username");
                dataSourcePassword = appProperties.getProperty("spring.datasource.password");
                dataSourceDriver = appProperties.getProperty("spring.datasource.driver");

                serverPort = appProperties.getProperty("server.port");
                rapidAPIKey = appProperties.getProperty("rapidapi.key");
                h2consoleEnabled = appProperties.getProperty("spring.h2.console.enabled");

            } catch (Exception e) {
                //TODO - change this
                e.printStackTrace();
            }
        }




        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url(dataSourceURL);
        dataSourceBuilder.username(dataSourceUsername);
        dataSourceBuilder.password(dataSourcePassword);
        dataSourceBuilder.driverClassName(dataSourceDriver);
        dataSource = dataSourceBuilder.build();
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public String getServerPort() {
        return serverPort;
    }

    public String getRapidAPIKey() {
        return rapidAPIKey;
    }

    public String getH2consoleEnabled() {
        return h2consoleEnabled;
    }
}
