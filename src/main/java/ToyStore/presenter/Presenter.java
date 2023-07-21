package ToyStore.presenter;

import ToyStore.model.Service;
import ToyStore.model.repository.FileHandler;

public class Presenter {
    private Service service;
    public Presenter(){
        service = new Service(new FileHandler("/Users/kondratyev/Desktop/MyProjects/ToyStore2.0/ToyStore/src/main/java/ToyStore/toys.txt"));
    }
    public void save(){
        service.save();
    }
}
