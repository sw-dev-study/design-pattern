package edu.design.pattern.command.step3.receiver.door;

public class GarageDoor implements Door {
    public void up() {
        System.out.println("Garage Door를 올립니다.");
    }

    public void down() {
        System.out.println("Garage Door를 내립니다. ");
    }

    public void stop() {
        System.out.println("Garage Door를 멈춥니다.");
    }

    public void lightOn() {
        System.out.println("Garage Door의 불을 켭니다.");
    }

    public void lightOff() {
        System.out.println("Garage Door의 불을 끕니다.");
    }
}