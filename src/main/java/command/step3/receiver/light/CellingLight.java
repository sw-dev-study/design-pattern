package command.step3.receiver.light;

public class CellingLight implements Light {
    @Override
    public void on() {
        System.out.println("천장 조명을 켭니다.");
    }

    @Override
    public void off() {
        System.out.println("천장 조명을 끕니다.");
    }
}
