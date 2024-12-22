package ru.nsu;

/**
 * class of code block element of markdown.
 */
public class CodeBlock extends Text {
    private static final String cbSymbols = "```";

    public CodeBlock(String code) {
        super(code);
    }

    @Override
    public String toString() {

        return cbSymbols
                + System.lineSeparator()
                + text
                + System.lineSeparator()
                + cbSymbols;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        CodeBlock otherCodeBlock = (CodeBlock) obj;
        return text.equals(otherCodeBlock.text);
    }
}
