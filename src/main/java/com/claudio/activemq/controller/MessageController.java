package com.claudio.activemq.controller;

import com.claudio.activemq.jms.JmsProducer;
import com.claudio.activemq.model.MessageDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Autowired
    private JmsProducer jmsProducer;

    @GetMapping("/send")
    public String sendMessage(){
        String testMessage = "This is a simple messageDemo";
        MessageDemo messageDemo = MessageDemo.builder()
                .body(testMessage)
                .build();
        jmsProducer.sendMessage(messageDemo);
        return testMessage;
    }
}
