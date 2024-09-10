package ru.nsu;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.DelayQueue;

enum HandState {
    BlackJack,
    OverHead,
    NotEnough,
}

enum Turn {
    DealerTurn,
    PlayerTurn,
}

enum PlayerInput {
    Continue(1),
    Stop(0);
    final int val;
    PlayerInput(int val) {
        this.val = val;
    }
    int toInt() {
        return val;
    }
}

enum Result {
    NotDecided,
    PlayerWon,
    DealerWon,
    Draw,
}

class Game {
    private class GameState {
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

    private class GameIO {
        private static final String askForInput = 
            "Введите \"" + PlayerInput.Continue.val +
            "\", чтобы взять карту, и \"" + PlayerInput.Stop.val +
            "\", чтобы остановиться...\n";
        BufferedReader reader;
        GameIO() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        boolean getInput() {
            System.out.println(askForInput);
            try {
                int input = Integer.parseInt(reader.readLine());
                if (input == PlayerInput.Continue.val) {
                    return true;
                } else if (input == PlayerInput.Stop.val) {
                    return false;
                }
            } catch (Throwable exception) {}
            System.out.println("Неправильный ввод, повторите ещё раз: ");
            return getInput();
        }

        void turnName() {
            String toPrint = "";
            if (state.turn == Turn.PlayerTurn) {
                toPrint += "\nВаш ход";
            } else {
                toPrint += "Ход дилера";
            }
            toPrint += "\n------\n";
            System.out.print(toPrint);
            //return toPrint;
        }

        void openCard(Card card) {
            String toPrint = "";
            if (state.turn == Turn.PlayerTurn) {
                toPrint += "Вы открыли карту " + card.toString();
            } else {
                toPrint += "Дилер открывает ";
                if (card.getHidden()) {
                    toPrint += "закрытую ";
                }
                toPrint += "карту " + card.toString();
            }
            toPrint += "\n";
            System.out.print(toPrint);
            //return toPrint;
        }

        void handsPrinter() {
            String toPrint = "  Ваши карты: " + state.player.toString() +
                " => " + state.player.getSum() + "\n";
            toPrint += "  Карты дилера: " + state.dealer.toString(); 
            if (state.turn == Turn.DealerTurn) {
                toPrint += " => " + state.dealer.getSum(); 
            }
            System.out.print(toPrint + "\n\n");
        }

        void startTurn() {
            System.out.println("\nДилер раздал карты\n");
            handsPrinter(); 
        }

        void resultPrinter() {
            String toPrint = "";
            if (state.result == Result.DealerWon) {
                toPrint += "Дилер выйграл раунд! "; 
            } else if (state.result == Result.PlayerWon) {
                toPrint += "Вы выйграли раунд! ";
            } else {
                toPrint += "Ничья! ";
            }
            toPrint += " Счёт " + playerCount + ":" +
                    dealerCount + " ";
            if (playerCount > dealerCount) {
                toPrint += "в вашу пользу";
            } else if (dealerCount > playerCount) {
                toPrint += "в пользу дилера";
            }
            System.out.println(toPrint);
        }
    }

    int round;
    int playerCount;
    int dealerCount;
    GameState state;
    GameIO io;

    Game() {
        io = new GameIO();
        round = 1;
        playerCount = 0;
        dealerCount = 0;
        while (true) {
            run();
            round += 1;
        }
    }

    void run() {
        state = new GameState();
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
            return;
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

    void addCounts() {
        Result result = checkState();
        switch (result) {
            case DealerWon:
                dealerCount++;
                break;
            case PlayerWon:
                playerCount++;
                break;
            default:
                break;
        }
    }

    Result handleDealer() {
        state.turn = Turn.DealerTurn;
        Card card = state.dealer.hand.getLast();
        io.openCard(card);
        card.setHidden(false);
        io.handsPrinter();
        while (checkCondition(state.dealer) == HandState.NotEnough &&
                state.dealer.getSum() < Dealer.DEALER_MAX) {
            card = state.deck.getCard();
            state.dealer.addCard(card);
            io.openCard(card);
            io.handsPrinter();

        }
        return checkState();
    }

    Result handlePlayer() {
        state.turn = Turn.PlayerTurn;
        while (checkCondition(state.player) == HandState.NotEnough && io.getInput()) {
            Card card = state.deck.getCard();
            state.player.addCard(card);
            io.openCard(card);
            io.handsPrinter();
        }
        return checkState();
    }

    Result checkState() {
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

    HandState checkCondition(Player player) {
        if (player.getSum() > 21) {
            return HandState.OverHead;
        } else if (player.getSum() == 21) {
            return HandState.BlackJack;
        } else {
            return HandState.NotEnough;
        }
    } 
}
