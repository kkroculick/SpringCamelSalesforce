package com.example.springcamelsalesforce;

import org.apache.camel.main.Main;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication

public class SpringCamelSalesforceApplication {

	public static void main(String[] args) {

        // create spring application camel context
        SpringApplication.run(SpringCamelSalesforceApplication.class, args);

        // traditional camel route builder
        /* Main main = new Main();
        main.configure().addRoutesBuilder(new MyRouteBuilder());
        main.run(args); */
    }


}
