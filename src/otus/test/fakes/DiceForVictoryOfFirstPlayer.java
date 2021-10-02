package otus.test.fakes;

import otus.game.Dice;

public class DiceForVictoryOfFirstPlayer implements Dice {
    private int count = 2;

    @Override
    public int roll() {
        return count--;
    }
}
