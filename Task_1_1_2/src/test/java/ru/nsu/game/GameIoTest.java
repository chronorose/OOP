package ru.nsu.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import ru.nsu.cards.Card;
import ru.nsu.cards.CardValue;
import ru.nsu.cards.Kind;

class GameIoTest {
    @Test
    void testGiOturn1() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        final PrintStream orOut = System.out;
        GameScore score = new GameScore();
        GameIO io = new GameIO(score);
        System.setOut(new PrintStream(out));
        GameState gs = new GameState();
        io.setState(gs);
        gs.turn = Turn.PlayerTurn;
        io.turnName();
        assertEquals("\nВаш ход\n------\n", out.toString());
        System.setOut(orOut);
    }

    @Test
    void testGiOturn2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        GameScore score = new GameScore();
        GameIO io = new GameIO(score);
        GameState gs = new GameState();
        io.setState(gs);
        gs.turn = Turn.DealerTurn;
        final PrintStream orOut = System.out;
        System.setOut(new PrintStream(out));
        io.turnName();
        assertEquals("Ход дилера\n------\n", out.toString());
        System.setOut(orOut);
    }

    @Test
    void testGiOhands() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        final PrintStream orOut = System.out;
        GameScore score = new GameScore();
        GameIO io = new GameIO(score);
        System.setOut(new PrintStream(out));
        GameState gs = new GameState();
        io.setState(gs);
        gs.turn = Turn.PlayerTurn;
        String str = "  Ваши карты: " + gs.player.toString() 
            + " => " + gs.player.sum + "\n" 
            + "  Карты дилера: " + gs.dealer.toString() + "\n\n";
        io.handsPrinter();
        assertEquals(str, out.toString());
        System.setOut(orOut);
    }

    @Test
    void testGiOopenCard() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        final PrintStream orOut = System.out;
        GameScore score = new GameScore();
        GameIO io = new GameIO(score);
        System.setOut(new PrintStream(out));
        GameState gs = new GameState();
        io.setState(gs);
        gs.turn = Turn.DealerTurn;
        Card card = new Card(Kind.Clubs, CardValue.Ace);
        String str = "Дилер открывает карту " + card + "\n";
        io.openCard(card);
        assertEquals(str, out.toString());
        System.setOut(orOut);
    }

    @Test
    void testGiOrPrinter() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        final PrintStream orOut = System.out;
        GameScore score = new GameScore();
        GameIO io = new GameIO(score);
        System.setOut(new PrintStream(out));
        GameState gs = new GameState();
        io.setState(gs);
        gs.result = Result.DealerWon;
        String str = "Дилер выйграл раунд! " 
            + " Счёт " + score.getPlayerScore() 
            + ":" + score.getDealerScore() + " \n";
        io.resultPrinter();
        assertEquals(str, out.toString());
        System.setOut(orOut);
    }
}
