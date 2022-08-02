package com.example.springcamelsalesforce;

import com.example.springcamelsalesforce.dto.Account;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.Message;
import org.apache.camel.TypeConverter;
import org.springframework.stereotype.Component;

@Component
public class SpringCamelSalesforceBean {
    //model pojo beans

    public SpringCamelSalesforceBean(){

    }

    @Handler
    public void doSomething(Exchange exchange){

        //String body, Exchange exchange, TypeConverter converter

        Message message = exchange.getIn();
        Account account = new Account();
        account.setName("keith account");
        account.setPhone("5555551212");
        account.setOwnerId("0058Y00000APoqfQAD");

        //ObjectMapper mapper = new ObjectMapper();
        message.setBody(account);

    }
}
