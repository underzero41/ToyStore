package ToyStore.model.toy;

public interface Item {
    int getId();
    String getName();

    int getWeight();
    int getQuantity();
    void setWeight(int weight);
    void setQuantity(int quantity);
}
