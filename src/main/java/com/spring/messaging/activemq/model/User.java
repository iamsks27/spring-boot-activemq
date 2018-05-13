package com.spring.messaging.activemq.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Data
public class User implements Serializable {

    private String firstName;
    private String lastName;
    private Double age;
    private Character sex;

}
