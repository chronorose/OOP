package ru.nsu;

import java.util.ArrayList;
import java.util.stream.Stream;

/**
 * Class for the grade book.
 * Can calculate the average grade, your ability to gain honors diploma
 * and your ability to transfer to budget in case you are paying for education.
 */
public class GradeBook {
    ArrayList<Semester> semesters;

    /**
     * Constructor for gradebook in case you have no semesters passed.
     */
    GradeBook() {
        semesters = new ArrayList<>();
    }

    /**
     * Constructor in case you have semesters passed.
     * 
     * @param semesterArray - array of semesters you passed.
     */
    GradeBook(ArrayList<Semester> semesterArray) {
        semesters = new ArrayList<>();
        for (Semester semester : semesterArray) {
            semesters.add(semester);
        }
    }

    /**
     * Add semesters you passed to the grade book.
     * 
     * @param semester - semester you've passed.
     */
    public void addSemester(Semester semester) {
        semesters.add(semester);
    }

    /**
     * Method to check if you can transfer to budget.
     * 
     * @return returns boolean value if you can or cannot transfer.
     */
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
                .map((x) -> x.grade.grade >= 4)
                .reduce(true, (x, y) -> x && y);
    }

    /**
     * Method to calculate your average grade in your grade book.
     * 
     * @return average of your grades.
     */
    public float averageGrade() {
        Stream<Subject> subjects = subjectsStream(semesters.stream());
        float count = (float) subjectsStream(semesters.stream()).count();
        float gradeSum = subjects
                .map((x) -> x.grade.grade)
                .reduce(0, (x, y) -> x + y);
        if (count > 0) {
            return gradeSum / count;
        }
        return 0F;
    }

    /**
     * Method to calculate if you're able to get your honors diploma.
     *
     * @return boolean if you can or cannot get your honors diploma.
     */
    public Boolean honorsDiploma() {
        Stream<Integer> finalGrades = subjectsStream(semesters.stream())
                .filter((x) -> x.finalGrade)
                .map((x) -> x.grade.grade);

        float gradesCount = finalGrades.count();

        finalGrades = subjectsStream(semesters.stream())
                .filter((x) -> x.finalGrade)
                .map((x) -> x.grade.grade);

        float excellentCount = finalGrades
                .filter((x) -> x == 5)
                .count();
        Boolean firstCondition = true;
        if (gradesCount > 0) {
            firstCondition = ((excellentCount / gradesCount) * 100) >= 75;
        }

        finalGrades = subjectsStream(semesters.stream())
                .filter((x) -> x.finalGrade)
                .map((x) -> x.grade.grade);

        Boolean secondCondition = finalGrades
                .allMatch(x -> x >= 4);
        Boolean thirdCondition = subjectsStream(semesters.stream())
                .filter((x) -> x.type == ControlType.QualificationWork)
                .allMatch(x -> x.grade.grade == 5);

        return firstCondition && secondCondition && thirdCondition;
    }

    private static Stream<Subject> subjectsStream(Stream<Semester> semesters) {
        return semesters
                .flatMap((x) -> x.subjects.stream());
    }
}
