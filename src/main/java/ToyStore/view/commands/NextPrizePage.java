package ToyStore.view.commands;

import ToyStore.view.Performing;

public class NextPrizePage implements Command{
    private Performing performing;

    public NextPrizePage(Performing performing){
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.getNextPrizePage();
    }

    @Override
    public String toString() {
        return "следующая игрушка";
    }
}
