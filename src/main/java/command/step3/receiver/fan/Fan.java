package command.step3.receiver.fan;

import command.step3.receiver.Receiver;

public interface Fan extends Receiver {
    void on();
    void off();
    FanStatus getStatus();
    FanSpeed getSpeed();
    void setSpeed(FanSpeed speed);

    enum FanSpeed {
        HIGH, MEDIUM, LOW, ZERO
    }

    enum FanStatus {
        ON, OFF
    }
}


