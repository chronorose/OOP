package ru.nsu;

import ru.nsu.list.List;
import ru.nsu.list.ListType;
import ru.nsu.tasklist.TaskList;

class Main {
    public static void main(String[] args) {
        List rbuilder = new List.Builder()
                .addLine(new Text("hello"))
                .addLine(new Text("hi"))
                .withListType(ListType.UNORDERED)
                .build();
        List lbuilder = new List.Builder()
                .addLine(new Text("hiii"))
                .addLine(new Text("hello mistahs"))
                .addLineIdented(new Text("hi and hello to you too"), 4)
                .addLine(new Text.Bold("Hello sirrr"))
                .addLine(rbuilder)
                .withListType(ListType.ORDERED)
                .build();

        // System.out.println(Util.appendPrefix(" ", rbuilder.toString()));

        String lol = new List.Builder()
                .addLine(new Text("hihi haha"))
                .withListType(ListType.ORDERED)
                .build()
                .toStringIndented(4);

        System.out.println(lol);
        Heading heading = new Heading("hellooo", 3);
        System.out.println(new Text.Strikethrough("hiii"));
        System.out.println(lbuilder);
        System.out.println("hieiei".substring(3));

        BlockQuote bq = new BlockQuote("hello!\nvery nice to see ya!\nvery interesting of you to come here!\n");
        System.out.println(bq);
        BlockQuote bq2 = new BlockQuote("hi!");
        System.out.println(bq2);

        CodeBlock cb = new CodeBlock("print(\"hihi\");\nstd::cout << std::endl;");
        System.out.println(cb.toStringIndented(3));

        TaskList tl = new TaskList.Builder()
                .addTask("hihiHaha")
                .addDoneTask("HOHO!!!!!")
                .build();

        System.out.println(tl);
    }
}
