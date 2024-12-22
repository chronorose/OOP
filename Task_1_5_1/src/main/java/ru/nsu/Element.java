package ru.nsu;

/**
 * abstract class that represents markdown element.
 */
public abstract class Element {

    @Override
    public abstract String toString();

    @Override
    public abstract boolean equals(Object obj);

    public String toStringIndented(int ident) {
        return Util.appendPrefix(" ".repeat(ident), this.toString());
    }
}
