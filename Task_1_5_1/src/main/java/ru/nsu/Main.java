package ru.nsu;

import ru.nsu.list.List;
import ru.nsu.list.ListType;
import ru.nsu.tasklist.TaskList;
import ru.nsu.table.*;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) {
        Table t = new Table.Builder()
                .addRow(new Text("text1"), new Text("text2"))
                .addRow(new Text("text3"), new Text("text4"))
                .withAlignment(Alignment.LEFT, Alignment.RIGHT)
                .build();

        ArrayList<ArrayList<Text>> kek = new ArrayList<>();
        kek.add(new ArrayList<>());
        kek.get(0).add(new Text("keko"));
        kek.get(0).add(new Text("kiki"));
        kek.add(new ArrayList<>());
        ArrayList<ArrayList<Text>> kek2 = new ArrayList<>();
        kek2.add(new ArrayList<>());
        kek2.get(0).add(new Text("keko"));
        kek2.get(0).add(new Text("kiki"));
        kek2.add(new ArrayList<>());
        System.out.print(kek.equals(kek2));
    }
}
