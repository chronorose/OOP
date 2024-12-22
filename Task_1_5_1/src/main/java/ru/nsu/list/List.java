package ru.nsu.list;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import ru.nsu.Element;
import ru.nsu.Util;

/**
 * list in markdown. extends {@link Element}.
 */
public class List extends Element {
    private ArrayList<Element> lines;
    private ArrayList<Integer> identLevels;
    private ListType listType;

    private List() {
        lines = new ArrayList<>();
        identLevels = new ArrayList<>();
        listType = ListType.UNORDERED;
    }

    private List(ArrayList<Element> lines, ArrayList<Integer> idents, ListType lt) {
        this.lines = new ArrayList<>(lines);
        this.identLevels = new ArrayList<>(idents);
        this.listType = lt;
    }

    /**
     * @return String of this class in markdown syntax.
     */
    public String toString() {
        String ret;
        // don't really know how to avoid dublication there at first glance.
        // i see a solution with passing lambda, but it's java
        // so it's either undoable or it is very so-so.
        switch (listType) {
            case ORDERED:
                ret = IntStream.range(1, lines.size() + 1)
                        .mapToObj(i -> Util.appendPrefix(
                                " ".repeat(
                                        identLevels.get(i - 1) + String.valueOf(i).length() + 2),
                                i + ". "
                                        + lines.get(i - 1).toString())
                                .substring(String.valueOf(i).length() + 2)
                                + "\n")
                        .collect(Collectors.toList())
                        .stream()
                        .reduce("", (acc, x) -> acc + x);
                break;
            default:
                ret = IntStream.range(1, lines.size() + 1)
                        .mapToObj(i -> Util.appendPrefix(
                                " ".repeat(
                                        identLevels.get(i - 1) + 2),
                                "- " + lines.get(i - 1).toString()).substring(2)
                                + "\n")
                        .collect(Collectors.toList())
                        .stream()
                        .reduce("", (acc, x) -> acc + x);
                break;
        }
        return ret;
    }

    /**
     * tells if some {@link Object} is equal to instance of {@link List}.
     *
     * @param obj with which to check equality.
     *
     * @return boolean that tells if they're equal or not.
     */
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        List otherList = (List) obj;
        return lines.equals(otherList.lines)
                && (listType == otherList.listType)
                && identLevels.equals(otherList.identLevels);
    }

    /**
     * implements builder pattern
     * for {@link List} class.
     */
    public static class Builder {
        private List list;

        /**
         * constructs builder of {@link List}.
         */
        public Builder() {
            list = new List();
        }

        /**
         * adds line from {@link Element}
         * to {@link List} that this {@link Builder} builds.
         * 
         * @param element to add.
         *
         * @return Builder to continue building.
         */
        public Builder addLine(Element element) {
            return addLineIdented(element, 0);
        }

        /**
         * adds line with indent.
         * 
         * @param element to add with indent.
         * @param ident   which ident to add with.
         * 
         * @return Builder to continue building.
         */
        public Builder addLineIdented(Element element, int ident) {
            list.lines.add(element);
            list.identLevels.add(ident);
            return this;
        }

        /**
         * changes {@link ListType} of {@link List}
         * that this {@link Builder} builds.
         *
         * @param lt which type of the list to build.
         *
         * @return Builder to continue building.
         */
        public Builder withListType(ListType lt) {
            list.listType = lt;
            return this;
        }

        /**
         * returns {@link List} that this
         * {@link Builder} built.
         *
         * @return List that has been built.
         */
        public List build() {
            return new List(this.list.lines, this.list.identLevels, this.list.listType);
        }
    }
}
