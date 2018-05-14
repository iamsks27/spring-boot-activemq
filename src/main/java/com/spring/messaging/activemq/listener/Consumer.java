package com.spring.messaging.activemq.listener;

import com.spring.messaging.activemq.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class Consumer {

    @JmsListener(destination = "inmemory.queue")
    public void listenerOnQueue(final User user) throws InterruptedException {
        Thread.sleep(20000); //checking the async nature of the queue.
        log.info("Obtained User: " + user);
    }

    @JmsListener(destination = "publishing user")
    public void listener(final User user) throws InterruptedException {
        Thread.sleep(20000); //checking the async nature of the queue.
        log.info("Received Message: " + user);
    }
}
