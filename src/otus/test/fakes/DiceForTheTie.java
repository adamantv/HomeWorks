package otus.test.fakes;

import otus.game.Dice;

public class DiceForTheTie implements Dice {
    @Override
    public int roll() {
        return 5;
    }
}
