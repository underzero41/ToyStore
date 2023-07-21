package ToyStore.veiw.commands;

import ToyStore.veiw.ConsoleUI;

public class CommandQuit implements Command{

    private final ConsoleUI ui;
    public CommandQuit(ConsoleUI ui){
        this.ui = ui;
    }
    @Override
    public String getDescription() {
        return "Выход";
    }

    @Override
    public void execute() {
        ui.quit();
    }
}
