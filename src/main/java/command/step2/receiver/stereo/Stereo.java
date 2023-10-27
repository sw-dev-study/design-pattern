package command.step2.receiver.stereo;

import command.step1.receiver.Receiver;

public interface Stereo extends Receiver {
    void on();
    void off();
    void setCD();
    void setDvd();
    void setRadio();
    void setVolume(int volumeSize);
}
