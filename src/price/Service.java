package price;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service {
    private final static List<Integer> n1 = Arrays.asList(0, 5, 6, 7, 8, 9);
    private final static List<Integer> n2 = Arrays.asList(2, 3, 4);

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
        System.out.println(segments);
        return segments;
    }

    public String calculateHundred(long number) {
        int hundred = getHundred(number);
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

    public String calculateDecimal(long number) {
        int decimal = getDecimal(number);
        return switch (decimal) {
            case 0 -> "";
            case 1 -> calculateDecimalWithUnit(getUnit(number)); //вызов метода
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

    public String calculateDecimalWithUnit(int unit) {
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

    public String calculateUnit(long originNumber, long number, boolean isMale) {
        int unit = getUnit(number);
        int decimal = getDecimal(number);
        if (decimal != 1) {
            return switch (unit) {
                case 0 -> (originNumber == 0L) ? "ноль" : "";
                case 1 -> isMale ? "один" : "одна";
                case 2 -> isMale ? "два" : "две";
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

    public int getHundred(long number) {
        return (int) (number / 100); //число сотен
    }

    public int getDecimal(long number) {
        return (int) (number % 100 / 10); //число десятков
    }

    public int getUnit(long number) {
        return (int) (number % 10); //число единиц
    }

    public String analyzeWordPluralN1(Digit digit) {
        return switch (digit.name()) {
            case "CURRENCY" -> "рублей";
            case "THOUSAND" -> "тысяч";
            case "MILLION" -> "миллионов";
            case "BILLION" -> "миллиардов";
            default -> throw new IllegalStateException("Недопустимый порядок числа: " + digit);
        };
    }

    public String analyzeSingleWord(Digit digit) {
        return switch (digit.name()) {
            case "CURRENCY" -> "рубль";
            case "THOUSAND" -> "тысяча";
            case "MILLION" -> "миллион";
            case "BILLION" -> "миллиард";
            default -> throw new IllegalStateException("Недопустимый порядок числа: " + digit);
        };
    }

    public String analyzeWordPluralN2(Digit digit) {
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

    public String getWord(long number, Digit digit) {
        int unit = getUnit(number);
        int decimal = getDecimal(number);
        if (number == 0 && !digit.equals(Digit.CURRENCY)) {
            return "";
        } else if (unit == 1 && decimal != 1) {
            return analyzeSingleWord(digit);
        } else if (n1.contains(unit) || decimal == 1) {
            return analyzeWordPluralN1(digit);
        } else if (n2.contains(unit)) {
            return analyzeWordPluralN2(digit);
        } else {
            throw new IllegalStateException("Недопустимый формат числа: " + digit);
        }
    }

    public Digit transformDigit(int digit) {
        return switch (digit) {
            case 1 -> Digit.CURRENCY;
            case 2 -> Digit.THOUSAND;
            case 3 -> Digit.MILLION;
            case 4 -> Digit.BILLION;
            default -> throw new IllegalStateException("Недопустимый разряд числа: " + digit);
        };
    }
}
