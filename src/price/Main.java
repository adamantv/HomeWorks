package price;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] n1 = {0, 5, 6, 7, 8, 9};
    static int[] n2 = {2, 3, 4};

    public static void main(String[] args) {
        Service service = new Service();
        long inputNumber = 12345678L;
        List<Long> numberList = service.getSegments(inputNumber);
        ArrayList<String> result = new ArrayList<>();
        System.out.println(numberList);
        for (Long number : numberList) {
            System.out.println(number);
            int hundred = service.getHundred(number);
            int decimal = service.getDecimal(number);
            int unit = service.getUnit(number);
            System.out.println(hundred);
            System.out.println(decimal);
            System.out.println(unit);
            String first = service.analyzeHundred(hundred);
            String second = service.analyzeDecimal(decimal, unit);
            String third = "";
            if (decimal != 1) {
                third = service.analyzeUnit(unit);
            }
            String numberString = String.join(" ", first, second, third) + " ";
            result.add(numberString);
        }
        System.out.println(result);
    }
}
