package com.claudio.activemq.jms;

import com.claudio.activemq.model.MessageDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class JmsProducer {

    @Autowired
    JmsTemplate jmsTemplate;

    @Value("${active-mq.broker-name}")
    private String brokerName;

    public void sendMessage(MessageDemo messageDemo){
        try{
            log.info("Attempting Send messageDemo to Queue: "+ brokerName);
            jmsTemplate.convertAndSend(brokerName, messageDemo);
        } catch(Exception e){
            log.error("Received Exception during send MessageDemo: ", e);
        }
    }
}
