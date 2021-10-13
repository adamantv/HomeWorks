package price;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    /**
     * Исходное число делится на список порядков (сегментов) для дальнейшего преобразования
     * Например: 5001 -> [5, 1]
     *
     * @param number - исходное число
     * @return - список порядков числа
     */
    public List<Long> getSegments(long number) {
        List<Long> segments = new ArrayList<>();
        while (number > 999) {
            long seg = number / 1000;
            segments.add(number - (seg * 1000));
            number = seg;
        }
        segments.add(number);
        Collections.reverse(segments);
        System.out.println(segments);
        return segments;
    }

    public String analyzeHundred(int hundred) {
        return switch (hundred) {
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
            default -> throw new IllegalStateException("Unexpected value: " + hundred);
        };
    }

    public String analyzeDecimal(int decimal, int unit) {
        return switch (decimal) {
            case 0 -> "";
            case 1 -> getValue(unit); //вызов метода
            case 2 -> "двадцать";
            case 3 -> "тридцать";
            case 4 -> "сорок";
            case 5 -> "пятьдесят";
            case 6 -> "шестьдесят";
            case 7 -> "семьдесят";
            case 8 -> "восемьдесят";
            case 9 -> "девяносто";
            default -> throw new IllegalStateException("Unexpected value: " + decimal);
        };
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

    public String analyzeUnit(int unit) {
        return switch (unit) {
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
            default -> throw new IllegalStateException("Unexpected value: " + unit);
        };
    }

    public int getHundred(long number) {
        return (int) (number / 100); //число сотен
    }

    public int getDecimal(long number) {
        return (int) (number % 100 / 10); //число десятков
    }

    public int getUnit(long number) {
        return (int) (number % 10); //число единиц
    }

    public String analyzeWord(int size) {
        return switch (size) {
            case 1 -> "рублей";
            case 2 -> "тысяч";
            case 3 -> "миллионов";
            case 4 -> "миллиардов";
            default -> throw new IllegalStateException("Недопустимый формат числа: " + size);
        };
    }

}
