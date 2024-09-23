package ru.nsu.game;

import ru.nsu.cards.Card;
import ru.nsu.players.Dealer;
import ru.nsu.players.Player;

/**
 * Class that consists of main game loop and a bunch of helper methods.
 */
public class Game {
    GameState state;
    GameIO io;
    GameScore score;

    public Game() {
        state = new GameState();
        score = new GameScore();
        io = new GameIO(score);
    }

    public void run() {
        while (true) {
            runRound();
            score.incrementRound();
        }
    }

    private void runRound() {
        state = new GameState();
        io.setState(state);
        state.result = handleStart();
        if (state.result != Result.NotDecided) {
            addCounts();
            io.resultPrinter();
            return;
        }
        io.turnName();
        state.result = handlePlayer();
        if (state.result != Result.NotDecided) {
            addCounts();
            io.resultPrinter();
            return;
        }
        io.turnName();
        state.result = handleDealer();
        if (state.result != Result.NotDecided) {
            addCounts();
            io.resultPrinter();
        }
    }

    Result handleStart() {
        io.startTurn();
        Result result = checkState();
        if (result == Result.DealerWon) {
            state.turn = Turn.DealerTurn;
            handleDealer();
        }
        return result;
    }

    private void addCounts() {
        Result result = checkState();
        switch (result) {
            case DealerWon:
                score.incrementDealerScore();
                break;
            case PlayerWon:
                score.incrementPlayerScore();
                break;
            default:
                break;
        }
    }

    private Result handleDealer() {
        state.turn = Turn.DealerTurn;
        Card card = state.dealer.getLast();
        io.openCard(card);
        state.dealer.openCard();
        io.handsPrinter();
        while (checkCondition(state.dealer) == HandState.NotEnough 
                && state.dealer.sum < Dealer.DEALER_MAX) {
            card = state.deck.getCard();
            state.dealer.addCard(card);
            io.openCard(card);
            io.handsPrinter();

        }
        return checkState();
    }

    private Result handlePlayer() {
        state.turn = Turn.PlayerTurn;
        while (checkCondition(state.player) == HandState.NotEnough && io.getInput()) {
            Card card = state.deck.getCard();
            state.player.addCard(card);
            io.openCard(card);
            io.handsPrinter();
        }
        return checkState();
    }

    private Result checkState() {
        HandState player = checkCondition(state.player);
        HandState dealer = checkCondition(state.dealer);
        if (player == HandState.BlackJack && dealer != HandState.BlackJack) {
            return Result.PlayerWon;
        } else if (player != HandState.BlackJack && dealer == HandState.BlackJack) {
            return Result.DealerWon;
        } else if (player == HandState.OverHead) {
            return Result.DealerWon;
        } else if (dealer == HandState.OverHead) {
            return Result.PlayerWon;
        } else if (player == HandState.BlackJack && dealer == HandState.BlackJack) {
            return Result.Draw;
        }
        return Result.NotDecided;
    }

    private HandState checkCondition(Player player) {
        if (player.sum > 21) {
            return HandState.OverHead;
        } else if (player.sum == 21) {
            return HandState.BlackJack;
        } else {
            return HandState.NotEnough;
        }
    }
}
