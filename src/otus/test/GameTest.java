package otus.test;

import otus.game.*;
import otus.test.fakes.DiceForTheTie;
import otus.test.fakes.DiceForVictoryOfFirstPlayer;
import otus.test.fakes.DiceForVictoryOfSecondPlayer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameTest {
    private static final Player PLAYER_1 = new Player("Вася");
    private static final Player PLAYER_2 = new Player("Игорь");

    public void testTheSameResult() {
        System.out.println("Test for check tie");
        Dice diceFake = new DiceForTheTie();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(diceFake, winnerPrinter);
        // Create a stream to hold the output
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        game.playGame(PLAYER_1, PLAYER_2);
        // Put things back
        System.out.flush();
        System.setOut(old);
        System.out.println("Captured string: " + byteArrayOutputStream);
        if (byteArrayOutputStream.toString().contains(PLAYER_1.getName())
                || byteArrayOutputStream.toString().contains(PLAYER_2.getName())) {
            System.err.println("Test failed. Nobody won!\n");
        } else {
            //в логике приложения нет описанного поведения в случае ничьи, поэтому просто используется else
            System.out.println("We have a tie!\n");
        }
        System.out.println("--------------------------");
    }

    public void testCheckVictoryOfFirstPlayer() {
        System.out.println("Test for check victory of first player started");
        Dice diceFake = new DiceForVictoryOfFirstPlayer();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(diceFake, winnerPrinter);
        // Create a stream to hold the output
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        game.playGame(PLAYER_1, PLAYER_2);
        // Put things back
        System.out.flush();
        System.setOut(old);
        System.out.println("Captured string: " + byteArrayOutputStream);
        if (byteArrayOutputStream.toString().contains(PLAYER_1.getName())) {
            System.out.println("Test completed. Winner is first player\n");
        } else {
            System.err.println("Test failed. Second player must be win\n");
        }
        System.out.println("--------------------------");
    }

    public void testCheckVictoryOfSecondPlayer() {
        System.out.println("Test for check victory of second player started");
        Dice diceFake = new DiceForVictoryOfSecondPlayer();
        GameWinnerPrinter winnerPrinter = new GameWinnerConsolePrinter();
        Game game = new Game(diceFake, winnerPrinter);
        // Create a stream to hold the output
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        // IMPORTANT: Save the old System.out!
        PrintStream old = System.out;
        // Tell Java to use your special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        Player player1 = new Player("Вася");
        Player player2 = new Player("Игорь");
        game.playGame(player1, player2);
        // Put things back
        System.out.flush();
        System.setOut(old);
        System.out.println("Captured string: " + byteArrayOutputStream);
        if (byteArrayOutputStream.toString().contains(player2.getName())) {
            System.out.println("Test completed. Winner is second player\n");
        } else {
            System.err.println("Test failed. Second player must be win\n");
        }
        System.out.println("--------------------------");
    }

}
