package command.step2.receiver.light;

import command.step2.receiver.Receiver;

public interface Light extends Receiver {
    public void on();
    public void off();
}
