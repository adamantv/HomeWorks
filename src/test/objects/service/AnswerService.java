package test.objects.service;

import test.objects.model.Question;
import test.objects.model.Test;

public class AnswerService {
    public void validateAnswer(Question question, int inputNumber, Test test) {
        if (inputNumber == question.getIndexCorrectAnswer() + 1) {
            System.out.println("Это правильный ответ!");
            test.setCorrectAnswerCount(test.getCorrectAnswerCount() + 1);
        } else {
            System.out.println("Это неправильный ответ!");
            test.setUnCorrectAnswerCount(test.getUnCorrectAnswerCount() + 1);
        }
    }
}
