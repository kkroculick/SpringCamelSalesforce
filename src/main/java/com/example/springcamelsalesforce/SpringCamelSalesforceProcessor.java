package com.example.springcamelsalesforce;

import com.example.springcamelsalesforce.dto.Account;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.salesforce.api.dto.composite.SObjectNode;
import org.apache.camel.component.salesforce.api.dto.composite.SObjectTree;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
        //var ex= exchange.getIn();
        //exchange.getIn().setBody(in);

        Message message = exchange.getIn();

        Account account = new Account();
        account.setName("keith account");
        account.setPhone("5555551212");
        account.setOwnerId("0058Y00000APoqfQAD");
       // ObjectMapper mapper = new ObjectMapper();

        message.setBody(account);


        //SObjectTree request = new SObjectTree();
        //request.addObject(account);

        //ProducerTemplate template = exchange.getContext().createProducerTemplate();

        /*final SObjectTree response = template.requestBody("salesforce:composite-tree", tree, SObjectTree.class);
        final Map<Boolean, List<SObjectNode>> result = response.allNodes()
                .collect(Collectors.groupingBy(SObjectNode::hasErrors));

        final List<SObjectNode> withErrors = result.get(true);
        final List<SObjectNode> succeeded = result.get(false);

        final String firstId = succeeded.get(0).getId();*/
        //exchange.getIn().setBody();


    }
}
