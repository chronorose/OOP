package ru.nsu;

/**
 * implements quotes with markdown syntax.
 */
public class Quote extends Element {
  private String quote;
  private final char quoteSymbol = '>';

  /**
   * constructs new {@link Heading} object.
   */
  public Quote(String quote) {
    this.quote = quote;
  }

  /**
   * returns {@link String} with markdown syntax for quote.
   */
  @Override
  public String toString() {
    return quoteSymbol + " " + quote;
  }

  /**
   * checks if object is equal to instance of {@link Quote}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }

    Quote otherQuote = (Quote) obj;
    return quote.equals(otherQuote.quote);
  }
}
