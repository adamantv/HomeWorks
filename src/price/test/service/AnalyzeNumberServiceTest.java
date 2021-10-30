package price.test.service;

import price.main.entity.NumberEntity;
import price.main.enums.Digit;
import price.main.service.AnalyzeNumberService;

public class AnalyzeNumberServiceTest {
    private final AnalyzeNumberService analyzeNumberService;

    public AnalyzeNumberServiceTest() {
        this.analyzeNumberService = new AnalyzeNumberService();
    }

    private void testWordForCurrency() {
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

    private void testWordForThousand() {
        System.out.println("Testing generate word for thousand");
        NumberEntity numberEntity = new NumberEntity(567000);
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

    private void testWordForMillion() {
        System.out.println("Testing generate word for million");
        NumberEntity numberEntity = new NumberEntity(567000111);
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

    private void testWordForBillion() {
        System.out.println("Testing generate word for billion");
        NumberEntity numberEntity = new NumberEntity(567000111222L);
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

    private void testWordForZeroValue() {
        System.out.println("Testing generate word for zero value");
        NumberEntity numberEntity = new NumberEntity(0);
        numberEntity.setHundred(0);
        numberEntity.setDecimal(0);
        numberEntity.setUnit(0);
        numberEntity.setDigit(Digit.CURRENCY);
        numberEntity.setMale(true);
        String word = analyzeNumberService.generateFinalWord(numberEntity, numberEntity.getValue());
        System.out.println("Result is: " + word);
        if (word.equals("ноль рублей")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    private void testWordForOneRuble() {
        System.out.println("Testing generate word for one ruble");
        NumberEntity numberEntity = new NumberEntity(1);
        numberEntity.setHundred(0);
        numberEntity.setDecimal(0);
        numberEntity.setUnit(1);
        numberEntity.setDigit(Digit.CURRENCY);
        numberEntity.setMale(true);
        String word = analyzeNumberService.generateFinalWord(numberEntity, numberEntity.getValue());
        System.out.println("Result is: " + word);
        if (word.equals("один рубль")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    private void testWordForOneHundred() {
        System.out.println("Testing generate word for one hundred");
        NumberEntity numberEntity = new NumberEntity(100);
        numberEntity.setHundred(1);
        numberEntity.setDecimal(0);
        numberEntity.setUnit(0);
        numberEntity.setDigit(Digit.CURRENCY);
        numberEntity.setMale(true);
        String word = analyzeNumberService.generateFinalWord(numberEntity, numberEntity.getValue());
        System.out.println("Result is: " + word);
        if (word.equals("сто рублей")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    private void testWordForOneThousand() {
        System.out.println("Testing generate word for one thousand");
        NumberEntity numberEntity = new NumberEntity(1000);
        numberEntity.setUnit(1);
        numberEntity.setDigit(Digit.THOUSAND);
        numberEntity.setMale(false);
        String word = analyzeNumberService.generateFinalWord(numberEntity, numberEntity.getValue());
        System.out.println("Result is: " + word);
        if (word.equals("одна тысяча")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    private void testWordForOneMillion() {
        System.out.println("Testing generate word for one million");
        NumberEntity numberEntity = new NumberEntity(1000000);
        numberEntity.setUnit(1);
        numberEntity.setDigit(Digit.MILLION);
        numberEntity.setMale(true);
        String word = analyzeNumberService.generateFinalWord(numberEntity, numberEntity.getValue());
        System.out.println("Result is: " + word);
        if (word.equals("один миллион")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    private void testWordForOneBillion() {
        System.out.println("Testing generate word for one billion");
        NumberEntity numberEntity = new NumberEntity(1000000);
        numberEntity.setUnit(1);
        numberEntity.setDigit(Digit.BILLION);
        numberEntity.setMale(true);
        String word = analyzeNumberService.generateFinalWord(numberEntity, numberEntity.getValue());
        System.out.println("Result is: " + word);
        if (word.equals("один миллиард")) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    public void runAllTests() {
        testWordForThousand();
        testWordForCurrency();
        testWordForMillion();
        testWordForBillion();
        testWordForZeroValue();
        testWordForOneRuble();
        testWordForOneHundred();
        testWordForOneThousand();
        testWordForOneMillion();
        testWordForOneBillion();
    }


}
