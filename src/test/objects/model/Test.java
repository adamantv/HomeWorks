package test.objects.model;

import java.util.Objects;

public class Test {
    private int correctAnswerCount = 0;
    private int unCorrectAnswerCount = 0;

    public Test() {
    }

    public int getCorrectAnswerCount() {
        return correctAnswerCount;
    }

    public void setCorrectAnswerCount(int correctAnswerCount) {
        this.correctAnswerCount = correctAnswerCount;
    }

    public int getUnCorrectAnswerCount() {
        return unCorrectAnswerCount;
    }

    public void setUnCorrectAnswerCount(int unCorrectAnswerCount) {
        this.unCorrectAnswerCount = unCorrectAnswerCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Test)) return false;
        Test test = (Test) o;
        return getCorrectAnswerCount() == test.getCorrectAnswerCount() && getUnCorrectAnswerCount() == test.getUnCorrectAnswerCount();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCorrectAnswerCount(), getUnCorrectAnswerCount());
    }

    @Override
    public String toString() {
        return "Test{" +
                "correctAnswerCount=" + correctAnswerCount +
                ", unCorrectAnswerCount=" + unCorrectAnswerCount +
                '}';
    }
}
