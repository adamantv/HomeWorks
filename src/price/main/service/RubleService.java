package price.main.service;

import price.main.enums.Digit;

public class RubleService implements CurrencyService {
    @Override
    public String getSingleCurrencyNominative(Digit digit) {
        return switch (digit.name()) {
            case "CURRENCY" -> "рубль";
            case "THOUSAND" -> "тысяча";
            case "MILLION" -> "миллион";
            case "BILLION" -> "миллиард";
            default -> throw new IllegalStateException("Unacceptable digit for number: " + digit);
        };
    }

    @Override
    public String getSingleCurrencyDative(Digit digit) {
        return switch (digit.name()) {
            case "CURRENCY" -> "рубля";
            case "THOUSAND" -> "тысячи";
            case "MILLION" -> "миллиона";
            case "BILLION" -> "миллиарда";
            default -> throw new IllegalStateException("Unacceptable digit for number: " + digit);
        };
    }

    @Override
    public String getMultipleCurrency(Digit digit) {
        return switch (digit.name()) {
            case "CURRENCY" -> "рублей";
            case "THOUSAND" -> "тысяч";
            case "MILLION" -> "миллионов";
            case "BILLION" -> "миллиардов";
            default -> throw new IllegalStateException("Unacceptable digit for number: " + digit);
        };
    }
}
