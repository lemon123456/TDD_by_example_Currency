package com.tw;

public class Dollar {
    private int amount;

    public Dollar(int amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object obj) {
        return this.amount == ((Dollar) obj).amount;
    }

    public Dollar multiply(int multiplier) {
        return new Dollar(amount * multiplier);
    }
}
