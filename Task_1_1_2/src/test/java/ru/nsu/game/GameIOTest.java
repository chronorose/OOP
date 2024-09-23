package ru.nsu.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import ru.nsu.cards.*;
import org.junit.jupiter.api.Test;

class GameIOTest {
    @Test
    void testGIOTurn1() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream orOut = System.out;
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
    void testGIOTurn2() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream orOut = System.out;
        GameScore score = new GameScore();
        GameIO io = new GameIO(score);
        System.setOut(new PrintStream(out));
        GameState gs = new GameState();
        io.setState(gs);
        gs.turn = Turn.DealerTurn;
        io.turnName();
        assertEquals("Ход дилера\n------\n", out.toString());
        System.setOut(orOut);
    }

    @Test
    void testGIOHands() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream orOut = System.out;
        GameScore score = new GameScore();
        GameIO io = new GameIO(score);
        System.setOut(new PrintStream(out));
        GameState gs = new GameState();
        io.setState(gs);
        gs.turn = Turn.PlayerTurn;
        String str = "  Ваши карты: " + gs.player.toString() + " => " + gs.player.sum + "\n" + "  Карты дилера: " + gs.dealer.toString() + "\n\n";
        io.handsPrinter();
        assertEquals(str, out.toString());
        System.setOut(orOut);
    }

    @Test
    void testGIOOpenCard() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream orOut = System.out;
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
    void testGIORPrinter() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream orOut = System.out;
        GameScore score = new GameScore();
        GameIO io = new GameIO(score);
        System.setOut(new PrintStream(out));
        GameState gs = new GameState();
        io.setState(gs);
        gs.result = Result.DealerWon;
        String str = "Дилер выйграл раунд! " + " Счёт " + score.getPlayerScore() + ":" + score.getDealerScore() + " \n";
        io.resultPrinter();
        assertEquals(str, out.toString());
        System.setOut(orOut);
    }
}
