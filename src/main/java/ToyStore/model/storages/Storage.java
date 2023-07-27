package ToyStore.model.storages;

import ToyStore.model.items.ProductItem;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Storage<T extends ProductItem> implements Iterable<T>, Serializable {
    private final List<T> items;
    private int index = 0;
    public Storage() {
        items = new ArrayList<>();
    }
    public T getCurrent() {
        if (items.size() == 0) {
            return null;
        }
        if (index < 0) {
            index = items.size() - 1;
        }
        if (index >= items.size()) {
            index = 0;
        }
        return items.get(index);
    }
    public T getNext() {
        index++;
        return getCurrent();
    }
    public T getPrevious() {
        index--;
        return getCurrent();
    }
    public void remove(T item) {
        items.remove(item);
    }
    public void add(T item) {
        if (!items.contains(item)) {
            items.add(item);
        }
    }
    public double priceAll(boolean enableLuck) {
        double price = 0;
        for (ProductItem product : items) {
            price += product.getTotalPrice(enableLuck);
        }
        return price;
    }
    public T getItem(String id) {
        for (T t : items) {
            if (t.id().equals(id)) {
                return t;
            }
        }
        return null;
    }
    public List<Map<String, String>> getList() {

        List<Map<String, String>> list = new ArrayList<>();
        for (T t : items) {
            list.add(t.result());
        }
        return list;
    }
    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
    public void clear() {
        items.clear();
    }
    public ProductItem search(String name) {
        for (T t : items) {
            if (t.product().title().equals(name)) {
                return t;
            }
        }
        return null;
    }
}
