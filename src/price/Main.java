package price;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Service service = new Service();
        int number = 110;
        ArrayList<Integer> numberList = service.getNumberList(number);
        ArrayList<String> result = new ArrayList<>();
        System.out.println(numberList);
        String first = switch (numberList.get(0)) {
            case 0 -> "";
            case 1 -> "сто";
            case 2 -> "двести";
            case 3 -> "триста";
            case 4 -> "четыреста";
            case 5 -> "пятьсот";
            case 6 -> "шестьсот";
            case 7 -> "семьсот";
            case 8 -> "восемьсот";
            case 9 -> "девятьсот";
            default -> throw new IllegalStateException("Unexpected value: " + numberList.get(0));
        };
        result.add(first);

        String second = switch (numberList.get(1)) {
            case 0 -> "";
            case 1 -> service.getValue(numberList.get(2)); //вызов метода
            case 2 -> "двадцать";
            case 3 -> "тридцать";
            case 4 -> "сорок";
            case 5 -> "пятьдесят";
            case 6 -> "шестьдесят";
            case 7 -> "семьдесят";
            case 8 -> "восемьдесят";
            case 9 -> "девяносто";
            default -> throw new IllegalStateException("Unexpected value: " + numberList.get(0));
        };
        result.add(second);

        if (numberList.get(1) != 1) {
            String third = switch (numberList.get(2)) {
                case 0 -> "";
                case 1 -> "один";
                case 2 -> "два";
                case 3 -> "три";
                case 4 -> "четыре";
                case 5 -> "пять";
                case 6 -> "шесть";
                case 7 -> "семь";
                case 8 -> "восемь";
                case 9 -> "девять";
                default -> throw new IllegalStateException("Unexpected value: " + numberList.get(0));
            };
            result.add(third);
        }
        System.out.println(result);
    }
}
