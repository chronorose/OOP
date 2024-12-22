package ru.nsu.table;

import java.util.ArrayList;
import ru.nsu.Text;

class Row {
    ArrayList<Text> row;

    Row(Text... texts) {
        row = new ArrayList<>();
        for (Text text : texts) {
            row.add(text);
        }
    }

    @Override
    public String toString() {
        return "| " + row.stream().map(el -> el.toString() + " | ") + System.lineSeparator();
    }
}
