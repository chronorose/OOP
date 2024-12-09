package ru.nsu;

import ru.nsu.List.List;
import ru.nsu.List.ListType;

class Main {
  public static void main(String[] args) {
    List lbuilder = new List.Builder()
        .addLine("hiii")
        .addLine("hello mistahs")
        .addLine("hi and hello to you too")
        .addLine(new Text.Bold("Hello sirrr"))
        .withListType(ListType.ORDERED)
        .build();

    Heading heading = new Heading("hellooo", 3);
    System.out.println(new Text.Strikethrough("hiii"));
    System.out.println(lbuilder);
    System.out.println(heading);
  }
}
