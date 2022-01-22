package price.main.service;

import price.main.enums.Digit;

/**
 * Interface may be use for different currencies
 */
public interface CurrencyService {
    String getSingleCurrencyNominative(Digit digit);

    String getSingleCurrencyDative(Digit digit);

    String getPluralCurrency(Digit digit);
}
