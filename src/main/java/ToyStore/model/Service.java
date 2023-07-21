package ToyStore.model;

import ToyStore.model.repository.FileService;
import ToyStore.model.toy.Toy;
import ToyStore.model.toyStore.ToyStore;


public class Service {
    private ToyStore<Toy> toyStore;
    private final FileService fileService;

    public Service(FileService fileService) {
        this.fileService = fileService;
        toyStore = getToyStore();
    }

    public ToyStore<Toy> getToyStore() {
        if (this.toyStore == null){
            this.toyStore = read();
        }
        if (this.toyStore == null){
            this.toyStore = createToyStore();
        }
        return toyStore;
    }

    public ToyStore<Toy> createToyStore() {
        ToyStore<Toy> toys = new ToyStore<>();
        Toy toy1 = new Toy(1, "Car", 10, 40);
        Toy toy2 = new Toy(2, "Doll", 8, 30);
        Toy toy3 = new Toy(3, "Ball", 15, 20);

        toys.addToy(toy1);
        toys.addToy(toy2);
        toys.addToy(toy3);

        toys.updateWeight(1, 50);
        for (int i =0; i < 5; i++){
            toys.distributePrizeToy();
        }
        return toys;
    }

    private ToyStore<Toy> read() {
        return (ToyStore<Toy>) fileService.read();
    }

    public void save(){
        fileService.save(toyStore);
    }
}
