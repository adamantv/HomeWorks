package otus.test.stubs;

import otus.game.Dice;

public class DiceForVictoryOfSecondPlayer implements Dice {
    private int count;

    /**
     * stub class for check case: victory of first player
     *
     * @return stub value on the first call is smaller than the value on the second call
     */
    @Override
    public int roll() {
        return ++count;
    }
}
