package ToyStore.view.commands;

import ToyStore.view.Performing;

public class GoToShop implements Command{
    private Performing performing;

    public GoToShop(Performing performing) {
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.goToShop();
    }

    @Override
    public String toString() {
        return "к магазину";
    }
}
