package ru.nsu;

public class Link extends Text {
    protected String link;

    protected Link() {
    }

    protected Link(String text, String link) {
        super(text);
        this.link = link;
    }

    @Override
    public String toString() {
        return "[" + text + "]" + "(" + link + ")";
    }

    /**
     * checks if object is equal to instance of {@link Link}.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        Link otherLink = (Link) obj;
        return link.equals(otherLink.link) && text.equals(otherLink.text);
    }

    /**
     * builder pattern class for {@link Link}.
     */
    public static class Builder {
        Link link;

        /**
         * default constructor.
         */
        public Builder() {
            link = new Link();
        }

        /**
         * adds alternative text for the
         * {@link Link} object that is currently being built.
         */
        public Builder withAltText(String altText) {
            link.text = altText;
            return this;
        }

        /**
         * adds link for the {@link Link} object that is currently being built.
         */
        public Builder withLink(String link) {
            this.link.link = link;
            return this;
        }

        /**
         * builds {@link Link} object from the current settings.
         */
        public Link build() {
            return new Link(this.link.text, this.link.link);
        }
    }
}
