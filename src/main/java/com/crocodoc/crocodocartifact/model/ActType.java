package com.crocodoc.crocodocartifact.model;

public enum ActType {
    OBSERVATION(1),
    EXAM(2),
    PRESCRIPTION(3),
    CONSTANT_REPORT(4),
    CR(5),
    ORDONNANCE(6),
    RADIO(7);

    private final long id;

    ActType(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
