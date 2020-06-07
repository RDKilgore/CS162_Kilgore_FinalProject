/**
 * This is the Human class. This class extends the person class and helps create instances of a human.
 * in this class, the selection for the humans rock, paper, scissor response is created.
 */

import processing.core.PApplet;

public class Human extends Person {
    private int humanCount;
    private String humanShoot;


    Human(PApplet humanSketch, float x, float y){
        super(humanSketch,x,y);
        this.colour = personSketch.color(personSketch.random(39,123),personSketch.random(161,229),personSketch.random(169,236),155);
        this.yVelocity = (float) -.5;
        humanCount++;
    }

    @Override
    public String rockPaperScissorGuessSelector() {
        choice = (int) this.personSketch.random(3);
        if(choice == 0){
            humanShoot = "Rock";
        } else if (choice == 1) {
            humanShoot = "Paper";
        } else{ humanShoot = "Scissors";
          }
        return humanShoot;
    }
}
