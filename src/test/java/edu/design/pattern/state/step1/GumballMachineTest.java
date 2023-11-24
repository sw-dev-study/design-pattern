package edu.design.pattern.state.step1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GumballMachineTest {
    @Test
    @DisplayName("SimpleGumballMachine 테스트")
    public void simpleGumballMachineTest() {
        SimpleGumballMachine simpleGumballMachine = new SimpleGumballMachine(5); // 5개의 알맹이가 들어있는 거동을 테스트한다.
        System.out.println(simpleGumballMachine); // 현재 상태를 출력한다.

        simpleGumballMachine.insertQuater();
        simpleGumballMachine.turnCrank();

        System.out.println(simpleGumballMachine); // 현재 상태를 출력한다.

        simpleGumballMachine.insertQuater();
        simpleGumballMachine.ejectQuater();
        simpleGumballMachine.turnCrank();

        System.out.println(simpleGumballMachine); // 현재 상태를 출력한다.

        simpleGumballMachine.insertQuater();
        simpleGumballMachine.turnCrank();
        simpleGumballMachine.insertQuater();
        simpleGumballMachine.turnCrank();
        simpleGumballMachine.ejectQuater();

        System.out.println(simpleGumballMachine); // 현재 상태를 출력한다.

        simpleGumballMachine.insertQuater();
        simpleGumballMachine.insertQuater();
        simpleGumballMachine.turnCrank();
        simpleGumballMachine.insertQuater();
        simpleGumballMachine.turnCrank();
        simpleGumballMachine.insertQuater();
        simpleGumballMachine.turnCrank();

        System.out.println(simpleGumballMachine); // 현재 상태를 출력한다.
    }
}
