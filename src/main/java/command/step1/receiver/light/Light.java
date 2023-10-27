package command.step1.receiver.light;

import command.step1.receiver.Receiver;

public interface Light extends Receiver {
    public void on();
    public void off();
}
