package edu.design.pattern.command.step3.command.fan;

import edu.design.pattern.command.step3.command.Command;
import edu.design.pattern.command.step3.receiver.fan.CeilingFan;

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
