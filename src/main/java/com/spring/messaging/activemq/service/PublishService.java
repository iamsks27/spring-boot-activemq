package com.spring.messaging.activemq.service;

import com.spring.messaging.activemq.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Queue;

@Service
@Slf4j
public class PublishService {

    private final JmsTemplate jmsTemplate;
    private final Queue queue;

    public PublishService(final JmsTemplate jmsTemplate, final Queue queue) {
        this.jmsTemplate = jmsTemplate;
        this.queue = queue;
    }

    /**
     * publishing an user object to the queue.
     * @param user User
     * @return User
     */
    public User publish(final User user) {
        this.jmsTemplate.convertAndSend(this.queue, user);
        return user;
    }


    /**
     * publishing an user object with destination message.
     * @param user User
     * @return User
     */
    public User publishWithoutQueue(final User user) {
        this.jmsTemplate.convertAndSend("publishing user", user);
        return user;
    }
}
