package tdd.test;

import tdd.game.Dice;
import tdd.game.DiceImpl;

import java.time.Instant;

public class DiceTest {
    /**
     * test to check the correct number during trying to roll the dice
     */
    public void checkValue() {
        System.out.println("Started test for check correctness dices value " + Instant.now());
        Dice dice = new DiceImpl();
        int value = dice.roll();
        System.out.println("Dice value: " + value + "\n");
        if (value > 0 && value < 7) {
            System.out.println("Test completed. Value is correct " + Instant.now());
        } else {
            System.err.println("Test failed. Dices value may me in interval 1...6 " + Instant.now());
        }
    }

}
