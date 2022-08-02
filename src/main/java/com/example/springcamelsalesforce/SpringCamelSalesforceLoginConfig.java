package com.example.springcamelsalesforce;

import org.apache.camel.CamelContext;
import org.apache.camel.component.salesforce.SalesforceComponent;
import org.apache.camel.component.salesforce.SalesforceEndpointConfig;
import org.apache.camel.component.salesforce.SalesforceLoginConfig;
import org.apache.camel.impl.DefaultCamelContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// create a salesforce login config
@Configuration
public class SpringCamelSalesforceLoginConfig {

    /* salesforce supports three different ways of login
    https://help.salesforce.com/s/articleView?id=sf.connected_app_manage.htm&type=5
    https://help.salesforce.com/s/articleView?id=sf.remoteaccess_terminology.htm&type=5*/

    @Value("${camel.component.salesforce.login-config.client-id}")
    private String clientId;

    @Value("${camel.component.salesforce.login-config.client-secret}")
    private String clientSecret;

    public SalesforceLoginConfig salesforceLoginConfig() {
        SalesforceLoginConfig salesforceLoginConfig = new SalesforceLoginConfig();

        /*
        salesforceLoginConfig.setUserName(username);
        salesforceLoginConfig.setPassword(password + token);
        salesforceLoginConfig.setLoginUrl(url);
        salesforceLoginConfig.setLazyLogin(false);
        */

        // set client id from value in salesforce connected apps
        salesforceLoginConfig.setClientId(clientId);
        // set client secret from value in salesforce connected apps
        salesforceLoginConfig.setClientSecret(clientSecret);
        // return salesforce login bean
        return salesforceLoginConfig;
    }
}
