package ru.nsu;

public enum CardValue {
    Ace(11, "Туз"),
    King(10, "Король"),
    Queen(10, "Дама"),
    Jack(10, "Валет"),
    Ten(10, "Десятка"),
    Nine(9, "Девятка"),
    Eight(8, "Восьмёрка"),
    Seven(7, "Семёрка"),
    Six(6, "Шестёрка"),
    Five(5, "Пятёрка"),
    Four(4, "Четвёрка"),
    Three(3, "Тройка"),
    Two(2, "Двойка");
    final int value;
    final String name;
    CardValue(int value, String name) {
        this.value = value;
        this.name = name;
    }
};
