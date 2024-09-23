package ru.nsu.game;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import ru.nsu.cards.Card;

/**
 * Class that prints everything.
 */
class GameIO {
    private static final String askForInput =
            "Введите \"" + PlayerInput.Continue.val 
            + "\", чтобы взять карту, и \"" + PlayerInput.Stop.val 
            + "\", чтобы остановиться...\n";
    GameState state;
    GameScore score;
    BufferedReader reader;

    GameIO(GameScore score) {
        reader = new BufferedReader(new InputStreamReader(System.in));
        this.score = score;
    }

    void setState(GameState state) {
        this.state = state;
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
        } catch (Throwable exception) {
            System.out.println("Неправильный ввод, повторите ещё раз: ");
        }
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
    }

    void handsPrinter() {
        String toPrint = "  Ваши карты: " + state.player.toString() 
            + " => " + state.player.sum + "\n";
        toPrint += "  Карты дилера: " + state.dealer.toString();
        if (state.turn == Turn.DealerTurn) {
            toPrint += " => " + state.dealer.sum;
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
        toPrint += " Счёт " + score.getPlayerScore() + ":" 
            + score.getDealerScore() + " ";
        if (score.getPlayerScore() > score.getDealerScore()) {
            toPrint += "в вашу пользу";
        } else if (score.getDealerScore() > score.getPlayerScore()) {
            toPrint += "в пользу дилера";
        }
        System.out.println(toPrint);
    }
}
