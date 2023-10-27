package command.step2;

import command.step2.command.NoCommand;
import command.step2.command.door.GarageDoorCloseCommand;
import command.step2.command.door.GarageDoorOpenCommand;
import command.step2.command.light.LightOffCommand;
import command.step2.command.light.LightOnCommand;
import command.step2.invoker.Invoker;
import command.step2.invoker.RemoteControl;
import command.step2.receiver.door.GarageDoor;
import command.step2.receiver.light.CellingLight;
import command.step2.receiver.light.OutDoorLight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RemoteControlTest {
    @Test
    @DisplayName("Remote Controll의 각 슬롯에 Command를 등록한다.")
    public void remoteControlSlotTest() {
        final int slotSize = 7;
        Invoker remoteControl = new RemoteControl(slotSize);

        OutDoorLight outDoorLight = new OutDoorLight();
        remoteControl.setOnCommand(1,
            new LightOnCommand(outDoorLight),
            new LightOffCommand(outDoorLight)
        );

        CellingLight CellingLight = new CellingLight();
        remoteControl.setOnCommand(2,
            new LightOnCommand(CellingLight),
            new LightOffCommand(CellingLight)
        );

        GarageDoor garageDoor = new GarageDoor();
        remoteControl.setOnCommand(3,
            new GarageDoorOpenCommand(garageDoor),
            new GarageDoorCloseCommand(garageDoor)
        );

        remoteControl.printMenu();

        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);

        remoteControl.offButtonWasPushed(1);
        remoteControl.offButtonWasPushed(2);
        remoteControl.offButtonWasPushed(3);
    }

    @Test
    @DisplayName("Remote Controll의 각 슬롯에 람다를 이용하여 Command를 등록한다.")
    public void remoteControlLamdaTest() {
        final int slotSize = 7;
        Invoker remoteControl = new RemoteControl(slotSize);

        OutDoorLight outDoorLight = new OutDoorLight();
        remoteControl.setOnCommand(1,
            outDoorLight::on,
            outDoorLight::off
        );

        CellingLight CellingLight = new CellingLight();
        remoteControl.setOnCommand(2,
            CellingLight::on,
            CellingLight::off
        );

        remoteControl.printMenu();

        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);

        remoteControl.offButtonWasPushed(1);
        remoteControl.offButtonWasPushed(2);
    }

    @Test
    @DisplayName("Remote Controll의 크기를 벗어나는 슬롯에 Command를 할당하는 경우, IllegalArgumentException이 발생한다.")
    public void remoteControlOutOfIndex() {
        final int slotSize = 0;
        Invoker remoteControl = new RemoteControl(slotSize);

        NoCommand noCommand = NoCommand.getInstance();

        assertThrows(IllegalArgumentException.class, () -> {
            remoteControl.setOnCommand(1,
                noCommand,
                noCommand
            );
        });
    }
}
