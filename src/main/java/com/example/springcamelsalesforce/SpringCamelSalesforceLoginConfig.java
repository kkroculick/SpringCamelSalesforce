package com.example.springcamelsalesforce;

import org.apache.camel.CamelContext;
import org.apache.camel.component.salesforce.SalesforceComponent;
import org.apache.camel.component.salesforce.SalesforceEndpointConfig;
import org.apache.camel.component.salesforce.SalesforceLoginConfig;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCamelSalesforceLoginConfig {

    //@Value("${}")
    // private String username;

    //@Value("${}")
    //private String password;

    //@Value("${SF_TOKEN}")
    //private String token;

    //@Value("${SF_BASE_URL}")
    //private String url;

    //@Value("${SF_VERSION}")
    //private String version;

    @Value("${camel.component.salesforce.login-config.client-id}")
    private String clientId;

    @Value("${camel.component.salesforce.login-config.client-secret}")
    private String clientSecret;

    public SalesforceLoginConfig salesforceLoginConfig() {
        SalesforceLoginConfig salesforceLoginConfig = new SalesforceLoginConfig();
        //salesforceLoginConfig.setUserName(username);
        //salesforceLoginConfig.setPassword(password + token);
        //salesforceLoginConfig.setLoginUrl(url);
        salesforceLoginConfig.setClientId(clientId);
        salesforceLoginConfig.setClientSecret(clientSecret);
        //salesforceLoginConfig.setLazyLogin(false);
        return salesforceLoginConfig;
    }
}
