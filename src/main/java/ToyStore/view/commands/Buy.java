package ToyStore.view.commands;

import ToyStore.view.Performing;

public class Buy implements Command{
    private Performing performing;

    public Buy(Performing performing){
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.buy();
    }

    @Override
    public String toString() {
        return "купить";
    }
}
