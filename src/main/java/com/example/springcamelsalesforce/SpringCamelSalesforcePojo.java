package com.example.springcamelsalesforce;

import org.apache.camel.Exchange;
import org.apache.camel.TypeConverter;
import org.springframework.stereotype.Component;

@Component
public class SpringCamelSalesforcePojo {
    //model pojo beans

    public SpringCamelSalesforcePojo(){

    }
    public String doSomething(String body, Exchange exchange, TypeConverter converter){
        return "";
    }
}
