package command.step2.command.light;

import command.step2.command.Command;
import command.step2.receiver.light.Light;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }
}
