package com.example.springcamelsalesforce;

import com.example.springcamelsalesforce.dto.Account;
import com.example.springcamelsalesforce.dto.Contact;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.salesforce.api.dto.composite.SObjectNode;
import org.apache.camel.component.salesforce.api.dto.composite.SObjectTree;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

//
// can be a services class

@Component
public class SpringCamelSalesforceProcessor implements Processor {
    private final static Logger LOGGER = LoggerFactory.getLogger(SpringCamelSalesforceProcessor.class);

    @Value( "${salesforce.account.ownerid}" )
    private String accountOwnerId;

    public SpringCamelSalesforceProcessor() {
        //do some setup or constructor
    }

    @Override
    public void process(Exchange exchange) throws Exception {

        //exchange->message
        //Service Activator EIP
        //use bean from().bean(bean,method)
        //HelloBean hello = context.getRegistry().lookup("helloBean", HelloBean.class);

        /*
        var in = exchange.getIn()
        var payload = exchange.getIn().getBody();
        exchange.getIn().setBody(in);
        ProducerTemplate.sendBody
        */

        //Message message = exchange.getIn();
        //body, headers, messageid, timestamp
        //String payload = exchange.getIn().getBody(String.class);
        //System.out.println("the payload is " + payload + "\n");

        //create individual accounts...use bulk API for when creating many accounts
        List<List<String>> data = (List<List<String>>) exchange.getIn().getBody();

        for (List<String> line : data) {
            // LOGGER.debug(String.format("%s has an IQ of %s and is currently %s",
             //ContactName","ContactTitle","Address","City","Region","PostalCode","Country","Phone","Fax"
            System.out.println(line.get(0));
            Account account = new Account();
            //Contact contact = new Contact();

            account.setAccountNumber(line.get(0));
            account.setName(line.get(1));

            //contact.setName(line.get(2));
            //contact.setTitle(line.get(3));

            //account.setName(line.get()); //contact
            //account.setName(line.get()); //contact
            //account.setBillingAddress(line.get(4));
            account.setBillingCity(line.get(5));
            account.setBillingState(line.get(6));
            account.setBillingPostalCode(line.get(7));
            account.setBillingCountry(line.get(8));
            account.setPhone(line.get(9));
            account.setFax(line.get(10));
            account.setOwnerId(accountOwnerId);
            //update individual account
            exchange.getIn().setBody(account);
        }


        // ObjectMapper mapper = new ObjectMapper();
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
