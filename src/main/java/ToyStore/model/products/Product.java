package ToyStore.model.products;

public interface Product {
    String title();
    String tags();
    double price();
    void addTag(Tag tag);
    void removeTag(Tag tag);

    boolean isTagged(Tag tag);
    Tag[] getTagsArray();
}
