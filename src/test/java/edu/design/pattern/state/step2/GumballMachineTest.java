package edu.design.pattern.state.step2;

import org.junit.jupiter.api.Test;

public class GumballMachineTest {
    @Test
    public void test() {
        GumballMachine gumballMachine = new GumballMachine(5);

        System.out.println(gumballMachine);

        // 동전을 넣는다.
        gumballMachine.insertQuarter();
        // 손잡이를 돌린다.
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);

        // 동전을 넣는다.
        gumballMachine.insertQuarter();
        // 손잡이를 돌린다.
        gumballMachine.turnCrank();

        // 동전을 넣는다.
        gumballMachine.insertQuarter();
        // 손잡이를 돌린다.
        gumballMachine.turnCrank();

        System.out.println(gumballMachine);
    }
}
