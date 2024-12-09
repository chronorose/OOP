package ru.nsu.List;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ru.nsu.Element;

/**
 * list in markdown. extends {@link Element}.
 */
public class List extends Element {
  private ArrayList<String> lines;
  private ListType listType;

  private List() {
    lines = new ArrayList<>();
    listType = ListType.UNORDERED;
  };

  private List(Builder builder) {
    lines = new ArrayList<>(builder.list.lines);
    listType = builder.list.listType;
  }

  /**
   * returns {@link String} of this class
   * in markdown syntax.
   */
  public String toString() {
    var listStream = lines.stream();
    String ret;
    switch (listType) {
      case ORDERED:
        ret = IntStream.range(1, lines.size() + 1)
            .mapToObj(i -> i + ". " + lines.get(i - 1) + "\n")
            .collect(Collectors.toList())
            .stream()
            .reduce("", (acc, x) -> acc + x);
        break;
      default:
        ret = listStream.reduce("", (acc, line) -> acc + "- " + line + "\n");
        break;
    }
    return ret;
  }

  /**
   * tells if some {@Object} is equal to instance of {@link List}.
   */
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }
    List otherList = (List) obj;
    return lines.equals(otherList.lines) && (listType == otherList.listType);
  }

  /**
   * implements builder pattern
   * for {@link List} class.
   */
  public static class Builder {
    private List list;

    /**
     * constructs builder of {@link List}
     */
    public Builder() {
      list = new List();
    }

    /**
     * method that adds line to {@link List}
     * that this {@link Builder} builds.
     */
    public Builder addLine(String line) {
      list.lines.add(line);
      return this;
    }

    /**
     * adds line from {@link Element}
     * to {@link List} that this {@link Builder} builds.
     */
    public Builder addLine(Element element) {
      list.lines.add(element.toString());
      return this;
    }

    /**
     * changes {@link ListType} of {@link List}
     * that this {@link Builder} builds.
     */
    public Builder withListType(ListType lt) {
      list.listType = lt;
      return this;
    }

    /**
     * returns {@link List} that this
     * {@link Builder} built.
     */
    public List build() {
      return new List(this);
    }
  }
}
