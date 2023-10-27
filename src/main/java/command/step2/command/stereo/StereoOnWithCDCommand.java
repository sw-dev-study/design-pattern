package command.step2.command.stereo;

import command.step2.command.Command;
import command.step2.receiver.stereo.Stereo;

public class StereoOnWithCDCommand implements Command {
    private final Stereo stereo;

    public StereoOnWithCDCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    @Override
    public void execute() {
        stereo.on();
        stereo.setCD();
        stereo.setVolume(1);
    }
}
