package ToyStore.view.commands;

import ToyStore.view.Performing;

public class RemoveFromPrizes implements Command{
    private Performing performing;

    public RemoveFromPrizes(Performing performing) {
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.removeFromPrize();
    }

    @Override
    public String toString() {
        return "удалить из призов";
    }
}
