package price.main.entity;

import price.main.enums.Digit;

import java.util.Objects;

public class NumberEntity {
    private long value;
    private int hundred = 0;
    private int decimal = 0;
    private int unit = 0;
    private boolean isMale;
    private Digit digit;

    public NumberEntity(long value) {
        this.value = value;
    }

    public NumberEntity(long value, int hundred, int decimal, int unit, boolean isMale, Digit digit) {
        this.value = value;
        this.hundred = hundred;
        this.decimal = decimal;
        this.unit = unit;
        this.isMale = isMale;
        this.digit = digit;
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
        if (!(o instanceof NumberEntity)) return false;
        NumberEntity numberEntity = (NumberEntity) o;
        return getValue() == numberEntity.getValue() && getHundred() == numberEntity.getHundred() && getDecimal() == numberEntity.getDecimal() && getUnit() == numberEntity.getUnit() && isMale() == numberEntity.isMale() && getDigit() == numberEntity.getDigit();
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
