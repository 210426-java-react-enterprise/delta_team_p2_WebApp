package com.revature.WebApp.config;

import com.sun.xml.bind.v2.TODO;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileReader;
import java.util.Properties;


//@Configuration
public class JpaConfig {
    //private final String connPropsFilePath = "src/main/resources/application.properties";

//    //@Bean
//    public DataSource getDataSource()
//    {
//        String dataSourceURL = System.getProperty("SPRING_DATASOURCE_URL");
//        String dataSourceUsername = System.getProperty("SPRING_DATASOURCE_USERNAME");
//        String dataSourcePassword = System.getProperty("SPRING_DATASOURCE_PASSWORD");
//
//        System.out.println("System Property Values: ");
//        System.out.println(dataSourceURL);
//        System.out.println(dataSourcePassword);
//        System.out.println(dataSourceUsername);
//
//        File checkFile = new File(connPropsFilePath);
//        if(checkFile.exists()) {
//            try (FileReader propFile = new FileReader(connPropsFilePath)) {
//                Properties dataSourceProperties = new Properties();
//                dataSourceProperties.load(propFile);
//                dataSourceURL = dataSourceProperties.getProperty("spring.datasource.url");
//                dataSourceUsername = dataSourceProperties.getProperty("spring.datasource.username");
//                dataSourcePassword = dataSourceProperties.getProperty("spring.datasource.password");
//
//            } catch (Exception e) {
//                //TODO - change this
//                e.printStackTrace();
//            }
//        }
////        else {
////            dataSourceURL = System.getProperty("SPRING_DATASOURCE_URL");
////            dataSourceUsername = System.getProperty("SPRING_DATASOURCE_USERNAME");
////            dataSourcePassword = System.getProperty("SPRING_DATASOURCE_PASSWORD");
////        }
//
//        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        //dataSourceBuilder.driverClassName("org.h2.Driver");
//        dataSourceBuilder.url(dataSourceURL);
//        dataSourceBuilder.username(dataSourceUsername);
//        dataSourceBuilder.password(dataSourcePassword);
//        return dataSourceBuilder.build();
//    }

}
