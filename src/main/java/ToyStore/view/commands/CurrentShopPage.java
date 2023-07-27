package ToyStore.view.commands;

import ToyStore.view.Performing;

public class CurrentShopPage implements Command{
    private Performing performing;

    public CurrentShopPage(Performing performing){
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.getCurrentShopPage();
    }

    @Override
    public String toString() {
        return "обновить страницу";
    }
}
