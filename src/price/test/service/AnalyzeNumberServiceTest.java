package price.test.service;

import price.main.entity.NumberEntity;
import price.main.enums.Digit;
import price.main.service.AnalyzeNumberService;

public class AnalyzeNumberServiceTest {
    private final AnalyzeNumberService analyzeNumberService;
    private final static NumberEntity NUMBER_ENTITY = new NumberEntity(567, 5, 6, 7, true, Digit.CURRENCY);

    public AnalyzeNumberServiceTest() {
        this.analyzeNumberService = new AnalyzeNumberService();
    }

    public void getHundredWordTest() {
        System.out.println("Starting test for check getting word for hundred by number " + NUMBER_ENTITY.getValue());
        String result = analyzeNumberService.getHundredWord(NUMBER_ENTITY);
        System.out.println(result);
        if (result.equals("пятьсот")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failure");
        }
    }

    public void getDecimalWordByNumber() {
        System.out.println("Starting test for check getting word for decimal by number " + NUMBER_ENTITY.getValue());
        String result = analyzeNumberService.getDecimalWordByNumber(NUMBER_ENTITY);
        System.out.println(result);
        if (result.equals("шестьдесят")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failure");
        }
    }

    public void getDecimalWordByUnit() {
        System.out.println("Starting test for check getting decimal word by unit 0");
        String result = analyzeNumberService.getDecimalWordByUnit(0);
        System.out.println(result);
        if (result.equals("десять")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failure");
        }
    }

    public void getUnitWord() {
        System.out.println("Starting test for check getting unit word for " + NUMBER_ENTITY.getValue());
        String result = analyzeNumberService.getUnitWord(NUMBER_ENTITY, 122567);
        System.out.println(result);
        if (result.equals("семь")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failure");
        }
    }

    public void getUnitWordForZero() {
        System.out.println("Starting test for check getting unit word for zero");
        NumberEntity numberEntity = new NumberEntity(0, 0, 0, 0, true, Digit.CURRENCY);
        String result = analyzeNumberService.getUnitWord(numberEntity, 0);
        System.out.println(result);
        if (result.equals("ноль")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failure");
        }
    }


}
