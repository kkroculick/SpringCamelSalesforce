package com.example.springcamelsalesforce;

import org.apache.camel.component.salesforce.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SalesforceEndpointConfig.class, SalesforceLoginConfig.class})
public class SpringCamelSalesforceComponentConfig {


    // inject endpoint config
    @Autowired
    SalesforceEndpointConfig salesforceEndpointConfig;

    //inject login config
    @Autowired
    SalesforceLoginConfig salesforceLoginConfig;

    // create spring bean salesforce component
    @Bean
    public SalesforceComponent salesforceCamelComponent() {

        // create new instance of camel salesforce component
        SalesforceComponent salesforceComponent = new SalesforceComponent();
        // create config for the endpoints or APIs
        salesforceComponent.setConfig(salesforceEndpointConfig);
        // create config for login credentials
        salesforceComponent.setLoginConfig(salesforceLoginConfig);
        // allow spring to lookup components and configs in package
        salesforceComponent.setPackages("com.example.springcamelsalesforce");
        // return instance of a salesforce bean
        return salesforceComponent;
    }
}


