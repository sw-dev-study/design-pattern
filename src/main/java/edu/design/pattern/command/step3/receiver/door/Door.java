package edu.design.pattern.command.step3.receiver.door;

import edu.design.pattern.command.step1.receiver.Receiver;

public interface Door extends Receiver {
    public void up() ;

    public void down();

    public void stop();

    public void lightOn();

    public void lightOff();
}
