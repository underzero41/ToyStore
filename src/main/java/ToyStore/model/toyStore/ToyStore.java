package ToyStore.model.toyStore;

import ToyStore.model.toy.Item;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ToyStore<T extends Item> implements Serializable, Iterable<T> {
    private final List<T> store;

    public ToyStore() {
        store = new ArrayList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return new StoreIterator<>(store);
    }
}
