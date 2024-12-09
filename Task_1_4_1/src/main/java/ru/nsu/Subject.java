package ru.nsu;

class Subject {
    String name;
    ControlType type;
    Boolean finalGrade;
    Grade grade;

    Subject(String n, ControlType ct, Boolean isFinal, Grade grade) {
        name = n;
        type = ct;
        finalGrade = isFinal;
        this.grade = grade;
    }
}
