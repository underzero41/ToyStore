package ToyStore.view.commands;

import ToyStore.view.Performing;

public class GetNewProducts implements Command{
    private Performing performing;

    public GetNewProducts(Performing performing){
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.getNewProducts();
    }

    @Override
    public String toString() {
        return "добавить новую игрушку";
    }
}
