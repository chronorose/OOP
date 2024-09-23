package ru.nsu.game;

import ru.nsu.cards.*;
import ru.nsu.players.*;

enum Turn {
    DealerTurn,
    PlayerTurn,
}

enum Result {
    NotDecided,
    PlayerWon,
    DealerWon,
    Draw,
}

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
