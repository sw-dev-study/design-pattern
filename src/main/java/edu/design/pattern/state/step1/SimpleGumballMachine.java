package edu.design.pattern.state.step1;

public class SimpleGumballMachine {

    private GumballMachineState state;  // 뽑기 기계의 현재 상태
    private int remainProductCount; // 뽑기 기계 내에 남아있는 상품의 개수

    public SimpleGumballMachine(int remainProductCount) {
        this.remainProductCount = remainProductCount;

        if(this.remainProductCount <= 0) {
            state = GumballMachineState.SOLD_OUT;
        } else {
            state = GumballMachineState.NO_QUARTER;
        }
    }


    /**
     * 동전 투입
     */
    public void insertQuater() {
        if(state == GumballMachineState.HAS_QUARTER) {
            System.out.println("동전은 한 개만 넣어주세요.");
        } else if(state == GumballMachineState.NO_QUARTER) {
            state = GumballMachineState.HAS_QUARTER;
            System.out.println("동전이 투입되었습니다.");
        } else if(state == GumballMachineState.SOLD_OUT) {
            System.out.println("매진되었습니다. 다음 기회에 이용해주세요.");
        } else if(state == GumballMachineState.SOLD) {
            System.out.println("알맹이를 내보내고 있습니다.");
        }
    }

    /**
     * 동전 반환
     */
    public void ejectQuater() {
        if(state == GumballMachineState.HAS_QUARTER) {
            System.out.println("동전이 반환됩니다.");
            state = GumballMachineState.NO_QUARTER;
        } else if(state == GumballMachineState.NO_QUARTER) {
            System.out.println("동전을 넣어주세요.");
        } else if(state == GumballMachineState.SOLD_OUT) {
            System.out.println("동전을 넣지 않으셨습니다. 동전이 반환되지 않습니다.");
        } else if(state == GumballMachineState.SOLD) {
            System.out.println("이미 알맹이를 뽑으셨습니다.");
        }
    }

    /**
     * 손잡이 돌리기
     */
    public void turnCrank() {
        if(state == GumballMachineState.HAS_QUARTER) {
            System.out.println("손잡이를 돌리셨습니다.");
            state = GumballMachineState.SOLD;
            dispense();
        } else if(state == GumballMachineState.NO_QUARTER) {
            System.out.println("동전을 넣어주세요.");
        } else if(state == GumballMachineState.SOLD_OUT) {
            System.out.println("매진되었습니다.");
        } else if(state == GumballMachineState.SOLD) {
            System.out.println("손잡이는 한 번만 돌려주세요.");
        }
    }

    /**
     * 알맹이 내보내기
     */
    public void dispense() {
        if(state == GumballMachineState.HAS_QUARTER) {
            System.out.println("알맹이가 나갈 수 없습니다.");
        } else if(state == GumballMachineState.NO_QUARTER) {
            System.out.println("동전을 넣어주세요.");
        } else if(state == GumballMachineState.SOLD_OUT) {
            System.out.println("매진입니다.");
        } else if(state == GumballMachineState.SOLD) {
            System.out.println("알맹이가 나가고 있습니다.");
            remainProductCount--;
            if(remainProductCount == 0) {
                System.out.println("더 이상 알맹이가 없습니다.");
                state = GumballMachineState.SOLD_OUT;
            } else {
                state = GumballMachineState.NO_QUARTER;
            }
        }
    }

    public String toString() {
        StringBuffer result = new StringBuffer();
        result.append("\n");
        result.append("주식회사 왕뽑기\n");
        result.append("자바로 돌아가는 2004년형 뽑기 기계\n");
        result.append("남은 갯수: ").append(this.remainProductCount).append(" 개\n\n");
        result.append("현재 상태는 ").append(this.state).append("\n");
        return result.toString();
    }

    private enum GumballMachineState {
        SOLD_OUT, // 알맹이 판매
        SOLD, // 알맹이 매진
        NO_QUARTER, // 동전 없음
        HAS_QUARTER // 동전 있음
    }
}


