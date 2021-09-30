package exception;

import java.util.Arrays;

public class CalculationService {
    /**
     * Example for rethrow exception
     *
     * @param a input number (dividend)
     * @param b input number (divisor)
     * @return result of divide
     */
    public int divide(int a, int b) throws MyException {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            throw new MyException("Trouble during try to divide " + a + " by " + b);
        }
    }

    /**
     * Example for only logging exception, do nothing
     *
     * @param number - input parameter
     */
    public void addNumberToArray(int[] array, int number, int index) {
        try {
            array[index] = number;
            System.out.println(Arrays.toString(array));
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is incorrect");
            e.printStackTrace();
        }
    }
}
