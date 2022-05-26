package com.example.springcamelsalesforce;

import org.apache.camel.component.salesforce.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({SalesforceEndpointConfig.class, SalesforceLoginConfig.class})
public class SpringCamelSalesforceComponentConfig {

    @Autowired
    SalesforceEndpointConfig salesforceEndpointConfig;

    @Autowired
    SalesforceLoginConfig salesforceLoginConfig;

    @Bean
    public SalesforceComponent salesforceCamelComponent() {
        SalesforceComponent salesforceComponent = new SalesforceComponent();
        salesforceComponent.setConfig(salesforceEndpointConfig);
        salesforceComponent.setLoginConfig(salesforceLoginConfig);
        salesforceComponent.setPackages("com.example.springcamelsalesforce");
        return salesforceComponent;
    }
}
