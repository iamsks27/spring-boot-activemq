package com.spring.messaging.activemq.web;

import com.spring.messaging.activemq.model.User;
import com.spring.messaging.activemq.service.PublishService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class PublishController {

    private final PublishService service;

    public PublishController(final PublishService service) {
        this.service = service;
    }

    @PostMapping("/publish/queue")
    public User publish(@RequestBody final User user) {
        return service.publish(user);
    }

    @PostMapping("/publish")
    public User publishWithoutQueue(@RequestBody final User user) {
        return service.publishWithoutQueue(user);
    }

}
