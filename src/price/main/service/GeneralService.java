package price.main.service;

import price.main.entity.NumberEntity;

import java.util.ArrayList;
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
        List<NumberEntity> numberEntities = calculateService.getNumbers(originValue);
        ArrayList<String> resultList = new ArrayList<>();
        numberEntities.forEach(numberEntity -> {
            String hundredWord = analyzeService.getFinalWord(numberEntity, originValue);
            if (!hundredWord.isEmpty()) {
                resultList.add(hundredWord);
            }
        });
        return String.join(" ", resultList);
    }
}
