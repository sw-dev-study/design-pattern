package command.step3.command;

import java.util.List;

public class MacroCommand implements Command{
    private final List<Command> commandList;

    public MacroCommand(List<Command> commandList){
        this.commandList = commandList;
    }

    @Override
    public void execute() {
        commandList.forEach(Command::execute);
    }

    @Override
    public void undo() {
        commandList.forEach(Command::undo);
    }
}
