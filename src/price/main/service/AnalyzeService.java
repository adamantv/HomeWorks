package price.main.service;

import price.main.entity.Number;
import price.main.enums.Digit;

import java.util.Arrays;
import java.util.List;

public class AnalyzeService {
    private final CurrencyService currencyService;
    private final static List<Integer> numbersForMultiple = Arrays.asList(0, 5, 6, 7, 8, 9);
    private final static List<Integer> numbersForDative = Arrays.asList(2, 3, 4);

    public AnalyzeService() {
        this.currencyService = new RubleService();
    }

    public String getHundredWord(Number number) {
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

    public String getDecimalWordByNumber(Number number) {
        return switch (number.getDecimal()) {
            case 0 -> "";
            case 1 -> getDecimalWordByUnit(number.getUnit()); //вызов метода
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

    public String getDecimalWordByUnit(int unit) {
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

    public String getUnitWord(Number number, long originValue) {
        if (number.getDecimal() != 1) {
            return switch (number.getUnit()) {
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
                default -> throw new IllegalStateException("Unexpected value: " + number.getUnit());
            };
        } else {
            return "";
        }
    }

    public String getDigitWord(Number number) {
        if (number.getValue() == 0 && !number.getDigit().equals(Digit.CURRENCY)) {
            return "";
        } else if (number.getUnit() == 1 && number.getDecimal() != 1) {
            return currencyService.getSingleCurrencyNominative(number.getDigit());
        } else if (numbersForMultiple.contains(number.getUnit()) || number.getDecimal() == 1) {
            return currencyService.getMultipleCurrency(number.getDigit());
        } else if (numbersForDative.contains(number.getUnit())) {
            return currencyService.getSingleCurrencyDative(number.getDigit());
        } else {
            throw new IllegalStateException("Недопустимый формат числа: " + number);
        }
    }
}
