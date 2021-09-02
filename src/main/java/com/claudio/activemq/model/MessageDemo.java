package com.claudio.activemq.model;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Builder
@Data
public class MessageDemo implements Serializable {

    private String body;

}
