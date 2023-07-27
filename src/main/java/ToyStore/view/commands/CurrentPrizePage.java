package ToyStore.view.commands;

import ToyStore.view.Performing;

public class CurrentPrizePage implements Command{
    private Performing performing;

    public CurrentPrizePage(Performing performing){
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.getCurrentPrizePage();
    }

    @Override
    public String toString() {
        return "обновить страницу";
    }
}
