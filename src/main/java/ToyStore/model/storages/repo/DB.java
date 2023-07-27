package ToyStore.model.storages.repo;

import ToyStore.model.items.Item;
import ToyStore.model.storages.Storage;

public interface DB<T extends Storage<Item>> {
    void save(Storage<Item> storage);
    Storage<Item> load();
}
