package command.step3.command.fan;

import command.step3.command.Command;
import command.step3.receiver.fan.CeilingFan;
import command.step3.receiver.fan.Fan;

public class CeilingFanOnCommand implements Command {
    private final CeilingFan ceilingFan;

    public CeilingFanOnCommand(CeilingFan fan){
        this.ceilingFan = fan;
    }

    @Override
    public void execute() {
        ceilingFan.on();
    }

    @Override
    public void undo() {
        ceilingFan.off();
    }
}
