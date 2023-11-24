package edu.design.pattern.command.step1.invoker;

import edu.design.pattern.command.step1.command.Command;

public class SimpleRemoteControl {
    private final Command slot;

    public SimpleRemoteControl(Command command) {
        this.slot = command;
    }

    public void buttonWasPressed(){
        slot.excute();
    }
}
