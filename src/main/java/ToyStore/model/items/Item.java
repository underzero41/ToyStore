package ToyStore.model.items;

import ToyStore.Keys;
import ToyStore.model.products.Product;
import ToyStore.model.products.Tag;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Item implements ProductItem, Serializable {
    private final String id;
    private final Product product;
    private Integer amount;
    private double luck;
    public Item(String id, Product product, int amount, double luck) {
        this.id = id;
        this.product = product;
        this.amount = amount;
        setLuck(luck);
    }
    @Override
    public String id() {
        return this.id;
    }
    @Override
    public Product product() {
        return this.product;
    }
    @Override
    public Integer amount() {
        return this.amount;
    }
    @Override
    public void increaseAmount() {
        this.amount += 1;
    }
    @Override
    public void decreaseAmount() {
        if (this.amount > 0) {
            this.amount -= 1;
        }
    }
    @Override
    public double getLuck() {
        return this.luck;
    }
    @Override
    public void setLuck(double luck) {
        if (luck >= 0 && luck <= 1) {
            this.luck = luck;
        }
    }
    @Override
    public double getPrice(boolean enableluck) {
        double result = product.price();
        if (enableluck) {
            result *= luck;
        }
        return result;
    }
    @Override
    public double getTotalPrice(boolean enableLuck) {
        double result = product.price() * amount;
        if (enableLuck) {
            result *= luck;
        }
        return result;
    }
    @Override
    public boolean isTagged(Tag tag) {
        return product.isTagged(tag);
    }
    @Override
    public Map<String, String> detail() {
        Map<String, String> map = new HashMap<>();
        map.put(Keys.TOTAL.getKey(), this.product.title());
        map.put(Keys.TAGS.getKey(), this.product.tags());
        map.put(Keys.AMOUNT.getKey(), this.amount.toString());
        map.put(Keys.PRICE.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), this.getPrice(false)));
        map.put(Keys.WEIGHT.getKey(), String.format("%.1f%%", (100 - this.luck * 100)));
        map.put(Keys.LUCK.getKey(), String.format(String.format(Keys.MONEY_FORMAT.getKey(), this.getPrice(true))));
        return map;
    }
    @Override
    public Map<String, String> result() {
        Map<String, String> map = new HashMap<>();
        map.put(Keys.TOTAL.getKey(), this.product.title());
        map.put(Keys.PRICE.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), this.getPrice(false)));
        map.put(Keys.PRICE_TOTAL.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), this.getTotalPrice(false)));
        map.put(Keys.LUCK.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), this.getPrice(true)));
        map.put(Keys.PRIZE_TOTAL.getKey(), String.format(Keys.MONEY_FORMAT.getKey(), this.getTotalPrice(true)));
        map.put(Keys.AMOUNT.getKey(), this.amount.toString());
        return map;
    }
}
