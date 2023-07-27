package ToyStore;

import ToyStore.view.ConsoleView;
import ToyStore.view.View;

public class Main{
    public static void main(String[] args) {
        View view = new ConsoleView();
        view.start();
    }
}
