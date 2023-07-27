package ToyStore.view.pages;

import ToyStore.view.Performing;
import ToyStore.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class PrizePage implements Page{
    private List<Command> commands;

    public PrizePage(Performing performing){
        commands = new ArrayList<>();
        commands.add(new PreviousPrizePage(performing));
        commands.add(new NextPrizePage(performing));
        commands.add(new RemoveFromPrizes(performing));
        commands.add(new GoToShop(performing));
        commands.add(new Buy(performing));
        commands.add(new Quit(performing));
    }

    public void execute(int index) {
        if (index >= 0 && index < commands.size()) {
            commands.get(index).execute();
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int index = 1;
        for (Command command : commands) {
            builder.append(index++).append(". ").append(command.toString()).append("\r\n");
        }
        return builder.toString();
    }

    @Override
    public int size() {
        return commands.size();
    }
}
