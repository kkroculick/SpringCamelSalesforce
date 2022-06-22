package com.example.springcamelsalesforce;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

//
// can be a services class

@Component
public class SpringCamelSalesforceProcessor implements Processor {

    public SpringCamelSalesforceProcessor(){
        //do some setup or constructor
    }

    @Override
    public void process(Exchange exchange) throws Exception {
        //Service Activator EIP
        //use bean from().bean(bean,method)
        //HelloBean hello = context.getRegistry().lookup("helloBean", HelloBean.class);
        /*
        var in = exchange.getIn().getBody();
        exchange.getIn().setBody(in);
        */

        //do some processing
        //invoke bean
    }
}
