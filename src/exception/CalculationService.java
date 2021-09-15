package exception;

public class CalculationService {
    private static final int[] ARRAY_FOR_CALCULATE = {-1,0,1};
    /**
     * Example for logging few exceptions
     * @param number - input parameter
     */
    public void calculate(int number) {
        try {
            ARRAY_FOR_CALCULATE[number-1] = 4/number;
            System.out.println(ARRAY_FOR_CALCULATE[number]);
        } catch (ArithmeticException e) {
            System.out.println("Incorrect arithmetic operation");
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index is incorrect");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Something went wrong");
            e.printStackTrace();
        }
    }

    /**
     * Example for rethrow exception
     * @param number - input number
     */
    public void checkNumberForZero(int number) throws Exception {
        try {
            if (number == 0) {
                System.out.println("Number is zero");
                throwException();
            }
        } catch(Exception e) {
            System.out.println("Exception thrown from checkNumberForZero() method");
            throw e;
        }
    }

    private void throwException() throws Exception {
        System.out.println("Need to throw exception");
        throw new Exception("Exception thrown from throwException() method");
    }
}
