package test.procedure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MyTest {
    public static void main(String[] args) {
        String question1 = "Как называется наша планета?";
        String[] answers1 = {"1 Земля", "2 Марс", "3 Венера"};
        int indexCorrectAnswer1 = 0;

        String question2 = "Как называется спутник нашей планеты";
        String[] answers2 = {"1 Земля", "2 Марс", "3 Юпитер", "4 Луна"};
        int indexCorrectAnswer2 = 3;

        String question3 = "Как называется планета с кольцами?";
        String[] answers3 = {"1 Плутон", "2 Уран", "3 Марс", "4 Венера", "5 Сатурн"};
        int indexCorrectAnswer3 = 4;

        String[][] answers = {answers1, answers2, answers3};
        String[] questions = {question1, question2, question3};
        int[] indexes = {indexCorrectAnswer1, indexCorrectAnswer2, indexCorrectAnswer3};

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;

        System.out.println("Пройдите тест. Необходимо ввести с клавиатуры номер ответа. \n" +
                "Все вопросы с одним правильным вариантом ответа. \n");
        for (int i = 0; i < questions.length; i++) {
            System.out.println("Вопрос " + (i + 1));
            System.out.println(questions[i]);
            System.out.println(Arrays.toString(answers[i]));
            try {
                int line = Integer.parseInt(reader.readLine());
                int index = indexes[i];
                if (line == index + 1) {
                    result++;
                }
            } catch (Exception e) {
                System.out.println("Проверьте корректность вводимых данных. \n" +
                        "Необходимо использовать числа.");
                break;
            }
        }
        System.out.println("Ваш результат: " + result + "/" + questions.length);
    }
}
