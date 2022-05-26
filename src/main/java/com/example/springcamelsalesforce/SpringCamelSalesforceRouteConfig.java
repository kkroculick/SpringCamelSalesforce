package com.example.springcamelsalesforce;

import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spring.SpringRouteBuilder;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ComponentScan;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.component.salesforce.SalesforceComponent;
import org.apache.camel.spring.SpringCamelContext;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.apache.camel.spring.javaconfig.SingleRouteCamelConfiguration;
import org.apache.camel.spring.javaconfig.Main;
import org.springframework.stereotype.Component;

//@component allows spring to add multiple route builder
@Configuration
//@Component
@ComponentScan("com.example.springcamelsalesforce")
public class SpringCamelSalesforceRouteConfig {

    @Autowired
    @Qualifier("salesforceCamelComponent")
    //SpringCamelSalesforceComponentConfig;
    SalesforceComponent salesforceCamelComponent;

    //@Autowired
    //private CamelContext camelContext;

    @Bean
    public CamelContextConfiguration contextConfiguration() {
        return new CamelContextConfiguration() {

            @Override
            public void beforeApplicationStart(CamelContext context) {
                // your custom configuration goes here
                context.addComponent("salesforce", salesforceCamelComponent);
            }

            @Override
            public void afterApplicationStart(CamelContext camelContext) {

            }
        };
    }

    @Bean
    public RouteBuilder routeBuilder() {

        return new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                //CamelContext context = new DefaultCamelContext();
                //from("direct:getBasicInfo").to("salesforce:getBasicInfo").bean(SpringCamelSalesforceRouteConfig.BasicInfoBean.class);
                from("salesforce:{{salesforce.topic}}")
                        .unmarshal().json()
                        .choice()
                        .when(header("CamelSalesforceEventType").isEqualTo("created"))
                        .log("New Salesforce contact was created: [ID:${body[Id]}, Name:${body[Name]}, Email:${body[Email]}, Phone: ${body[Phone]}]")
                        .when(header("CamelSalesforceEventType").isEqualTo("updated"))
                        .log("A Salesforce contact was updated: [ID:${body[Id]}, Name:${body[Name]}, Email:${body[Email]}, Phone: ${body[Phone]}]")
                        .when(header("CamelSalesforceEventType").isEqualTo("undeleted"))
                        .log("A Salesforce contact was undeleted: [ID:${body[Id]}, Name:${body[Name]}, Email:${body[Email]}, Phone: ${body[Phone]}]")
                        .when(header("CamelSalesforceEventType").isEqualTo("deleted"))
                        .log("A Salesforce contact was deleted: [ID:${body[Id]}]");
            }
        };

    }

    public static class BasicInfoBean {
        public void someMethod(String body) {
            System.out.println(">>>>>>> Salesforce Basics Info: " + body);
        }
    }

}
