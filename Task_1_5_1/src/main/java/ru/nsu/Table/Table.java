package ru.nsu.Table;

import java.util.ArrayList;
import java.util.stream.IntStream;
import ru.nsu.Text;
import ru.nsu.Element;

public class Table extends Element {
    private final String tableStart = "---";
    private final String alignmentSymbol = ":";
    private ArrayList<Row> rows;
    private ArrayList<Alignment> alignment;

    private Table() {
        rows = new ArrayList<>();
    }

    @Override
    public String toString() {
        if (rows.size() == 0) {
            return "";
        }
        return rows.get(0).toString()
                + alignment
                        .stream()
                        .map(align -> {
                            String ret = tableStart;
                            switch (align) {
                                case LEFT:
                                    ret = alignmentSymbol + ret;
                                    break;
                                case RIGHT:
                                    ret = ret + alignmentSymbol;
                                    break;
                                case CENTER:
                                    ret = alignmentSymbol + ret + alignmentSymbol;
                                    break;
                            }
                            return ret + " | ";
                        })
                        .reduce("", (acc, line) -> acc + line + System.lineSeparator())
                        .toString()
                + IntStream
                        .range(1, rows.size())
                        .mapToObj(i -> rows.get(i).toString())
                        .reduce("", (acc, line) -> acc + line + System.lineSeparator());
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Table otherList = (Table) obj;
        return rows.equals(otherList.rows) && alignment.equals(otherList.alignment);
    }

    private Table(ArrayList<Row> rows, ArrayList<Alignment> alignments) {
        this.rows = new ArrayList<>(rows);
        this.alignment = new ArrayList<>(alignments);
    }

    public static class Builder {
        Table table;

        public Builder() {
            table = new Table();
        }

        public void addRow(Text... texts) {
            table.rows.add(new Row(texts));
        }

        public void withAlignment(Alignment... alignments) {
            for (Alignment al : alignments) {
                table.alignment.add(al);
            }
        }

        public Table build() {
            return new Table(this.table.rows, this.table.alignment);
        }
    }
}
