package edu.design.pattern.command.step3.command.door;

import edu.design.pattern.command.step3.command.Command;
import edu.design.pattern.command.step3.receiver.door.GarageDoor;

public class GarageDoorCloseCommand implements Command {
    private final GarageDoor garageDoor;

    public GarageDoorCloseCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    @Override
    public void execute() {
        garageDoor.lightOff();
        garageDoor.down();
        garageDoor.stop();
    }

    @Override
    public void undo() {
        garageDoor.lightOn();
        garageDoor.up();
        garageDoor.stop();
    }
}