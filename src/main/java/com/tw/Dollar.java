package com.tw;

public class Dollar {
    private int amount;

    Dollar(int amount) {
        this.amount = amount;
    }

    Dollar times(int multiplier) {
        return new Dollar(this.amount * multiplier);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Dollar) {
            Dollar dollar = (Dollar) obj;
            return this.amount == dollar.amount;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return this.amount;
    }

    public Dollar plus(Dollar addend) {
        return new Dollar(this.amount + addend.amount);
    }
}
