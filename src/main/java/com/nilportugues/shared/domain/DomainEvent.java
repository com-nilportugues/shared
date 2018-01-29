package com.nilportugues.shared.domain;

import java.io.Serializable;

public interface DomainEvent extends Serializable {

    String getEventId();

    String getEventType();

    String getEventVersion();

    String getCreatedAt();

    Payload getPayload();

    MetaData getMeta();

    public interface Payload {
        String getId();

        String getType();

        Attributes getAttributes();
    }

    public interface Attributes extends Serializable {

    }

    public interface MetaData extends Serializable {
        String getHostName();

        String getHostIpAddress();

        String getApplicationName();

        String getApplicationVersion();
    }
}
