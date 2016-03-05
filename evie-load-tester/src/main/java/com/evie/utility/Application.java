package com.evie.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application  {

    private static Logger log = LoggerFactory.getLogger(Application.class);


    public static void main(String[] args) {
      //  SpringApplication.run(Application.class, args);
    //}
    
   // public void run(String... args) throws Exception {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        
        System.out.println("Let's inspect the beans provided by Spring Boot:");
        
        String[] beanNames = ctx.getBeanDefinitionNames();
        Arrays.sort(beanNames);
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }

//        Loan l1 = new Loan();
//        l1.setName("app1");
//        l1.setDescription("app2");
//
//        loanRepository.save(l1);




    }

}
