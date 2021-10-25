package price.main.service;

import price.main.entity.NumberEntity;
import price.main.enums.Digit;

import java.util.ArrayList;
import java.util.List;

public class CalculateService {//todo need to rename

    /**
     * The input number is divided into a list of segments for next transformation
     * For example: 5001 -> [5, 1]
     *
     * @param originNumber - input number
     * @return - list of number orders
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


    /**
     * Method transformed segments (number orders) to numbers
     *
     * @param segments - list of number orders
     * @return list of numbers
     */
    public List<NumberEntity> getNumbers(List<Long> segments) {
        List<NumberEntity> numberEntities = new ArrayList<>();
        //обход списка в обратном порядке для получения корректного порядка
        for (int i = segments.size() - 1; i >= 0; i--) {
            NumberEntity numberEntity = new NumberEntity(segments.get(i));
            numberEntity.setHundred(calculateHundred(segments.get(i)));
            numberEntity.setDecimal(calculateDecimal(segments.get(i)));
            numberEntity.setUnit(calculateUnit(segments.get(i)));
            Digit digit = transformDigit(i);
            numberEntity.setDigit(digit);
            numberEntity.setMale(getSex(digit));
            numberEntities.add(numberEntity);
        }
        return numberEntities;
    }

    /**
     * calculate hundred of number
     *
     * @param number - number from list of segments
     * @return hundred value
     */
    public int calculateHundred(long number) {
        return (int) (number / 100); //число сотен
    }

    /**
     * calculate decimal of number
     *
     * @param number - number from list of segments
     * @return decimal value
     */
    public int calculateDecimal(long number) {
        return (int) (number % 100 / 10); //число десятков
    }

    /**
     * calculate unit of number
     *
     * @param number - number from list of segments
     * @return unit value
     */
    public int calculateUnit(long number) {
        return (int) (number % 10); //число единиц
    }

    /**
     * transform number of digit to word
     *
     * @param digit in integer format
     * @return digit in word format
     */
    public Digit transformDigit(int digit) {
        return switch (digit) {
            case 0 -> Digit.CURRENCY;
            case 1 -> Digit.THOUSAND;
            case 2 -> Digit.MILLION;
            case 3 -> Digit.BILLION;
            default -> throw new IllegalStateException("Недопустимый разряд числа: " + digit);
        };
    }

    /**
     * get ses of order by digit. "CURRENCY", "MILLION", "BILLION" - male, "THOUSAND" - female
     *
     * @param digit - digit of number
     * @return true if digit male, else - female
     */
    public boolean getSex(Digit digit) {
        return switch (digit.name()) {
            case "CURRENCY", "MILLION", "BILLION" -> true;
            case "THOUSAND" -> false;
            default -> throw new IllegalStateException("Недопустимый порядок числа: " + digit);
        };
    }
}
