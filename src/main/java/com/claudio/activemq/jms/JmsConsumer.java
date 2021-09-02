package com.claudio.activemq.jms;

import com.claudio.activemq.model.MessageDemo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.ObjectMessage;

@Component
@Slf4j
public class JmsConsumer implements MessageListener {

    @Override
    @JmsListener(destination = "${active-mq.broker-name}")
    public void onMessage(Message message) {
        try{
            ObjectMessage objectMessage = (ObjectMessage)message;
            MessageDemo messageDemo = (MessageDemo)objectMessage.getObject();
            //do additional processing
            log.info("Received MessageDemo from Queue: "+ messageDemo);
        } catch(Exception e) {
            log.error("Received Exception while processing message: "+ e);
        }
    }
}
