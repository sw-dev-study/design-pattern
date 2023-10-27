package command.step2.invoker;

import command.step2.command.Command;
import command.step2.command.NoCommand;
import org.jetbrains.annotations.NotNull;

public class RemoteControl implements Invoker {
    private final Command[] onCommands;
    private final Command[] offCommands;
    private final int slotSize;

    public RemoteControl(int slotSize){
        this.slotSize = slotSize;
        this.onCommands = new Command[slotSize];
        this.offCommands = new Command[slotSize];

        NoCommand noCommand = NoCommand.getInstance();
        for (int i = 0; i < slotSize; i++){
            onCommands[i] = noCommand;
            offCommands[i] = noCommand;
        }
    }

    public void setOnCommand(
        int slotIndex,
        @NotNull Command onCommand,
        @NotNull Command offCommand
    ) {
        validateSlotIndex(slotIndex);
        this.onCommands[slotIndex - 1] = onCommand;
        this.offCommands[slotIndex - 1] = offCommand;
    }

    public void onButtonWasPushed(int slotIndex){
        validateSlotIndex(slotIndex);
        this.onCommands[slotIndex - 1].execute();

    }

    public void offButtonWasPushed(int slotIndex){
        this.offCommands[slotIndex - 1].execute();

    }

    private void validateSlotIndex(int slotIndex){
        if(slotIndex < 1 || this.slotSize < slotIndex){
            throw new IllegalArgumentException("슬롯의 크기를 벗어났습니다.");
        }
    }

    public void printMenu() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("\n ---------- 리모컨 ----------\n");
        for(int i = 0; i < slotSize; i++) {
            stringBuffer.append("[slot ").append(i + 1).append("] ")
                    .append(onCommands[i].getClass().getName()).append("    ")
                    .append(offCommands[i].getClass().getName()).append("\n");
        }
        System.out.println(stringBuffer);
    }
}
