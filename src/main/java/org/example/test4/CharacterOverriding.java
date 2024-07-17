package org.example.test4;

public class CharacterOverriding {
    public static void main(String[] args) {
        GameCharacter gameCharacter = new GameCharacter();
        gameCharacter.setSpeed(10);

        Ashley ashley = new Ashley();
        ashley.setSpeed(100);
    }
}