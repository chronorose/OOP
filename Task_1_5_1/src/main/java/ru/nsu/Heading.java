package ru.nsu;

import java.util.stream.IntStream;

/**
 * implements headings with markdown syntax.
 */
public class Heading extends Element {
  private String heading;
  private int level;

  /**
   * constructs new {@link Heading} object.
   */
  public Heading(String heading, int level) {
    this.heading = heading;
    this.level = level;
  }

  /**
   * returns {@link String} with markdown syntax for heading.
   */
  @Override
  public String toString() {
    return IntStream
        .range(0, level)
        .mapToObj(i -> "#")
        .reduce("", (acc, i) -> acc + i)
        + " "
        + heading;
  }

  /**
   * checks if object is equal to instance of {@link Heading}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }

    Heading otherHeading = (Heading) obj;
    return heading.equals(otherHeading.heading) && level == otherHeading.level;
  }
}
