package ru.nsu;

/**
 * implements headings with markdown syntax.
 */
public class Heading extends Text {
    private int level;

    /**
     * constructs new {@link Heading} object.
     */
    public Heading(String heading, int level) {
        super(heading);
        this.level = level;
    }

    /**
     * afaik there is no way to treat
     * multiline headings accordingly, as
     * most markdown renderers do not offer
     * such functionality.
     * returns {@link String} with markdown syntax for heading.
     */
    @Override
    public String toString() {
        return "#".repeat(level)
                + " "
                + text;
    }

    /**
     * checks if object is equal to instance of {@link Heading}.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Heading otherHeading = (Heading) obj;
        return text.equals(otherHeading.text) && level == otherHeading.level;
    }
}
