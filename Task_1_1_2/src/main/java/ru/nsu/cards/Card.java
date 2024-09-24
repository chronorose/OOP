package ru.nsu.cards;

/**
 * {@link Card} class for storing info about card.
 */
public class Card {
    private final Kind kind;
    private final CardValue value;
    private boolean hidden;
    boolean normalized;

    public Card(Kind kind, CardValue cv) {
        this.kind = kind;
        this.value = cv;
        this.normalized = false;
    }

    /**
     * method to set normalized flag.
     */
    public void setNormalized() {
        normalized = true;
    }

    /**
     * method to get value of the card.
     * @return {@link CardValue}
     */
    public CardValue getCardV() {
        return this.value;
    }

    /**
     * method to return kind of the card.
     */
    Kind getKind() {
        return this.kind;
    }

    /**
     * method to get hidden flag.
     */
    public boolean getHidden() {
        return this.hidden;
    }

    /**
     * method to set hidden flag.
     */
    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

    /**
     * toString override.
     */
    @Override
    public String toString() {
        if (hidden) {
            return "<закрытая карта>";
        }
        String str = value.name + " " + kind.name + " (";
        if (normalized) {
            str += "1)";
        } else {
            str += value.value + ")";
        }
        return str;
    }
}

