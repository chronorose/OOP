package ru.nsu;

enum Grade {
    Fine(3),
    Good(4),
    Excellent(5);

    public final int grade;

    Grade(int grade) {
        this.grade = grade;
    }
}
