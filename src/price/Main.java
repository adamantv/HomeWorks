package price;

import java.util.ArrayList;
import java.util.List;

public class Main {
    static int[] n1 = {0, 5, 6, 7, 8, 9};
    static int[] n2 = {2, 3, 4};

    public static void main(String[] args) {
        Service service = new Service();
        long inputNumber = 12345671L;
        System.out.println("inputNumber: " + inputNumber);
        List<Long> numberList = service.getSegments(inputNumber);
        ArrayList<String> result = new ArrayList<>();
        System.out.println(numberList);
        //обход списка в обратном порядке
        for (int i = numberList.size() - 1; i >= 0; i--) {
            System.out.println(numberList.get(i));
            int hundred = service.getHundred(numberList.get(i));
            int decimal = service.getDecimal(numberList.get(i));
            int unit = service.getUnit(numberList.get(i));
            System.out.println(hundred + " " + decimal + " " + unit);
            String first = service.analyzeHundred(hundred);
            String second = service.analyzeDecimal(decimal, unit);
            String third = "";
            if (decimal != 1) {
                third = service.analyzeUnit(unit);
            }
            System.out.println(i + 1);
            String word = service.analyzeWord(i + 1);
            String numberString = String.join(" ", first, second, third, word) + " ";
            result.add(numberString);
        }
        System.out.println(result);
    }
}
