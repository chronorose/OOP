package ru.nsu;

public enum Kind {
    Diamonds("Буби"),
    Hearts("Червей"),
    Clubs("Треф"),
    Spades("Пик");
    final String name;
    Kind(String name) {
        this.name = name;
    }
}
