package com.kodilla.patterns.factory.tasks;

public final class TaskFactory {

    public static final String SHOPPING = "SHOPPING";
    public static final String PAINTING = "PAINTING";
    public static final String DRIVING = "DRIVING";

    public com.kodilla.patterns.factory.tasks.Task makeTask(final String taskType) {
        return switch (taskType) {
            case SHOPPING -> new ShoppingTask("Grocery shopping", "Milk", 2.0);
            case PAINTING -> new PaintingTask("Wall painting", "Blue", "Living room");
            case DRIVING -> new DrivingTask("Business trip", "Berlin", "Car");
            default -> null;
        };
    }
}
