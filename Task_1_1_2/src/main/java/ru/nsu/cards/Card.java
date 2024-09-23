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
    public void setNormalized() {
        normalized = true;
    }

    public CardValue getCardV() {
        return this.value;
    }

    Kind getKind() {
        return this.kind;
    }

    public boolean getHidden() {
        return this.hidden;
    }

    public void setHidden(boolean hidden) {
        this.hidden = hidden;
    }

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

