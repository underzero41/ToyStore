package ToyStore.model;

import ToyStore.model.toy.Item;

public interface Predicate {
    boolean isEqual(Item item);
}
