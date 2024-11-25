package ru.nsu;

import java.util.ArrayList;

class Semester {
    ArrayList<Subject> subjects;

    Semester() {
        subjects = new ArrayList<>();
    }

    Semester(Subject[] start_subjects) {
        subjects = new ArrayList<>();
        for (Subject subject : start_subjects) {
            addSubjectToSemester(subject);
        }
    }

    void addSubjectToSemester(Subject s) {
        subjects.add(s);
    }
}
