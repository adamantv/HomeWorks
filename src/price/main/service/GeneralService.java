package price.main.service;

import price.main.entity.Number;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GeneralService {
    private final AnalyzeNumberService analyzeService;
    private final InputDataService inputDataService;
    private final CalculateService calculateService;

    public GeneralService() {
        this.analyzeService = new AnalyzeNumberService();
        this.inputDataService = new InputDataService();
        this.calculateService = new CalculateService();
    }

    /**
     * General method for get input number and transform it to amount in words
     * maximal order - billion
     *
     * @return amount in words
     */
    public String enterDataAndGetResult() {
        long originValue = inputDataService.getInputNumber();
        System.out.println("originNumber: " + originValue);
        List<Long> segments = calculateService.getSegments(originValue);
        List<Number> numbers = calculateService.getNumbers(segments);
        ArrayList<String> resultList = new ArrayList<>();
        numbers.forEach(number -> {
            String hundredWord = analyzeService.getHundredWord(number);
            String decimalWord = analyzeService.getDecimalWordByNumber(number);
            String unitWord = analyzeService.getUnitWord(number, originValue);
            String digitWord = analyzeService.getDigitWord(number);
            Collections.addAll(resultList, hundredWord, decimalWord, unitWord, digitWord);
        });
        return String.join(" ", resultList).trim().replaceAll(" +", " ");
    }
}
