package price.main.service;

import price.main.entity.Number;
import price.main.enums.Digit;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {//todo need to rename
    private final static List<Integer> n1 = Arrays.asList(0, 5, 6, 7, 8, 9); //todo need to rename
    private final static List<Integer> n2 = Arrays.asList(2, 3, 4); //todo need to rename

    public Integer getInputNumber() { //todo need to use
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
     * @param originNumber - исходное число
     * @return - список порядков числа
     */
    public List<Long> getSegments(long originNumber) {
        List<Long> segments = new ArrayList<>();
        while (originNumber > 999) {
            long seg = originNumber / 1000;
            segments.add(originNumber - (seg * 1000));
            originNumber = seg;
        }
        segments.add(originNumber);
        System.out.println(segments);
        return segments;
    }


    public List<Number> getNumbers(List<Long> segments) {
        List<Number> numbers = new ArrayList<>();
        //обход списка в обратном порядке для получения корректного порядка
        for (int i = segments.size() - 1; i >= 0; i--) {
            Number number = new Number(segments.get(i));
            number.setHundred(calculateHundred(segments.get(i)));
            number.setDecimal(calculateDecimal(segments.get(i)));
            number.setUnit(calculateUnit(segments.get(i)));
            Digit digit = transformDigit(i);
            number.setDigit(digit);
            number.setMale(analyzeSex(digit));
            numbers.add(number);
        }
        return numbers;
    }

    public String analyzeHundred(Number number) {
        return switch (number.getHundred()) {
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
            default -> throw new IllegalStateException("Unexpected value: " + number.getHundred());
        };
    }

    public String analyzeDecimal(Number number) {
        return switch (number.getDecimal()) {
            case 0 -> "";
            case 1 -> analyzeDecimalWithUnit(number.getUnit()); //вызов метода
            case 2 -> "двадцать";
            case 3 -> "тридцать";
            case 4 -> "сорок";
            case 5 -> "пятьдесят";
            case 6 -> "шестьдесят";
            case 7 -> "семьдесят";
            case 8 -> "восемьдесят";
            case 9 -> "девяносто";
            default -> throw new IllegalStateException("Unexpected value: " + number.getDecimal());
        };
    }

    public String analyzeDecimalWithUnit(int unit) {
        return switch (unit) {
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
            default -> throw new IllegalStateException("Unexpected value: " + unit);
        };
    }

    public String analyzeUnit(Number number, long originValue) {
        int unit = calculateUnit(number.getUnit());
        int decimal = calculateDecimal(number.getDecimal());
        if (decimal != 1) {
            return switch (unit) {
                case 0 -> (originValue == 0L) ? "ноль" : "";
                case 1 -> number.isMale() ? "один" : "одна";
                case 2 -> number.isMale() ? "два" : "две";
                case 3 -> "три";
                case 4 -> "четыре";
                case 5 -> "пять";
                case 6 -> "шесть";
                case 7 -> "семь";
                case 8 -> "восемь";
                case 9 -> "девять";
                default -> throw new IllegalStateException("Unexpected value: " + unit);
            };
        } else {
            return "";
        }
    }

    public int calculateHundred(long number) {
        return (int) (number / 100); //число сотен
    }

    public int calculateDecimal(long number) {
        return (int) (number % 100 / 10); //число десятков
    }

    public int calculateUnit(long number) {
        return (int) (number % 10); //число единиц
    }

    public String analyzeWordPluralN1(Digit digit) {//todo need to rename
        return switch (digit.name()) {
            case "CURRENCY" -> "рублей";
            case "THOUSAND" -> "тысяч";
            case "MILLION" -> "миллионов";
            case "BILLION" -> "миллиардов";
            default -> throw new IllegalStateException("Недопустимый порядок числа: " + digit);
        };
    }

    public String analyzeSingleWord(Digit digit) {//todo need to rename
        return switch (digit.name()) {
            case "CURRENCY" -> "рубль";
            case "THOUSAND" -> "тысяча";
            case "MILLION" -> "миллион";
            case "BILLION" -> "миллиард";
            default -> throw new IllegalStateException("Недопустимый порядок числа: " + digit);
        };
    }

    public String analyzeWordPluralN2(Digit digit) {//todo need to rename
        return switch (digit.name()) {
            case "CURRENCY" -> "рубля";
            case "THOUSAND" -> "тысячи";
            case "MILLION" -> "миллиона";
            case "BILLION" -> "миллиарда";
            default -> throw new IllegalStateException("Недопустимый порядок числа: " + digit);
        };
    }

    public boolean analyzeSex(Digit digit) {
        return switch (digit.name()) {
            case "CURRENCY", "MILLION", "BILLION" -> true;
            case "THOUSAND" -> false;
            default -> throw new IllegalStateException("Недопустимый порядок числа: " + digit);
        };
    }

    public String getWord(Number number) {
        if (number.getValue() == 0 && !number.getDigit().equals(Digit.CURRENCY)) {
            return "";
        } else if (number.getUnit() == 1 && number.getDecimal() != 1) {
            return analyzeSingleWord(number.getDigit());
        } else if (n1.contains(number.getUnit()) || number.getDecimal() == 1) {
            return analyzeWordPluralN1(number.getDigit());
        } else if (n2.contains(number.getUnit())) {
            return analyzeWordPluralN2(number.getDigit());
        } else {
            throw new IllegalStateException("Недопустимый формат числа: " + number);
        }
    }

    public Digit transformDigit(int digit) {
        return switch (digit) {
            case 0 -> Digit.CURRENCY;
            case 1 -> Digit.THOUSAND;
            case 2 -> Digit.MILLION;
            case 3 -> Digit.BILLION;
            default -> throw new IllegalStateException("Недопустимый разряд числа: " + digit);
        };
    }
}
