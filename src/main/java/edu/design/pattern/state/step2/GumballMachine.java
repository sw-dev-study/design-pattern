package edu.design.pattern.state.step2;

import edu.design.pattern.state.step2.state.*;

public class GumballMachine {
    private final State soldOutState;
    private final State soldState;
    private final State hasQuarterState;
    private final State noQuarterState;
    private final State winnerState;

    private int remainGumballs;
    private State curState;

    /**
     * 상태 객체를 생성하고 대입하는 작업은 생성자가 처리
     */
    public GumballMachine(int remainGumballs) {
        this.soldOutState = new SoldOutState(this);
        this.soldState = new SoldState(this);
        this.hasQuarterState = new HasQuarterState(this);
        this.noQuarterState = new NoQuarterState(this);
        winnerState = new WinnerState(this);
        this.remainGumballs = remainGumballs;

        if(this.remainGumballs > 0) {
            this.curState = noQuarterState;
        } else {
            this.curState = soldOutState;
        }
    }

    public void insertQuarter() {
        curState.insertQuarter();
    }

    public void ejectQuarter() {
        curState.ejectQuarter();
    }

    public void turnCrank() {
        curState.turnCrank();
        curState.dispense();
    }

    /**
     * ! 남은 Gumball은 GumballMachine에서 제어하는 게 맞나?
     * ! remainGumballs 이외에도 여러 상태값들이 추가될 수 있는데, 그러한 것들도 GumballMachine에서 관리하는 게 맞나?
     * ! 최소한 releaseBall()과 같은 메서드들은 State만 호출할 수 있도록 해야할 것 같음. (하지만, 접근 제한자로 제어하기는 어려워 보임)
     */
    public void releaseBall() {
        System.out.println("알맹이를 내보내고 있습니다.");
        if(remainGumballs > 0) {
            remainGumballs -= 1;
        }
    }

    public void setCurState(State curState) {
        this.curState = curState;
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getWinnerState() {
        return winnerState;
    }

    public int getRemainGumballs() {
        return remainGumballs;
    }

    public State getCurState() {
        return curState;
    }

}
