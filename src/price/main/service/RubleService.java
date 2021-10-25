package price.main.service;

import price.main.enums.Digit;

/**
 * Service for transform digits to result words for currency "ruble", for different cases
 */
public class RubleService implements CurrencyService {
    @Override
    public String getSingleCurrencyNominative(Digit digit) { //именительный падеж единственное число
        return switch (digit.name()) {
            case "CURRENCY" -> "рубль";
            case "THOUSAND" -> "тысяча";
            case "MILLION" -> "миллион";
            case "BILLION" -> "миллиард";
            default -> throw new IllegalStateException("Unacceptable digit for number during transform digit to word Nominative case: " + digit);
        };
    }

    @Override
    public String getSingleCurrencyDative(Digit digit) { //дательный падеж единственное число
        return switch (digit.name()) {
            case "CURRENCY" -> "рубля";
            case "THOUSAND" -> "тысячи";
            case "MILLION" -> "миллиона";
            case "BILLION" -> "миллиарда";
            default -> throw new IllegalStateException("Unacceptable digit for number during transform digit to word Dative case: " + digit);
        };
    }

    public String getPluralCurrency(Digit digit) { //именительный падеж множественное число
        return switch (digit.name()) {
            case "CURRENCY" -> "рублей";
            case "THOUSAND" -> "тысяч";
            case "MILLION" -> "миллионов";
            case "BILLION" -> "миллиардов";
            default -> throw new IllegalStateException("Invalid digit for a number while converting a digit to a plural word: " + digit);
        };
    }
}
