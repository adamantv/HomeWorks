package price.main.service;

import price.main.enums.Digit;

/**
 * may be use for different currencies
 */
public interface CurrencyService {
    String getSingleCurrencyNominative(Digit digit);

    String getSingleCurrencyDative(Digit digit);

    String getMultipleCurrency(Digit digit);
}
