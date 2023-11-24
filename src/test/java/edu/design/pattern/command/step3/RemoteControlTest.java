package edu.design.pattern.command.step3;

import edu.design.pattern.command.step3.command.MacroCommand;
import edu.design.pattern.command.step3.command.NoCommand;
import edu.design.pattern.command.step3.command.fan.CeilingFanHighCommand;
import edu.design.pattern.command.step3.command.fan.CeilingFanOnCommand;
import edu.design.pattern.command.step3.command.light.LightOffCommand;
import edu.design.pattern.command.step3.command.light.LightOnCommand;
import edu.design.pattern.command.step3.invoker.Invoker;
import edu.design.pattern.command.step3.invoker.RemoteControl;
import edu.design.pattern.command.step3.receiver.fan.CeilingFan;
import edu.design.pattern.command.step3.receiver.light.OutDoorLight;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    @DisplayName("MacroCommand 테스트")
    public void macroCommandTest() {
        Invoker remoteControl = new RemoteControl(1);

        CeilingFan ceilingFan = new CeilingFan();
        CeilingFanHighCommand ceilingFanHighCommand = new CeilingFanHighCommand(ceilingFan);
        CeilingFanOnCommand ceilingFanOnCommand = new CeilingFanOnCommand(ceilingFan);

        remoteControl.setOnCommand(1,
            new MacroCommand(List.of(ceilingFanOnCommand, ceilingFanHighCommand)),
            NoCommand.getInstance()
        );
        remoteControl.printMenu();

        remoteControl.onButtonWasPushed(1);
        remoteControl.undoButtonWasPushed();
    }
}
