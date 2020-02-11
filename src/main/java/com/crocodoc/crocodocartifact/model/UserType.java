package com.crocodoc.crocodocartifact.model;

public enum UserType {
    SECRETARY(1),
    NURSE(2),
    DOCTOR(3),
    LAB_STAFF(4),
    ADMIN(5);

    private final long id;

    UserType(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
