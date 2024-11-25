package ru.nsu;

class Main {
  public static void main(String[] args) {
    Subject[] subjects = new Subject[] { new Subject("Matan", ControlType.Exam, false, 4),
        new Subject("Matan2", ControlType.Exam, false, 4), new Subject("Matan3", ControlType.Exam, false, 5),
        new Subject("Matan4", ControlType.Exam, true, 5) };
    Semester s = new Semester(subjects);
    System.out.println(s.sumOfGrades());
    System.out.println(s.amountOfExcellents());
  }
}
