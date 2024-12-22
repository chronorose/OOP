package ru.nsu;

public abstract class Element {

  @Override
  abstract public String toString();

  @Override
  abstract public boolean equals(Object obj);

  public String toStringIndented(int ident) {
    return Util.appendPrefix(" ".repeat(ident), this.toString());
  }
}
