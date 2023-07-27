package ToyStore.model.items;

import ToyStore.model.products.Product;
import ToyStore.model.products.Tag;

import java.util.Map;

public interface ProductItem {
    String id();
    Product product();
    Integer amount();
    void increaseAmount();
    void decreaseAmount();
    double getLuck();
    void setLuck(double discount);
    double getPrice(boolean enableDiscount);
    double getTotalPrice(boolean enableDiscount);
    boolean isTagged(Tag tag);
    Map<String, String> result();
    Map<String, String> detail();
}
