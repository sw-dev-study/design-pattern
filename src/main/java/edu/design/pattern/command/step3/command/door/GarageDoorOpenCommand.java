package edu.design.pattern.command.step3.command.door;

import edu.design.pattern.command.step3.command.Command;
import edu.design.pattern.command.step3.receiver.door.GarageDoor;

public class GarageDoorOpenCommand implements Command {
    private final GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.lightOn();
        garageDoor.up();
        garageDoor.stop();
    }

    @Override
    public void undo() {
        garageDoor.lightOff();
        garageDoor.down();
        garageDoor.stop();
    }
}