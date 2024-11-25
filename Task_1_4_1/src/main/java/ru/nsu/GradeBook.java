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
        if (semesters.size() < 2) {
            return false;
        }
        Stream<Subject> lastSemesters = subjectsStream(
                semesters
                        .subList(
                                semesters.size() - 2, semesters.size())
                        .stream());
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
        Stream<Integer> finalGrades = subjectsStream(semesters.stream())
                .filter((x) -> x.finalGrade)
                .map((x) -> x.grade);

        float gradesCount = finalGrades.count();

        finalGrades = subjectsStream(semesters.stream())
                .filter((x) -> x.finalGrade)
                .map((x) -> x.grade);

        float excellentCount = finalGrades
                .filter((x) -> x == 5)
                .count();

        Boolean firstCondition = ((excellentCount / gradesCount) * 100) >= 75;

        finalGrades = subjectsStream(semesters.stream())
                .filter((x) -> x.finalGrade)
                .map((x) -> x.grade);

        Boolean secondCondition = finalGrades
                .map((x) -> x >= 4)
                .reduce(true, (x, y) -> x && y);

        Boolean thirdCondition = subjectsStream(semesters.stream())
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
