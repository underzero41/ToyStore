package ToyStore;

import ToyStore.veiw.ConsoleUI;
import ToyStore.veiw.View;

import java.io.Serializable;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main implements Serializable {
    public static void main(String[] args) {
        View view = new ConsoleUI();
        view.start();
    }
}