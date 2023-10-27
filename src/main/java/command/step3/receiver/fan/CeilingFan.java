package command.step3.receiver.fan;

public class CeilingFan implements Fan {
    private FanSpeed speed;
    private FanStatus status;

    public CeilingFan() {
        this.speed = FanSpeed.ZERO;
        this.status = FanStatus.OFF;
    }

    @Override
    public FanStatus getStatus() {
        return this.status;
    }

    @Override
    public FanSpeed getSpeed() {
        return this.speed;
    }

    @Override
    public void setSpeed(FanSpeed speed) {
        System.out.println("선풍기의 스피드를 " + speed + "로 설정합니다.");
        this.speed = speed;
    }

    @Override
    public void on() {
        System.out.println("선풍기를 켭니다.");
        this.status = FanStatus.ON;
        this.speed = FanSpeed.LOW;
    }

    @Override
    public void off() {
        System.out.println("선풍기를 끕니다.");
        this.status = FanStatus.OFF;
        this.speed = FanSpeed.ZERO;
    }
}
