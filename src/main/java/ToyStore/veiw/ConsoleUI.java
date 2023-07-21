package ToyStore.veiw;

import ToyStore.presenter.Presenter;

import java.util.Scanner;

public class ConsoleUI implements View{

    private final Presenter presenter;
    private final Scanner scanner;
    private boolean isWork;
    private final MainMenu mainMenu;



    public ConsoleUI() {
        isWork = true;
        presenter = new Presenter();
        scanner = new Scanner(System.in);
        mainMenu = new MainMenu(this);
    }

    @Override
    public void print(String text) {
        System.out.println(text);
    }

    @Override
    public void start() {
        do {
            print(mainMenu.getMenu());
            Integer input =getIntegerInput(1, mainMenu.getSize());
            mainMenu.execute(input);
        } while (isWork);
    }

    private Integer getIntegerInput(int min, int max) {
        do {
            print("> ");
            String input = scanner.nextLine();
            if(input.equals("")) {
                return null;
            }
            if (input.matches("[0-9]+")) {
                int parsed = Integer.parseInt(input);
                if (parsed >= min && parsed <= max)
                    return parsed;
            }
        } while (true);
    }

    public void save() {
        presenter.save();
    }
    public void quit() {
        isWork = false;
    }
}
