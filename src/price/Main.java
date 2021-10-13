package price;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        long inputNumber = 12013011L;
        System.out.println("inputNumber: " + inputNumber);
        List<Long> numberList = service.getSegments(inputNumber);
        ArrayList<String> result = new ArrayList<>();
        System.out.println(numberList);
        //обход списка в обратном порядке
        for (int i = numberList.size() - 1; i >= 0; i--) {
            System.out.println(numberList.get(i));
            String first = service.analyzeHundred(numberList.get(i));
            String second = service.analyzeDecimal(numberList.get(i));
            boolean isMale = service.analyzeSex(i + 1);
            String third = service.analyzeUnit(numberList.get(i), isMale);
            ;
            String word = service.getWord(numberList.get(i), i + 1);
            String numberString = String.join(" ", first, second, third, word) + " ";
            result.add(numberString);
        }
        System.out.println(result);
    }
}
