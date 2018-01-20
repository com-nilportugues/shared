package com.nilportugues.shared.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract public class Aggregate implements Cloneable, Serializable {

    @JsonIgnore
    final protected List<Object> domainEvents = new ArrayList<>();

    abstract public String getId();

    protected void apply(Object event) {
        domainEvents.add(event);
    }

    public List<Object> pullEvents() {
        final List<Object> domainEvents = new ArrayList<>(this.domainEvents);
        this.domainEvents.clear();

        return domainEvents;
    }
}
