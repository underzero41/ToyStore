package ToyStore.model.toyStore;

import ToyStore.model.toy.Item;

import java.util.Iterator;
import java.util.List;

public class StoreIterator<T extends Item> implements Iterator<T> {
    private int index = 0;
    private final List<T> store;
    public StoreIterator(List<T> store){
        this.store = store;
    }
    @Override
    public boolean hasNext() {
        return index < store.size() && store.get(index) != null;
    }

    @Override
    public T next() {
        return store.get(index++);
    }
}
