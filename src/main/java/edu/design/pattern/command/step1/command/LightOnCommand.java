package edu.design.pattern.command.step1.command;

import edu.design.pattern.command.step1.receiver.light.Light;

public class LightOnCommand implements Command {
    private final Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void excute() {
        light.on();
    }
}
