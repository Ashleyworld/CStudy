package org.example.test4;

public class Ashley extends GameCharacter{

    final int MAX_SPEED = 200;

    public void setSpeed(int speed){
        this.speed += speed;

        if (this.speed > MAX_SPEED){
            this.speed = MAX_SPEED;
        }

        System.out.println("스피드가" + this.speed + "로 설정되었습니다.");
    }
}