package com.evie;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class Application  {

    private static Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(Application.class, args);

    }

    @Bean
    public MongoClient getMongoClient() {
        return new MongoClient(new ServerAddress("localhost",27017));
    }


}
