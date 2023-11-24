package edu.design.pattern.command.step3.command.fan;

import edu.design.pattern.command.step3.command.Command;
import edu.design.pattern.command.step3.receiver.fan.CeilingFan;
import edu.design.pattern.command.step3.receiver.fan.Fan;

public class CeilingFanHighCommand implements Command {
    private final CeilingFan ceilingFan;
    private Fan.FanSpeed prevSpeed;
    private Fan.FanStatus prevStatus;

    public CeilingFanHighCommand(CeilingFan fan){
        this.ceilingFan = fan;
    }

    @Override
    public void execute() {
        prevSpeed = ceilingFan.getSpeed();
        prevStatus = ceilingFan.getStatus();

        if(prevStatus == Fan.FanStatus.OFF){
            ceilingFan.on();
        }
        ceilingFan.setSpeed(Fan.FanSpeed.HIGH);
    }

    @Override
    public void undo() {
        ceilingFan.setSpeed(prevSpeed);

        if(prevStatus == Fan.FanStatus.OFF){
            ceilingFan.off();
        }

        prevStatus = Fan.FanStatus.ON;
        prevSpeed = Fan.FanSpeed.HIGH;
    }
}
