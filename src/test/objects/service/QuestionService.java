package test.objects.service;

import test.objects.model.Question;

import java.util.Arrays;

public class QuestionService {
    public Question createQuestion() {
        int numberQuestion = (int) (Math.random() * 3) + 1;
        Question question = new Question();
        switch (numberQuestion) {
            case 1:
                question.setName("Как называется наша планета?");
                question.setAnswers(Arrays.asList("1 Земля", "2 Марс", "3 Венера"));
                question.setIndexCorrectAnswer(0);
                break;
            case 2:
                question.setName("Как называется спутник нашей планеты?");
                question.setAnswers(Arrays.asList("1 Земля", "2 Марс", "3 Юпитер", "4 Луна"));
                question.setIndexCorrectAnswer(3);
                break;
            case 3:
                question.setName("Как называется планета с кольцами?");
                question.setAnswers(Arrays.asList("1 Плутон", "2 Уран", "3 Марс", "4 Венера", "5 Сатурн"));
                question.setIndexCorrectAnswer(4);
                break;
        }
        System.out.println(question.getName());
        System.out.println(question.getAnswers());
        return question;
    }

}
