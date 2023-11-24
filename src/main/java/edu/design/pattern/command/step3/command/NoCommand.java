package edu.design.pattern.command.step3.command;

public class NoCommand implements Command {

    private static final NoCommand INSTANCE = new NoCommand();
    private NoCommand(){
    }

    public static NoCommand getInstance(){
        return INSTANCE;
    }

    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
