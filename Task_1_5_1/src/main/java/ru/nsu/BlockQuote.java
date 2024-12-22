package ru.nsu;

/**
 * implements quotes with markdown syntax.
 */
public class BlockQuote extends Text {
    private final char quoteSymbol = '>';

    /**
     * constructs new {@link Heading} object.
     */
    public BlockQuote(String quote) {
        super(quote);
    }

    /**
     * returns {@link String} with markdown syntax for quote.
     */
    @Override
    public String toString() {
        return Util.appendPostfix(" ".repeat(2), quoteSymbol + " " + text);
    }

    /**
     * checks if object is equal to instance of {@link BlockQuote}.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        BlockQuote otherQuote = (BlockQuote) obj;
        return text.equals(otherQuote.text);
    }
}
