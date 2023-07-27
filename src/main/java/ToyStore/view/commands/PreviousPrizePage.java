package ToyStore.view.commands;

import ToyStore.view.Performing;

public class PreviousPrizePage implements Command{
    private Performing performing;

    public PreviousPrizePage(Performing performing) {
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.getPreviousPrizePage();
    }

    @Override
    public String toString() {
        return "предыдущая игрушка";
    }
}
