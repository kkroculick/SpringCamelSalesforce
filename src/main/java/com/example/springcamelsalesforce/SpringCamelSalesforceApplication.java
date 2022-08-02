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

        /* Traditional camel route builder with Spring
        Main main = new Main();
        // have SpringCamelSalesforceApplication extend CamelConfiguration
        // change annotations to @Configuraiton and @ComponentsScan
        main.setConfigClass(SpringCamelSalesforceApplicaiton)
        main.configure().addRoutesBuilder(new MyRouteBuilder());
        main.run(args); */
    }


}
