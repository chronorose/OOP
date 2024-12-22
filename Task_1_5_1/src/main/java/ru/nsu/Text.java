package ru.nsu;

import java.io.BufferedReader;
import java.io.StringReader;

/**
 * represents text in markdown. extends {@link Element}.
 */
public class Text extends Element {
    protected String text;

    /**
     * constructs new {@link Text} instance.
     */
    public Text(String text) {
        this.text = text;
    }

    protected Text() {
    }

    /**
     * returns {@link String} that is correct markdown syntax for {@link Text}.
     */
    @Override
    public String toString() {
        return text;
    }

    // @Override
    // public String toStringIndented(int ident) {
    // StringBuilder sb = new StringBuilder();
    // new BufferedReader(new StringReader(text))
    // .lines()
    // .forEach(line -> sb.append(" ".repeat(ident)).append(line).append('\n'));
    // sb.deleteCharAt(sb.length() - 1);
    // return sb.toString();
    // }

    /**
     * returns if instance of {@link Text} is equal to another object.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        return text.equals(((Text) obj).text);
    }

    /**
     * represents bold text in markdown.
     * extends {@link Text}.
     */
    public static class Bold extends Text {
        final private String boldSymbols = "**";

        /**
         * constructs new {@link Text.Bold} instance.
         */
        public Bold(String text) {
            super(text);
        }

        /**
         * returns {@link String} that is correct markdown syntax for {@link Text.Bold}.
         */
        @Override
        public String toString() {
            return boldSymbols + super.toString() + boldSymbols;
        }

        /**
         * returns if instance of {@link Text.Bold} is equal to another object.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            return text == ((Text.Bold) obj).text;
        }
    }

    /**
     * represents italic text in markdown.
     * extends {@link Text}.
     */
    public static class Italic extends Text {
        final private String italicSymbols = "*";

        /**
         * constructs new {@link Text.Italic} instance.
         */
        public Italic(String text) {
            super(text);
        }

        /**
         * returns {@link String} that is correct markdown syntax for
         * {@link Text.Italic}.
         */
        @Override
        public String toString() {
            return italicSymbols + super.toString() + italicSymbols;
        }

        /**
         * returns if instance of {@link Text.Italic} is equal to another object.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            return text == ((Text.Italic) obj).text;
        }
    }

    /**
     * represents one line of code in markdown.
     * extends {@link Text}.
     */
    public static class Code extends Text {
        final private String codeSymbols = "`";

        /**
         * constructs new {@link Text.Code} instance.
         */
        public Code(String text) {
            super(text);
        }

        /**
         * returns {@link String} that is correct markdown syntax for
         * {@link Text.Code}.
         */
        @Override
        public String toString() {
            return codeSymbols + super.toString() + codeSymbols;
        }

        /**
         * returns if instance of {@link Text.Code} is equal to another object.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            return text == ((Text.Code) obj).text;
        }
    }

    /**
     * represents strikethrough text in markdown.
     * extends {@link Text}.
     */
    public static class Strikethrough extends Text {
        final private String strikethroughSymbols = "~~";

        /**
         * constructs new {@link Text.Strikethrough} instance.
         */
        public Strikethrough(String text) {
            super(text);
        }

        /**
         * returns {@link String} that is correct markdown syntax for
         * {@link Text.Strikethrough}.
         */
        @Override
        public String toString() {
            return strikethroughSymbols + super.toString() + strikethroughSymbols;
        }

        /**
         * returns if instance of {@link Text.Strikethrough} is equal to another object.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            return text == ((Text.Strikethrough) obj).text;
        }
    }

    /**
     * represents highlighted text in markdown.
     * extends {@link Text}.
     */
    public static class Highlight extends Text {
        final private String highlightSymbols = "==";

        /**
         * constructs new {@link Highlight} instance.
         */
        public Highlight(String text) {
            super(text);
        }

        /**
         * returns {@link String} that is correct markdown syntax for
         * {@link Text.Highlight}.
         */
        @Override
        public String toString() {
            return highlightSymbols + super.toString() + highlightSymbols;
        }

        /**
         * returns if instance of {@link Text.Highlight} is equal to another object.
         */
        @Override
        public boolean equals(Object obj) {
            if (obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            return text == ((Text.Highlight) obj).text;
        }
    }
}
