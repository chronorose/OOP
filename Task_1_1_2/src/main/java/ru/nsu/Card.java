package ru.nsu;

class Card {
    private final Kind kind;
    private final CardValue value;
    private boolean used;
    private boolean hidden;
    void setUsed(boolean used) {
        this.used = used;
    }
    boolean getUsed() {
        return this.used;
    }
    CardValue getCV() {
        return this.value;
    }
    Kind getKind() {
        return this.kind;
    }
    boolean getHidden() {
        return this.hidden;
    }
    void setHidden(boolean hidden) {
        this.hidden = hidden;
    }
    Card(Kind kind, CardValue cv) {
        this.kind = kind;
        this.value = cv;
        this.used = false;
    }
    @Override
    public String toString() {
        if (hidden) {
            return "<закрытая карта>";
        }
        return value.name + 
            " " +
            kind.name + 
            " (" +
            value.value +
            ")";
    }
}

