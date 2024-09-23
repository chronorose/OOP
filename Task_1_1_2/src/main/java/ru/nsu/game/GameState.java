package ru.nsu.game;

import ru.nsu.cards.Deck;
import ru.nsu.players.Dealer;
import ru.nsu.players.Player;

/**
 * Class that stores state of the game.
 */
class GameState {
    Deck deck;
    Player player;
    Dealer dealer;
    Turn turn;
    Result result;

    GameState() {
        deck = new Deck();
        player = new Player(deck);
        dealer = new Dealer(deck);
        turn = Turn.PlayerTurn;
        result = Result.NotDecided;
    }
}
