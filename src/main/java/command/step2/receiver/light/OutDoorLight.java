package command.step2.receiver.light;

public class OutDoorLight implements Light {

    public void on() {
        System.out.println("야외 조명을 켭니다.");
    }

    public void off() {
        System.out.println("야외 조명을 끕니다.");
    }
}
