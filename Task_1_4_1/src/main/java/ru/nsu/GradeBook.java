package ru.nsu;

import java.util.ArrayList;
import java.util.stream.Stream;

class GradeBook {
    ArrayList<Semester> semesters;

    GradeBook() {
        semesters = new ArrayList<>();
    }

    GradeBook(ArrayList<Semester> semesterArray) {
        semesters = new ArrayList<>();
        for (Semester semester : semesterArray) {
            semesters.add(semester);
        }
    }

    public void addSemester(Semester semester) {
        semesters.add(semester);
    }

    public Boolean checkIfTransferToBudgetAvailable() {
        Stream<Subject> lastSemesters;
        if (semesters.size() >= 2) {
            lastSemesters = subjectsStream(
                    semesters.subList(semesters.size() - 2, semesters.size()).stream());
        } else if (semesters.size() == 1) {
            lastSemesters = subjectsStream(semesters.subList(semesters.size() - 1, semesters.size()).stream());
        } else {
            return true;
        }
        return lastSemesters
                .filter((x) -> x.type == ControlType.Exam)
                .map((x) -> x.grade >= 4)
                .reduce(true, (x, y) -> x && y);
    }

    public float averageGrade() {
        Stream<Subject> subjects = subjectsStream(semesters.stream());
        float count = (float) subjectsStream(semesters.stream()).count();
        float gradeSum = subjects
                .map((x) -> x.grade)
                .reduce(0, (x, y) -> x + y);
        System.out.println(gradeSum);
        System.out.println(count);
        return gradeSum / count;
    }

    public Boolean honorsDiploma() {
        Stream<Subject> subjects = subjectsStream(semesters.stream());

        Stream<Integer> finalGrades = subjects
                .filter((x) -> x.finalGrade)
                .map((x) -> x.grade);

        int gradesCount = (int) finalGrades.count();
        int gradesSum = finalGrades
                .reduce(0, (x, y) -> x + y);

        Boolean firstCondition = ((gradesSum / gradesCount) * 100) >= 75;

        Boolean secondCondition = finalGrades
                .map((x) -> x >= 4)
                .reduce(true, (x, y) -> x && y);

        Boolean thirdCondition = subjects
                .filter((x) -> x.type == ControlType.QualificationWork)
                .map(x -> x.grade == 5)
                .reduce(true, (x, y) -> x && y);

        return firstCondition && secondCondition && thirdCondition;
    }

    private static Stream<Subject> subjectsStream(Stream<Semester> semesters) {
        return semesters
                .flatMap((x) -> x.subjects.stream());
    }
}
