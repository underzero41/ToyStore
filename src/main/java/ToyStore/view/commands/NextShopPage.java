package ToyStore.view.commands;

import ToyStore.view.Performing;

public class NextShopPage implements Command{
    private Performing performing;

    public NextShopPage(Performing performing) {
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.getNextShopPage();
    }

    @Override
    public String toString() {
        return "следующая игрушка";
    }
}
