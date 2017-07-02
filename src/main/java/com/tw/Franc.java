package com.tw;

public class Franc extends Money {

    private String currency;

    Franc(int amount) {
        super(amount);
        currency = "CHF";
    }

    String getAccount() {
        return currency;
    }

    Franc plus(Franc addend) {
        return new Franc(this.amount + addend.amount);
    }

    Franc times(int multiplier) {
        return new Franc(this.amount * multiplier);
    }


    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Franc) {
            Franc franc = (Franc) obj;
            return franc.amount == this.amount;
        }
        return false;
    }


}
