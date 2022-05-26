package com.example.springcamelsalesforce;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class SpringCamelSalesforceProcessor implements Processor {

    public SpringCamelSalesforceProcessor(){

    }

    @Override
    public void process(Exchange exchange) throws Exception {
           var in = exchange.getIn().getBody();
           exchange.getIn().setBody(in);
    }
}
