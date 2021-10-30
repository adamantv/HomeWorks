package price.test.service;

import price.main.entity.NumberEntity;
import price.main.enums.Digit;
import price.main.service.AnalyzeNumberService;

public class AnalyzeNumberServiceTest {
    private final AnalyzeNumberService analyzeNumberService;

    public AnalyzeNumberServiceTest() {
        this.analyzeNumberService = new AnalyzeNumberService();
    }

    public void testWordForCurrency() {
        System.out.println("Testing generate word for currency");
        NumberEntity numberEntity = new NumberEntity(567);
        numberEntity.setHundred(5);
        numberEntity.setDecimal(6);
        numberEntity.setUnit(7);
        numberEntity.setDigit(Digit.CURRENCY);
        numberEntity.setMale(true);
        String word = analyzeNumberService.generateFinalWord(numberEntity, numberEntity.getValue());
        System.out.println("Result is: " + word);
        if (word.equals("пятьсот шестьдесят семь рублей")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    public void testWordForThousand() {
        System.out.println("Testing generate word for thousand");
        NumberEntity numberEntity = new NumberEntity(567);
        numberEntity.setHundred(5);
        numberEntity.setDecimal(6);
        numberEntity.setUnit(7);
        numberEntity.setDigit(Digit.THOUSAND);
        numberEntity.setMale(false);
        String word = analyzeNumberService.generateFinalWord(numberEntity, numberEntity.getValue());
        System.out.println("Result is: " + word);
        if (word.equals("пятьсот шестьдесят семь тысяч")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    public void testWordForMillion() {
        System.out.println("Testing generate word for million");
        NumberEntity numberEntity = new NumberEntity(567);
        numberEntity.setHundred(5);
        numberEntity.setDecimal(6);
        numberEntity.setUnit(7);
        numberEntity.setDigit(Digit.MILLION);
        numberEntity.setMale(true);
        String word = analyzeNumberService.generateFinalWord(numberEntity, numberEntity.getValue());
        System.out.println("Result is: " + word);
        if (word.equals("пятьсот шестьдесят семь миллионов")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    public void testWordForBillion() {
        System.out.println("Testing generate word for billion");
        NumberEntity numberEntity = new NumberEntity(567);
        numberEntity.setHundred(5);
        numberEntity.setDecimal(6);
        numberEntity.setUnit(7);
        numberEntity.setDigit(Digit.BILLION);
        numberEntity.setMale(true);
        String word = analyzeNumberService.generateFinalWord(numberEntity, numberEntity.getValue());
        System.out.println("Result is: " + word);
        if (word.equals("пятьсот шестьдесят семь миллиардов")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }
}
