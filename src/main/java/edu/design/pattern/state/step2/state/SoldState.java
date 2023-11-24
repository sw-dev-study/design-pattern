package edu.design.pattern.state.step2.state;

import edu.design.pattern.state.step2.GumballMachine;

public final class SoldState implements State {
    private final GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("알맹이를 내보내고 있습니다.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("이미 알맹이를 뽑으셨습니다.");
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이는 한 번만 돌려주세요.");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if(gumballMachine.getRemainGumballs() > 0) {
            gumballMachine.setCurState(gumballMachine.getNoQuarterState());
        } else {
            System.out.println("Oops, out of gumballs!");
            gumballMachine.setCurState(gumballMachine.getSoldOutState());
        }
    }
}
