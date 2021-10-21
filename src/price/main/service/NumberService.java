package price.main.service;

import price.main.entity.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberService {
    private final AnalyzeService analyzeService;
    private final InputDataService inputDataService;
    private final CalculateService calculateService;

    public NumberService() {
        this.analyzeService = new AnalyzeService();
        this.inputDataService = new InputDataService();
        this.calculateService = new CalculateService();
    }

    public String enterDataAndGetResult() {
        long originValue = inputDataService.getInputNumber();
        System.out.println("originNumber: " + originValue);
        List<Long> segments = calculateService.getSegments(originValue);
        List<Number> numbers = calculateService.getNumbers(segments);
        ArrayList<String> resultList = new ArrayList<>();
        for (Number number : numbers) {
            System.out.println(number);
            String hundredWord = analyzeService.getHundredWord(number);
            String decimalWord = analyzeService.getDecimalWordByNumber(number);
            String unitWord = analyzeService.getUnitWord(number, originValue);
            String digitWord = analyzeService.getDigitWord(number);
            Collections.addAll(resultList, hundredWord, decimalWord, unitWord, digitWord);
        }
        System.out.println(resultList);
        return String.join(" ", resultList).trim().replaceAll(" +", " ");
    }
}
