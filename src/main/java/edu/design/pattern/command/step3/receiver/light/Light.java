package edu.design.pattern.command.step3.receiver.light;

import edu.design.pattern.command.step3.receiver.Receiver;

public interface Light extends Receiver {
    public void on();
    public void off();
}
