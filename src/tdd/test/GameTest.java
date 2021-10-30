package tdd.test;

import tdd.game.*;
import tdd.test.stubs.DiceForTheTie;
import tdd.test.stubs.DiceForVictoryOfFirstPlayer;
import tdd.test.stubs.DiceForVictoryOfSecondPlayer;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class GameTest {
    private static final Player PLAYER_1 = new Player("Вася");
    private static final Player PLAYER_2 = new Player("Игорь");
    private final GameWinnerPrinter winnerPrinter;

    public GameTest() {
        this.winnerPrinter = new GameWinnerConsolePrinter();
    }

    private String captureStringDuringPlayGame(Dice dice) {
        Game game = new Game(dice, winnerPrinter);
        // Create a stream to hold the output
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(byteArrayOutputStream);
        //Save the old System.out
        PrintStream old = System.out;
        //use my special stream
        System.setOut(ps);
        // Print some output: goes to your special stream
        game.playGame(PLAYER_1, PLAYER_2);
        // Put things back
        System.out.flush();
        System.setOut(old);
        System.out.println("Captured string: " + byteArrayOutputStream);
        return byteArrayOutputStream.toString();
    }

    private void testTheSameResult() {
        System.out.println("Test for check tie");
        Dice diceFake = new DiceForTheTie();
        String captureString = captureStringDuringPlayGame(diceFake);
        if (captureString.contains(PLAYER_1.getName())
                || captureString.contains(PLAYER_2.getName())) {
            System.err.println("Test for check tie failed. Nobody won!");
        } else {
            //в логике приложения нет описанного поведения в случае ничьи, поэтому просто используется else
            System.out.println("Test for check tie completed. Nobody won!");
        }
    }

    private void testCheckVictoryOfFirstPlayer() {
        System.out.println("Test for check victory of first player started");
        Dice diceFake = new DiceForVictoryOfFirstPlayer();
        String captureString = captureStringDuringPlayGame(diceFake);
        if (captureString.contains(PLAYER_1.getName())) {
            System.out.println("Test for check victory of first player completed. Winner is first player");
        } else {
            System.err.println("Test for check victory of first player failed. Second player must be win");
        }
    }

    private void testCheckVictoryOfSecondPlayer() {
        System.out.println("Test for check victory of second player started");
        Dice diceFake = new DiceForVictoryOfSecondPlayer();
        String captureString = captureStringDuringPlayGame(diceFake);
        if (captureString.contains(PLAYER_2.getName())) {
            System.out.println("Test for check victory of second player completed. Winner is second player");
        } else {
            System.err.println("Test for check victory of second player failed. Second player must be win");
        }
    }

    public void runAllTests() {
        testCheckVictoryOfFirstPlayer();
        testCheckVictoryOfSecondPlayer();
        testTheSameResult();
    }

}
