package edu.design.pattern.state.step2.state;

import edu.design.pattern.state.step2.GumballMachine;

import java.util.Random;

public final class HasQuarterState implements State {
    private final Random randomWinner = new Random(System.currentTimeMillis());
    private final GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("동전은 한 개만 넣어주세요.");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("동전이 반환됩니다.");
        gumballMachine.setCurState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("손잡이를 돌리셨습니다.");
        int winner = randomWinner.nextInt(10);

        if((winner == 0) && (gumballMachine.getRemainGumballs() > 1)) {
            gumballMachine.setCurState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setCurState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("알맹이를 내보낼 수 없습니다.");
    }
}
