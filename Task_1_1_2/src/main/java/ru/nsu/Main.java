package ru.nsu;

import ru.nsu.game.*;

/**
 * class for practice to launch java :D.
 */
class Main {
    /**
     * main method which sorts array and prints it.
     *
     * @param args arguments from cli.
     */
    public static void main(String[] args) {
        //for (Kind kind : Kind.values()) {
        //    System.out.println(kind.name);
        //}
        //for (int i = 0; i < deck.cards.length; i++) {
        //    System.out.println(deck.cards[i].toString());
        //}
        Game game = new Game();
        game.run();
    }
}
