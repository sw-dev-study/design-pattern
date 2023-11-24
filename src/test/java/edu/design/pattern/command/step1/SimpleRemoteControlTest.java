package edu.design.pattern.command.step1;


import edu.design.pattern.command.step1.command.Command;
import edu.design.pattern.command.step1.command.LightOnCommand;
import edu.design.pattern.command.step1.invoker.SimpleRemoteControl;
import edu.design.pattern.command.step1.receiver.light.Light;
import edu.design.pattern.command.step1.receiver.light.OutDoorLight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SimpleRemoteControlTest {
    @Test
    @DisplayName("야외 조명을 켠다")
    void outdoorLightOn(){
        Light outdoorLight = new OutDoorLight();
        Command lightOnCommand = new LightOnCommand(outdoorLight);

        SimpleRemoteControl remoteControl = new SimpleRemoteControl(lightOnCommand);
        remoteControl.buttonWasPressed();
    }
}
