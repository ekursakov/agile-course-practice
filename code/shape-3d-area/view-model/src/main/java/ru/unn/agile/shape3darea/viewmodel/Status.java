package ru.unn.agile.shape3darea.viewmodel;

enum Status {
    OK("Ready"),
    INVALID_INPUT("Invalid input");

    private final String name;

    Status(final String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }
}
