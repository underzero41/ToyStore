package ToyStore.view.commands;

import ToyStore.view.Performing;

public class AddToPrizes implements Command{
    private Performing performing;

    public AddToPrizes(Performing performing){
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.addToPrize();
    }

    @Override
    public String toString() {
        return "испытать удачу";
    }
}
