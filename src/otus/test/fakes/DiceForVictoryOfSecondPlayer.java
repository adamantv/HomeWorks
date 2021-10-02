package otus.test.fakes;

import otus.game.Dice;

public class DiceForVictoryOfSecondPlayer implements Dice {
    private int count;

    @Override
    public int roll() {
        return ++count;
    }
}
