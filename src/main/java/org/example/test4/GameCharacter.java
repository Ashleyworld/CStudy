package org.example.test4;

public class GameCharacter {
    int speed = 0;

    public void setSpeed(int speed_change) {
        this.speed += speed_change;
        System.out.println("스피드가" + this.speed + " 증가합니다.");

    }
}


