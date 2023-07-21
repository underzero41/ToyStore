package ToyStore.veiw;

import ToyStore.veiw.commands.Command;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private final List<Command> commands;
    public MainMenu(ConsoleUI ui) {
        commands = new ArrayList<>();
    }
    public String getMenu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commands.size(); i++) {
            stringBuilder.append(i+1);
            stringBuilder.append(". ");
            stringBuilder.append(commands.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        commands.get(choice - 1).execute();
    }

    public int getSize(){
        return  commands.size();
    }
}
