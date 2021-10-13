package price.main;

import price.main.entity.Number;
import price.main.service.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        long originValue = 121232241L;
        System.out.println("originNumber: " + originValue);
        List<Long> segments = service.getSegments(originValue);
        List<Number> numbers = service.getNumbers(segments);
        ArrayList<String> resultList = new ArrayList<>();
        for (Number number : numbers) {
            System.out.println(number);
            String first = service.analyzeHundred(number);
            String second = service.analyzeDecimal(number);
            String third = service.analyzeUnit(number, originValue);
            String word = service.getWord(number);
            Collections.addAll(resultList, first, second, third, word);
        }
        System.out.println(resultList);
        String resultString = String.join(" ", resultList).trim().replaceAll(" +", " ");
        System.out.println(resultString);
    }
}
