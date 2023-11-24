package edu.design.pattern.command.step3.invoker;

import edu.design.pattern.command.step3.command.Command;
import org.jetbrains.annotations.NotNull;

public interface Invoker {
    void setOnCommand(
        int slotIndex,
        @NotNull Command onCommand,
        @NotNull Command offCommand
    );

    void onButtonWasPushed(int slotIndex);

    void offButtonWasPushed(int slotIndex);

    void undoButtonWasPushed();
    void printMenu();
}
