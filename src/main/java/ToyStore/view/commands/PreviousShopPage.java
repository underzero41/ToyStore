package ToyStore.view.commands;

import ToyStore.view.Performing;

public class PreviousShopPage implements Command{
    private Performing performing;

    public PreviousShopPage(Performing performing) {
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.getPreviousShopPage();
    }

    @Override
    public String toString() {
        return "предыдущая игрушка";
    }
}
