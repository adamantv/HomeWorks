package exception;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputDataHandler {
    /**
     * example for try-with-resources
     * @return String entered by keyboard
     */
    public String readStringFromKeyboard() throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Please, enter the number");
            return reader.readLine();
        }
    }

    /**
     * example for logging error and return default value
     * @param inputString String entered by keyboard
     * @return result of parsing inputString
     */
    public int parseString(String inputString) {
        int number = 0; //default value
        try {
            number = Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            System.out.println("Number format is incorrect. " + e);
        }
        return number;
     }


}
