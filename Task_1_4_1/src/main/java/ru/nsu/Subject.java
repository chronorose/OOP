package ru.nsu;

class Subject {
  String name;
  ControlType type;
  Boolean finalGrade;
  int grade;

  Subject(String n, ControlType ct, Boolean isFinal, int subjectGrade) {
    name = n;
    type = ct;
    finalGrade = isFinal;
    grade = subjectGrade;
  }
}
