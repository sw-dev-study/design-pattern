package edu.design.pattern.command.step2.command.light;

import edu.design.pattern.command.step2.command.Command;
import edu.design.pattern.command.step2.receiver.light.Light;

public class LightOffCommand implements Command {
    private final Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }
}
