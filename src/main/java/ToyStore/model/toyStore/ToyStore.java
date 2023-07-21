package ToyStore.model.toyStore;

import ToyStore.model.toy.Item;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class ToyStore<T extends Item> implements Serializable, Iterable<T> {
    private final List<T> store;

    public ToyStore() {
        store = new ArrayList<>();
    }
    public void addToy(T toy){
        store.add(toy);
    }

    public void updateWeight(int id, int weight){
        for(T toy: store){
            if (toy.getId() == id){
                toy.setWeight(weight);
                break;
            }
        }
    }

    public T choosePrizeToy(){
        int totalWeight = 0;
        for(T toy: store){
            totalWeight += toy.getWeight();
        }
        Random random =new Random();
        int randomNumber = random.nextInt(totalWeight) + 1;
        int accumulatedWeight = 0;

        for (T toy: store){
            accumulatedWeight += toy.getWeight();
            if (randomNumber <= accumulatedWeight){
                toy.setQuantity(toy.getQuantity() - 1);
                return toy;
            }
        }
        return null;
    }

    public void distributePrizeToy(){
        T prizeToy = choosePrizeToy();
        if (prizeToy != null){
            store.remove(prizeToy);
            try(BufferedWriter writer = new BufferedWriter(new FileWriter("prize_toys.txt", true))){
                writer.write(prizeToy.getId() + "," + prizeToy.getName());
                writer.newLine();
            } catch (IOException e) {
                System.out.println("Failed to write file");
            }
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StoreIterator<>(store);
    }
}
