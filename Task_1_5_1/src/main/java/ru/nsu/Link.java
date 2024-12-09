package ru.nsu;

public class Link {
  private String altText;
  private String link;

  private Link() {
  }

  private Link(Builder builder) {
    altText = builder.link.altText;
    link = builder.link.link;
  }

  @Override
  public String toString() {
    return "[" + altText + "]" + "(" + link + ")";
  }

  /**
   * checks if object is equal to instance of {@link Link}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }

    Link otherLink = (Link) obj;
    return link.equals(otherLink.link) && altText.equals(otherLink.altText);
  }

  public static class Builder {
    Link link;

    public Builder() {
      link = new Link();
    }

    public Builder withAltText(String altText) {
      link.altText = altText;
      return this;
    }

    public Builder withLink(String link) {
      this.link.link = link;
      return this;
    }

    public Link build() {
      return new Link(this);
    }
  }
}
