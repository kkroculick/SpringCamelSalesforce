package com.example.springcamelsalesforce;

import org.apache.camel.Endpoint;
import org.apache.camel.component.salesforce.SalesforceComponent;
import org.apache.camel.component.salesforce.SalesforceEndpoint;
import org.apache.camel.component.salesforce.SalesforceEndpointConfig;
import org.apache.camel.component.salesforce.internal.OperationName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCamelSalesforceEndpointConfig {
    @Bean
    public SalesforceEndpointConfig salesforceEndpointConfig() {
        SalesforceEndpointConfig salesforceEndpointConfig = new SalesforceEndpointConfig();
        salesforceEndpointConfig.setApiVersion("35.0");
        return salesforceEndpointConfig;
    }
}
