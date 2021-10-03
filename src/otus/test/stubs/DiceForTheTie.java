package otus.test.stubs;

import otus.game.Dice;

public class DiceForTheTie implements Dice {
    /**
     * stub class for check tie
     *
     * @return always the same value
     */
    @Override
    public int roll() {
        return 5;
    }
}
