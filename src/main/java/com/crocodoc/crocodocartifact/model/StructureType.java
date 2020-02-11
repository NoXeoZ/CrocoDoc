package com.crocodoc.crocodocartifact.model;

public enum StructureType {
    HOSPITAL(1),
    POLE(2),
    SERVICE(3),
    FUNCTIONAL_UNIT(4),
    HOSPITAL_UNIT(5);

    private final long id;

    StructureType(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
