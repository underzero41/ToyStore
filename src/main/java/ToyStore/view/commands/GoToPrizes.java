package ToyStore.view.commands;

import ToyStore.view.Performing;

public class GoToPrizes implements Command{
    private Performing performing;

    public GoToPrizes(Performing performing) {
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.goToPrize();
    }

    @Override
    public String toString() {
        return "к моим призам";
    }
}
