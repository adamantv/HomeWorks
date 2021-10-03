package otus.test.stubs;

import otus.game.Dice;

public class DiceForVictoryOfFirstPlayer implements Dice {
    private int count = 2;

    /**
     * stub class for check case: victory of first player
     *
     * @return stub value on the first call is greater than the value on the second call
     */
    @Override
    public int roll() {
        return count--;
    }
}
