package command.step3.receiver.light;

import command.step3.receiver.Receiver;

public interface Light extends Receiver {
    public void on();
    public void off();
}
