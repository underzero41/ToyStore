package ToyStore;

public enum Keys {
    PRICE("price"),
    PRICE_TOTAL("price_total"),
    LUCK("luck"),
    PRIZE_TOTAL("special_total"),
    AMOUNT("amount"),
    TOTAL("total"),
    TAGS("tags"),
    WEIGHT("weight"),
    MONEY_FORMAT("$%.2f");
    private final String key;
    Keys(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }
}
