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
            String hundredWord = service.analyzeHundred(number);
            String decimalWord = service.analyzeDecimal(number);
            String unitWord = service.analyzeUnit(number, originValue);
            String digitWord = service.getWord(number);
            Collections.addAll(resultList, hundredWord, decimalWord, unitWord, digitWord);
        }
        System.out.println(resultList);
        String resultString = String.join(" ", resultList).trim().replaceAll(" +", " ");
        System.out.println(resultString);
    }
}
