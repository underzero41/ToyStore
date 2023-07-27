package ToyStore.view.commands;

import ToyStore.view.Performing;

public class Quit implements Command{
    private Performing performing;

    public Quit(Performing performing) {
        this.performing = performing;
    }

    @Override
    public void execute() {
        performing.Quit();
    }

    @Override
    public String toString() {
        return "выход";
    }
}
