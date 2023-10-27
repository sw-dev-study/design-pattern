package command.step3;

import command.step3.command.NoCommand;
import command.step3.command.fan.CeilingFanHighCommand;
import command.step3.command.fan.CeilingFanOnCommand;
import command.step3.command.light.LightOffCommand;
import command.step3.command.light.LightOnCommand;
import command.step3.invoker.Invoker;
import command.step3.invoker.RemoteControl;
import command.step3.receiver.fan.CeilingFan;
import command.step3.receiver.light.OutDoorLight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RemoteControlTest {
    @Test
    @DisplayName("Remote Controll의 undo를 호출한다.")
    public void remoteControlSlotTest() {
        final int slotSize = 7;
        Invoker remoteControl = new RemoteControl(slotSize);

        OutDoorLight outDoorLight = new OutDoorLight();
        remoteControl.setOnCommand(1,
            new LightOnCommand(outDoorLight),
            new LightOffCommand(outDoorLight)
        );

        remoteControl.printMenu();
        remoteControl.onButtonWasPushed(1);

        remoteControl.printMenu();
        remoteControl.undoButtonWasPushed();
    }

    @Test
    @DisplayName("Remote Controll의 CeilingFanOnCommand의 excute, undo틑 테스트한다.")
    public void ceilingFanTest() {
        Invoker remoteControl = new RemoteControl(1);

        CeilingFan ceilingFan = new CeilingFan();
        remoteControl.setOnCommand(1,
            new CeilingFanOnCommand(ceilingFan),
            NoCommand.getInstance()
        );
        remoteControl.printMenu();

        remoteControl.onButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
    }

    @Test
    @DisplayName("Remote Controll의 CeilingFanHighCommand의 excute, undo틑 테스트한다.")
    public void ceilingFanHighTest1() {
        Invoker remoteControl = new RemoteControl(2);

        CeilingFan ceilingFan = new CeilingFan();
        remoteControl.setOnCommand(1,
            new CeilingFanOnCommand(ceilingFan),
            NoCommand.getInstance()
        );

        remoteControl.setOnCommand(2,
            new CeilingFanHighCommand(ceilingFan),
            NoCommand.getInstance()
        );
        remoteControl.printMenu();

        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.undoButtonWasPushed();
    }

    @Test
    @DisplayName("Remote Controll의 CeilingFanHighCommand의 excute, undo틑 테스트한다.")
    public void ceilingFanHighTest() {
        Invoker remoteControl = new RemoteControl(2);

        CeilingFan ceilingFan = new CeilingFan();

        remoteControl.setOnCommand(1,
            new CeilingFanHighCommand(ceilingFan),
            NoCommand.getInstance()
        );
        remoteControl.printMenu();

        remoteControl.onButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
    }
}
