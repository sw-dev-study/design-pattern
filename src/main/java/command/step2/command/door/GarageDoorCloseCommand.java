package command.step2.command.door;

import command.step2.command.Command;
import command.step2.receiver.door.GarageDoor;

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
}