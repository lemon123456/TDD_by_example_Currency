package com.tw;

public class Pair {
    private final String from;
    private final String to;

    public Pair(Currency fromCurrency, Currency toCurrency) {
        this.from =  fromCurrency.name();
        this.to = toCurrency.name();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;

        Pair pair = (Pair) object;

        if (from != null ? !from.equals(pair.from) : pair.from != null) return false;
        return to != null ? to.equals(pair.to) : pair.to == null;
    }

    @Override
    public int hashCode() {
        int result = from != null ? from.hashCode() : 0;
        result = 31 * result + (to != null ? to.hashCode() : 0);
        return result;
    }
}
