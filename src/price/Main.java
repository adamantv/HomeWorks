package price;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        long originNumber = 101000000L;
        System.out.println("originNumber: " + originNumber);
        List<Long> numberList = service.getSegments(originNumber);
        ArrayList<String> result = new ArrayList<>();
        System.out.println(numberList);
        //обход списка в обратном порядке
        for (int i = numberList.size() - 1; i >= 0; i--) {
            System.out.println(numberList.get(i));
            String first = service.calculateHundred(numberList.get(i));
            String second = service.calculateDecimal(numberList.get(i));
            Digit digit = service.transformDigit(i + 1);
            boolean isMale = service.analyzeSex(digit);
            String third = service.calculateUnit(originNumber, numberList.get(i), isMale);
            String word = service.getWord(numberList.get(i), digit);
            String numberString = String.join(" ", first, second, third, word) + " ";
            result.add(numberString);
        }
        System.out.println(result);
    }
}
