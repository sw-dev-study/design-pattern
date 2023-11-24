package edu.design.pattern.state.step2.state;

public sealed interface State permits SoldOutState, NoQuarterState, HasQuarterState, SoldState {
    /**
     * 동전 넣기
     */
    void insertQuarter();

    /**
     * 동전 반환
     */
    void ejectQuarter();

    /**
     * 손잡이 돌리기
     */
    void turnCrank();

    /**
     * 알맹이 꺼내기
     */
    void dispense();
}

