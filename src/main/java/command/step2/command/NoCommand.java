package command.step2.command;

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
}
