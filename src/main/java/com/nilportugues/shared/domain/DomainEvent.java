package com.nilportugues.shared.domain;


import java.io.Serializable;

interface DomainEvent extends Serializable {

    String getEventId();
    String getEventType();
    String getEventVersion();
    String getCreatedAt();
    Payload getPayload();
    MetaData getMeta();

    interface Payload
    {
        String getId();
        String getType();
        Attributes getAttributes();
    }

    interface Attributes extends Serializable
    {

    }

    interface MetaData extends Serializable
    {
        String getHostName();
        String getHostIpAddress();
        String getApplicationName();
        String getApplicationVersion();
    }
}
