package exception;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        InputDataHandler inputDataHandler = new InputDataHandler();
        CalculationService calculationService = new CalculationService();
        String inputString = inputDataHandler.readStringFromKeyboard();
        int number = inputDataHandler.parseString(inputString);
        calculationService.calculate(number);
    }
}
