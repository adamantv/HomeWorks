package price.main.service;

import price.main.entity.Number;
import price.main.enums.Digit;

import java.util.ArrayList;
import java.util.List;

public class CalculateService {//todo need to rename

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

    public int calculateHundred(long number) {
        return (int) (number / 100); //число сотен
    }

    public int calculateDecimal(long number) {
        return (int) (number % 100 / 10); //число десятков
    }

    public int calculateUnit(long number) {
        return (int) (number % 10); //число единиц
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

    public boolean analyzeSex(Digit digit) {
        return switch (digit.name()) {
            case "CURRENCY", "MILLION", "BILLION" -> true;
            case "THOUSAND" -> false;
            default -> throw new IllegalStateException("Недопустимый порядок числа: " + digit);
        };
    }
}
