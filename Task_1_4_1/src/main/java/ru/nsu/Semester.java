package ru.nsu;

import java.util.ArrayList;

class Semester {
    ArrayList<Subject> subjects;

    Semester() {
        subjects = new ArrayList<>();
    }

    Semester(ArrayList<Subject> startSubjects) {
        subjects = new ArrayList<>();
        for (Subject subject : startSubjects) {
            addSubjectToSemester(subject);
        }
    }

    void addSubjectToSemester(Subject s) {
        subjects.add(s);
    }
}
