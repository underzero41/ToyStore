package ToyStore.model.storages.repo;

import ToyStore.model.items.Item;
import ToyStore.model.storages.Storage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BinDB<T extends Storage<Item>> implements DB<T> {
    private final String PATH = "storage.data";

    @Override
    public void save(Storage<Item> storage) {
        try {
            FileOutputStream fos = new FileOutputStream(PATH);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(storage);
            fos.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public Storage<Item> load() {

        try {
            FileInputStream fis = new FileInputStream(PATH);
            ObjectInputStream ois = new ObjectInputStream(fis);
            Storage<Item> storage = (Storage<Item>) ois.readObject();
            fis.close();
            return storage;
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

}
