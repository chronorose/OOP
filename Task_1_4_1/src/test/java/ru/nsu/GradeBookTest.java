package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class GradeBookTest {
    private Subject createExam(Boolean isFinal, int grade) {
        return new Subject("matan", ControlType.Exam, isFinal, grade);
    }

    private Subject createDiff(Boolean isFinal, int grade) {
        return new Subject("diffuri", ControlType.DiffCredit, isFinal, grade);
    }

    @Test
    void testAverageGrade() {
        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, 4));
            subjects1.add(createExam(true, 5));
        }
        Semester s = new Semester(subjects1);
        GradeBook book = new GradeBook();
        book.addSemester(s);
        assertEquals(4.5, book.averageGrade());
    }

    @Test
    void testAverageGrade2() {
        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, 4));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, 5));
        }
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertEquals(4.5, book.averageGrade());
    }
}
