package price.main.service;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class InputDataService {
    /**
     * Method for get input data by the keyboard and transform it to integer
     *
     * @return input number as integer
     */
    public Long getInputNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите положительное число");
        while (true) {
            try {
                String inputString = reader.readLine();
                long inputNumber = Long.parseLong(inputString);
                if (inputNumber >= 0) {
                    return inputNumber;
                } else {
                    printAlert();
                }
            } catch (Exception e) {
                printAlert();
                e.printStackTrace();
                break;
            }
        }
        return null;
    }

    private void printAlert() {
        System.out.println("Проверьте корректность вводимых данных. \n" +
                "Необходимо использовать положительные числа.");
    }

}
