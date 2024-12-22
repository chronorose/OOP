package ru.nsu;

/**
 * class of image markdown element.
 */
public class Image extends Link {

    private Image(String text, String link) {
        super(text, link);
    }

    private Image() {
    }

    @Override
    public String toString() {
        return "![" + text + "]" + "(" + link + ")";
    }

    /**
     * checks if object is equal to instance of {@link Image}.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Image otherImage = (Image) obj;
        return link.equals(otherImage.link) && text.equals(otherImage.text);
    }

    public static class Builder {
        Image image;

        public Builder() {
            image = new Image();
        }

        public Builder withAltText(String altText) {
            image.text = altText;
            return this;
        }

        public Builder withLink(String link) {
            this.image.link = link;
            return this;
        }

        public Image build() {
            return new Image(this.image.text, this.image.link);
        }
    }
}
