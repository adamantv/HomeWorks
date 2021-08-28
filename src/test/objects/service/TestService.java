package test.objects.service;

import test.objects.model.Question;
import test.objects.model.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class TestService {
    private static final String STOP_WORD = "stop";
    private QuestionService questionService;
    private AnswerService answerService;

    public TestService() {
        this.questionService = new QuestionService();
        this.answerService = new AnswerService();
    }

    public void test() {
        Test test = new Test();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Пройдите тест. Необходимо ввести с клавиатуры номер ответа. \n" +
                "Все вопросы с одним правильным вариантом ответа.");
        while (true) {
            Question question = questionService.createQuestion();
            try {
                String inputString = reader.readLine();
                if (inputString.equalsIgnoreCase(STOP_WORD)) {
                    break;
                }
                int inputNumber = Integer.parseInt(inputString);
                answerService.validateAnswer(question, inputNumber, test);
            } catch (Exception e) {
                System.out.println("Проверьте корректность вводимых данных. \n" +
                        "Необходимо использовать числа.");
                e.printStackTrace();
                break;
            }
        }
        System.out.println("Ваш результат: " + test.getCorrectAnswerCount() + " правильных ответов и " + test.getUnCorrectAnswerCount() + " неправильных ответов.");
    }
}
