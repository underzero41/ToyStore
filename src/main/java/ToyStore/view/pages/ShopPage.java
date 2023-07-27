package ToyStore.view.pages;

import ToyStore.view.Performing;
import ToyStore.view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class ShopPage implements Page{
    private final List<Command> commands;

    public ShopPage(Performing performing){
        commands = new ArrayList<>();
        commands.add(new PreviousShopPage(performing));
        commands.add(new NextShopPage(performing));
        commands.add(new AddToPrizes(performing));
        commands.add(new GoToPrizes(performing));
        commands.add(new GetNewProducts(performing));
        commands.add(new Quit(performing));
    }

    public void execute(int index){
        if(index >= 0 && index < commands.size()){
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

    public int size() {
        return commands.size();
    }
}
