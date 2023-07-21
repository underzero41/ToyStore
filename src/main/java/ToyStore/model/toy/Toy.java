package ToyStore.model.toy;

import java.io.Serializable;

public class Toy implements Serializable, Item {
    private int id;
    private String name;
    private int quantity;
    private  int weight;

    public Toy(int id, String name, int quantity, int weight) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public void setWeight(int weight) {
       this.weight = this.weight;
    }

    @Override
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getWeight() {
        return weight;
    }
}
