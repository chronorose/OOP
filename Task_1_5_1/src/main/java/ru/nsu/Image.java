package ru.nsu;

public class Image {
  private String altText;
  private String link;

  private Image() {
  }

  private Image(Builder builder) {
    altText = builder.image.altText;
    link = builder.image.link;
  }

  @Override
  public String toString() {
    return "![" + altText + "]" + "(" + link + ")";
  }

  /**
   * checks if object is equal to instance of {@link Image}
   */
  @Override
  public boolean equals(Object obj) {
    if (obj == null || obj.getClass() != this.getClass()) {
      return false;
    }

    Image otherImage = (Image) obj;
    return link.equals(otherImage.link) && altText.equals(otherImage.altText);
  }

  public static class Builder {
    Image image;

    public Builder() {
      image = new Image();
    }

    public Builder withAltText(String altText) {
      image.altText = altText;
      return this;
    }

    public Builder withLink(String link) {
      this.image.link = link;
      return this;
    }

    public Image build() {
      return new Image(this);
    }
  }
}
