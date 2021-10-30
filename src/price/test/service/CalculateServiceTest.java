package price.test.service;

import price.main.entity.NumberEntity;
import price.main.service.CalculateService;

import java.util.List;

public class CalculateServiceTest {
    private final CalculateService calculateService;

    public CalculateServiceTest() {
        this.calculateService = new CalculateService();
    }

    private void testGenerateNumbersListWithOneItem() {
        System.out.println("Testing generate numbers list with one item");
        long originValue = 100;
        List<NumberEntity> numberEntities = calculateService.getNumbers(originValue);
        if (numberEntities.size() == 1 && numberEntities.get(0).getValue() == 100) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    private void testGenerateNumbersListWithTwoItems() {
        System.out.println("Testing generate numbers list with two items");
        long originValue = 21100;
        List<NumberEntity> numberEntities = calculateService.getNumbers(originValue);
        if (numberEntities.size() == 2 && numberEntities.get(1).getValue() == 100 && numberEntities.get(0).getValue() == 21) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    private void testGenerateNumbersListWithThreeItem() {
        System.out.println("Testing generate numbers list with three items");
        long originValue = 3421100;
        List<NumberEntity> numberEntities = calculateService.getNumbers(originValue);
        if (numberEntities.size() == 3 && numberEntities.get(0).getValue() == 3
                && numberEntities.get(1).getValue() == 421 && numberEntities.get(2).getValue() == 100) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    private void testGenerateNumbersListWithFourItem() {
        System.out.println("Testing generate numbers list with four items");
        long originValue = 1993421999;
        List<NumberEntity> numberEntities = calculateService.getNumbers(originValue);
        if (numberEntities.size() == 4 && numberEntities.get(0).getValue() == 1
                && numberEntities.get(1).getValue() == 993 && numberEntities.get(2).getValue() == 421
                && numberEntities.get(3).getValue() == 999) {
            System.out.println("Test passed");
        } else {
            System.err.println("Test failed");
        }
    }

    public void runAllTests() {
        testGenerateNumbersListWithOneItem();
        testGenerateNumbersListWithTwoItems();
        testGenerateNumbersListWithThreeItem();
        testGenerateNumbersListWithFourItem();
    }
}
