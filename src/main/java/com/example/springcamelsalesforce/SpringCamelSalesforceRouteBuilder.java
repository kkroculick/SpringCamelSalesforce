package com.example.springcamelsalesforce;

import org.apache.camel.Endpoint;
import org.apache.camel.spring.boot.CamelContextConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;

import org.apache.camel.component.salesforce.SalesforceComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Component;

//@component allows spring to add multiple route builder

//@Configuration
//@Component
//@ComponentScan("com.example.springcamelsalesforce")

@Component
public class SpringCamelSalesforceRouteBuilder {

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

                // TODO Remove let Spring handle it
                // your custom configuration goes here
                // context.addComponent("salesforce", salesforceCamelComponent);
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
                //TODO Error Handler

                // Create custom Camel Context
                /* CamelContext context = new DefaultCamelContext();
                context.setDevConsole(true);
                from("direct:getBasicInfo").to("salesforce:getBasicInfo").bean(SpringCamelSalesforceRouteConfig.BasicInfoBean.class); */

                /*salesforce:operationName:topicName
               consume - receive events: salesforce:topic?options
               produce - send events: salesforce:operationName?options*/

                // Camel Create Salesforce push camelTestTopic from application.properties
                /*from("salesforce:{{salesforce.topic}}")
                        .unmarshal().json()
                        .choice()
                        .when(header("CamelSalesforceEventType").isEqualTo("created"))
                        .log("New Salesforce contact was created: [ID:${body[Id]}, Name:${body[Name]}, Email:${body[Email]}, Phone: ${body[Phone]}]")
                        .when(header("CamelSalesforceEventType").isEqualTo("updated"))
                        .log("A Salesforce contact was updated: [ID:${body[Id]}, Name:${body[Name]}, Email:${body[Email]}, Phone: ${body[Phone]}]")
                        .when(header("CamelSalesforceEventType").isEqualTo("undeleted"))
                        .log("A Salesforce contact was undeleted: [ID:${body[Id]}, Name:${body[Name]}, Email:${body[Email]}, Phone: ${body[Phone]}]")
                        .when(header("CamelSalesforceEventType").isEqualTo("deleted"))
                        .log("A Salesforce contact was deleted: [ID:${body[Id]}]");*/


                // Camel Create hardcoded Account SObject
                // from("timer:tick").process(new SpringCamelSalesforceProcessor()).to("log:com.example.springcamelsalesforce?level=DEBUG").to("salesforce:createSObject?sObjectName=Account");
                // from("timer:tick").bean(SpringCamelSalesforceBean.class).to("log:com.example.springcamelsalesforce?level=DEBUG").to("salesforce:createSObject?sObjectName=Account");

            }
        };

    }

    public static class BasicInfoBean {
        public void someMethod(String body) {
            System.out.println(">>>>>>> Salesforce Basics Info: " + body);
        }
    }

}
