package com.kodilla.patterns.strategy.social;

public final class Millennials extends User {
    public Millennials(String name) {
        super(name);
        this.socialPublisher = new FacebookPublisher();
    }
}
