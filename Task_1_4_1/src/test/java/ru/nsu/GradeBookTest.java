package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class GradeBookTest {
    private Subject createExam(Boolean isFinal, Grade grade) {
        return new Subject("matan", ControlType.Exam, isFinal, grade);
    }

    private Subject createDiff(Boolean isFinal, Grade grade) {
        return new Subject("diffuri", ControlType.DiffCredit, isFinal, grade);
    }

    @Test
    void testAverageGrade() {
        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, Grade.Good));
            subjects1.add(createExam(true, Grade.Excellent));
        }
        Semester s = new Semester(subjects1);
        GradeBook book = new GradeBook();
        book.addSemester(s);
        assertEquals(4.5, book.averageGrade());
    }

    @Test
    void testAverageGrade3() {
        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        Semester s1 = new Semester(subjects1);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s1);
        GradeBook book = new GradeBook(s);
        assertEquals(0, book.averageGrade());
    }

    @Test
    void testAverageGrade2() {
        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, Grade.Good));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, Grade.Excellent));
        }
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertEquals(4.5, book.averageGrade());
    }

    @Test
    void testBudgetStuffIfThereWereNoSemesters() {
        GradeBook gbook = new GradeBook();
        assertFalse(gbook.checkIfTransferToBudgetAvailable());
    }

    @Test
    void testBudgetStuff() {
        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, Grade.Good));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, Grade.Excellent));
        }
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertTrue(book.checkIfTransferToBudgetAvailable());
    }

    @Test
    void testBudgetStuff2() {
        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, Grade.Good));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, Grade.Excellent));
            subjects2.add(createDiff(true, Grade.Fine));
        }
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertTrue(book.checkIfTransferToBudgetAvailable());
    }

    @Test
    void testBudgetStuff3() {
        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, Grade.Good));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, Grade.Excellent));
            subjects2.add(createExam(true, Grade.Fine));
        }
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertFalse(book.checkIfTransferToBudgetAvailable());
    }

    @Test
    void testBudgetStuff4() {
        ArrayList<Subject> subjects0 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects0.add(createExam(true, Grade.Fine));
        }

        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, Grade.Good));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, Grade.Excellent));
        }
        Semester s0 = new Semester(subjects0);
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s0);
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertTrue(book.checkIfTransferToBudgetAvailable());
    }

    @Test
    void testBudgetStuff5() {
        ArrayList<Subject> subjects0 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects0.add(createExam(true, Grade.Fine));
        }

        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, Grade.Good));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, Grade.Excellent));
        }
        Semester s0 = new Semester(subjects0);
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s0);
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertTrue(book.checkIfTransferToBudgetAvailable());
    }

    @Test
    void testHonorsDiploma0() {
        ArrayList<Subject> subjects0 = new ArrayList<Subject>();
        Semester s0 = new Semester(subjects0);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s0);
        GradeBook book = new GradeBook(s);
        assertTrue(book.honorsDiploma());
    }

    @Test
    void testHonorsDiploma() {
        ArrayList<Subject> subjects0 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects0.add(createExam(true, Grade.Fine));
        }

        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, Grade.Good));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, Grade.Excellent));
        }
        Semester s0 = new Semester(subjects0);
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s0);
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertFalse(book.honorsDiploma());

    }

    @Test
    void testHonorsDiploma2() {
        ArrayList<Subject> subjects0 = new ArrayList<Subject>();
        for (int i = 0; i < 20; i++) {
            subjects0.add(createExam(true, Grade.Excellent));
        }

        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, Grade.Good));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, Grade.Excellent));
        }
        Semester s0 = new Semester(subjects0);
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s0);
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertTrue(book.honorsDiploma());
    }

    @Test
    void testHonorsDiploma3() {
        ArrayList<Subject> subjects0 = new ArrayList<Subject>();
        for (int i = 0; i < 20; i++) {
            subjects0.add(createExam(true, Grade.Excellent));
        }

        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 1; i++) {
            subjects1.add(createExam(true, Grade.Fine));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, Grade.Excellent));
        }
        Semester s0 = new Semester(subjects0);
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s0);
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertFalse(book.honorsDiploma());
    }

    @Test
    void testHonorsDiploma4() {
        ArrayList<Subject> subjects0 = new ArrayList<Subject>();
        for (int i = 0; i < 20; i++) {
            subjects0.add(createExam(true, Grade.Excellent));
        }

        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, Grade.Good));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, Grade.Excellent));
        }
        subjects2
                .add(new Subject(
                        "qualification work",
                        ControlType.QualificationWork, true, Grade.Excellent));
        Semester s0 = new Semester(subjects0);
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s0);
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertTrue(book.honorsDiploma());
    }

    @Test
    void testHonorsDiploma5() {
        ArrayList<Subject> subjects0 = new ArrayList<Subject>();
        for (int i = 0; i < 20; i++) {
            subjects0.add(createExam(true, Grade.Excellent));
        }

        ArrayList<Subject> subjects1 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects1.add(createExam(true, Grade.Good));
        }
        ArrayList<Subject> subjects2 = new ArrayList<Subject>();
        for (int i = 0; i < 10; i++) {
            subjects2.add(createExam(true, Grade.Excellent));
        }
        subjects2
                .add(new Subject(
                        "qualification work",
                        ControlType.QualificationWork, true, Grade.Good));
        Semester s0 = new Semester(subjects0);
        Semester s1 = new Semester(subjects1);
        Semester s2 = new Semester(subjects2);
        ArrayList<Semester> s = new ArrayList<Semester>();
        s.add(s0);
        s.add(s1);
        s.add(s2);
        GradeBook book = new GradeBook(s);
        assertFalse(book.honorsDiploma());

    }
}
