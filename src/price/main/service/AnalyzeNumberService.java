package price.main.service;

import price.main.entity.NumberEntity;
import price.main.enums.Digit;

import java.util.Arrays;
import java.util.List;

/**
 * Service for analyze numbers and transform it to words
 */
public class AnalyzeNumberService {
    private final CurrencyService currencyService;
    private final static List<Integer> numbersForMultiple = Arrays.asList(0, 5, 6, 7, 8, 9);
    private final static List<Integer> numbersForDative = Arrays.asList(2, 3, 4);

    public AnalyzeNumberService() {
        this.currencyService = new RubleService();
    }

    /**
     * @param numberEntity number for analyze
     * @return hundred in word format
     */
    private String getHundredWord(NumberEntity numberEntity) {
        return switch (numberEntity.getHundred()) {
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
            default -> throw new IllegalStateException("Unexpected value: " + numberEntity.getHundred());
        };
    }

    /**
     * @param numberEntity number for analyze
     * @return decimal in word format
     */
    private String getDecimalWordByNumber(NumberEntity numberEntity) {
        return switch (numberEntity.getDecimal()) {
            case 0 -> "";
            case 1 -> getDecimalWordByUnit(numberEntity.getUnit());
            case 2 -> "двадцать";
            case 3 -> "тридцать";
            case 4 -> "сорок";
            case 5 -> "пятьдесят";
            case 6 -> "шестьдесят";
            case 7 -> "семьдесят";
            case 8 -> "восемьдесят";
            case 9 -> "девяносто";
            default -> throw new IllegalStateException("Unexpected value: " + numberEntity.getDecimal());
        };
    }

    /**
     * Method for analyze number if decimal == 1
     *
     * @param unit number for analyze
     * @return result value
     */
    private String getDecimalWordByUnit(int unit) {
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

    /**
     * @param numberEntity number for analyze
     * @return unit in word format
     */
    private String getUnitWord(NumberEntity numberEntity, long originValue) {
        if (numberEntity.getDecimal() != 1) {
            return switch (numberEntity.getUnit()) {
                case 0 -> (originValue == 0L) ? "ноль" : "";
                case 1 -> numberEntity.isMale() ? "один" : "одна";
                case 2 -> numberEntity.isMale() ? "два" : "две";
                case 3 -> "три";
                case 4 -> "четыре";
                case 5 -> "пять";
                case 6 -> "шесть";
                case 7 -> "семь";
                case 8 -> "восемь";
                case 9 -> "девять";
                default -> throw new IllegalStateException("Unexpected value: " + numberEntity.getUnit());
            };
        } else {
            return "";
        }
    }

    /**
     * Method for getting word by the digit
     *
     * @param numberEntity number for analyze
     * @return digit in word format
     */
    private String getDigitWord(NumberEntity numberEntity) {
        if (numberEntity.getValue() == 0 && !numberEntity.getDigit().equals(Digit.CURRENCY)) {
            return "";
        } else if (numberEntity.getUnit() == 1 && numberEntity.getDecimal() != 1) {
            return currencyService.getSingleCurrencyNominative(numberEntity.getDigit());
        } else if (numbersForMultiple.contains(numberEntity.getUnit()) || numberEntity.getDecimal() == 1) {
            return currencyService.getPluralCurrency(numberEntity.getDigit());
        } else if (numbersForDative.contains(numberEntity.getUnit())) {
            return currencyService.getSingleCurrencyDative(numberEntity.getDigit());
        } else {
            throw new IllegalStateException("Недопустимый формат числа: " + numberEntity);
        }
    }

    /**
     * Method for getting word for one order
     */
    public String getFinalWord(NumberEntity numberEntity, long originValue) {
        String hundredWord = getHundredWord(numberEntity);
        String decimalWord = getDecimalWordByNumber(numberEntity);
        String unitWord = getUnitWord(numberEntity, originValue);
        String digitWord = getDigitWord(numberEntity);
        List<String> words = Arrays.asList(hundredWord, decimalWord, unitWord, digitWord);
        return String.join(" ", words).trim().replaceAll(" +", " ");
    }
}
