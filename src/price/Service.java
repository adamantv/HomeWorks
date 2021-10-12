package price;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Service {
    public Integer getInputNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                String inputString = reader.readLine();
                int inputNumber = Integer.parseInt(inputString);
                if (inputNumber > 0) {
                    return inputNumber;
                } else {
                    System.out.println("Проверьте корректность вводимых данных. \n" +
                            "Необходимо использовать положительные числа.");
                }
            } catch (Exception e) {
                System.out.println("Проверьте корректность вводимых данных. \n" +
                        "Необходимо использовать числа.");
                e.printStackTrace();
                break;
            }
        }
        return null;
    }

    public int getLastChat(int number) {
        return number % 10;
    }

    public ArrayList<Integer> getNumberList(int number) {
        int temp = number;
        ArrayList<Integer> array = new ArrayList<Integer>();
        do {
            array.add(temp % 10);
            temp /= 10;
        } while (temp > 0);
        Collections.reverse(array);
        return array;
    }

    public String getValue(int num) {
        return switch (num) {
            case 0 -> "десять";
            case 1 -> "одиннадцать";
            case 2 -> "двенадцать";
            case 3 -> "тринадцать";
            case 4 -> "четырнадцать";
            case 5 -> "пятнадцать";
            case 6 -> "шестнадцать";
            case 7 -> "семнадцать";
            case 8 -> "восемнадцать";
            case 9 -> "девятнадцать";
            default -> throw new IllegalStateException("Unexpected value: " + num);
        };
    }

}
