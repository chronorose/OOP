package ru.nsu;

import java.util.ArrayList;
import java.util.stream.Stream;

class GradeBook {
  ArrayList<Semester> semesters;

  GradeBook() {
    semesters = new ArrayList<>();
  }

  GradeBook(Semester[] semesterArray) {
    for (Semester semester : semesterArray) {
      semesters.add(semester);
    }
  }

  public Boolean checkIfTransferToBudgetAvailable() {
    Stream<Subject> lastTwoSemesters = subjectsStream(
        semesters.subList(semesters.size() - 2, semesters.size()).stream());
    return lastTwoSemesters.filter((x) -> x.type == ControlType.Exam).map((x) -> x.grade >= 4).reduce(true,
        (x, y) -> x && y);
  }

  public int averageGrade() {
    Stream<Subject> subjects = subjectsStream(semesters.stream());
    int count = (int) subjects.count();
    int gradeSum = subjects.map((x) -> x.grade).reduce(0, (x, y) -> x + y);
    return gradeSum / count;
  }

  public Boolean honorsDiploma() {
    Stream<Subject> subjects = subjectsStream(semesters.stream());

    Stream<Integer> finalGrades = subjects.filter((x) -> x.finalGrade).map((x) -> x.grade);

    int gradesCount = (int) finalGrades.count();
    int gradesSum = finalGrades.reduce(0, (x, y) -> x + y);
    Boolean firstCondition = ((gradesSum / gradesCount) * 100) >= 75;

    Boolean secondCondition = finalGrades.map((x) -> x >= 4).reduce(true, (x, y) -> x && y);

    Boolean thirdCondition = subjects.filter((x) -> x.type == ControlType.QualificationWork).map(x -> x.grade == 5)
        .reduce(true, (x, y) -> x && y);

    return firstCondition && secondCondition && thirdCondition;
  }

  private static Stream<Subject> subjectsStream(Stream<Semester> semesters) {
    return semesters.flatMap((x) -> x.subjects.stream());
  }
}
