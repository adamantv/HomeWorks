package test.objects.model;

import java.util.List;
import java.util.Objects;

public class Question {
    private String name;
    private List<String> answers;
    private int indexCorrectAnswer;

    public Question() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }

    public int getIndexCorrectAnswer() {
        return indexCorrectAnswer;
    }

    public void setIndexCorrectAnswer(int indexCorrectAnswer) {
        this.indexCorrectAnswer = indexCorrectAnswer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return getIndexCorrectAnswer() == question.getIndexCorrectAnswer() && Objects.equals(getName(), question.getName()) && Objects.equals(getAnswers(), question.getAnswers());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAnswers(), getIndexCorrectAnswer());
    }

    @Override
    public String toString() {
        return "test.model.Question{" +
                "name='" + name + '\'' +
                ", answers=" + answers +
                ", indexCorrectAnswer=" + indexCorrectAnswer +
                '}';
    }
}