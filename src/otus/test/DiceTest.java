package otus.test;

import otus.game.Dice;
import otus.game.DiceImpl;

public class DiceTest {
    public void checkValue() {
        System.out.println("Started test for check correctness dices value");
        Dice dice = new DiceImpl();
        int value = dice.roll();
        System.out.println("Dice value: " + value + "\n");
        if (value < 1 || value > 6) {
            System.err.println("Test failed. Dices value may me in interval 1...6");
        }
    }

}
