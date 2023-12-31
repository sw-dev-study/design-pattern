package edu.design.pattern.command.step2.command.door;

import edu.design.pattern.command.step2.command.Command;
import edu.design.pattern.command.step2.receiver.door.GarageDoor;

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
}