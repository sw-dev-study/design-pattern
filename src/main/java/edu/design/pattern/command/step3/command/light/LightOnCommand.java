package edu.design.pattern.command.step3.command.light;

import edu.design.pattern.command.step3.command.Command;
import edu.design.pattern.command.step3.receiver.light.Light;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
