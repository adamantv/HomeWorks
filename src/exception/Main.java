package exception;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, MyException {
        InputDataHandler inputDataHandler = new InputDataHandler();
        CalculationService calculationService = new CalculationService();
        String inputString = inputDataHandler.readStringFromKeyboard();
        int number = inputDataHandler.parseString(inputString);
        int[] array = {-1, 0, 1};
        int index = array.length;
        calculationService.addNumberToArray(array, number, index);
        int result = calculationService.divide(number, args.length);
        System.out.println(result);
    }
}
