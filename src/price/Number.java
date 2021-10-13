package price;

import java.util.Objects;

public class Number {
    private long value;
    private int hundred;
    private int decimal;
    private int unit;
    private boolean isMale;
    private Digit digit;

    public Number(long value) {
        this.value = value;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }

    public int getHundred() {
        return hundred;
    }

    public void setHundred(int hundred) {
        this.hundred = hundred;
    }

    public int getDecimal() {
        return decimal;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public int getUnit() {
        return unit;
    }

    public void setUnit(int unit) {
        this.unit = unit;
    }

    public boolean isMale() {
        return isMale;
    }

    public void setMale(boolean male) {
        isMale = male;
    }

    public Digit getDigit() {
        return digit;
    }

    public void setDigit(Digit digit) {
        this.digit = digit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Number)) return false;
        Number number = (Number) o;
        return getValue() == number.getValue() && getHundred() == number.getHundred() && getDecimal() == number.getDecimal() && getUnit() == number.getUnit() && isMale() == number.isMale() && getDigit() == number.getDigit();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getValue(), getHundred(), getDecimal(), getUnit(), isMale(), getDigit());
    }

    @Override
    public String toString() {
        return "Number{" +
                "value=" + value +
                ", hundred=" + hundred +
                ", decimal=" + decimal +
                ", unit=" + unit +
                ", isMale=" + isMale +
                ", digit=" + digit +
                '}';
    }
}
