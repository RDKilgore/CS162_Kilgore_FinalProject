import processing.core.PApplet;

import static java.lang.System.out;
import static java.lang.System.setOut;

public class Human extends Person {
    int humanCount;
    boolean hit = false;

    Human(PApplet humanSketch, int x, int y){
        super(humanSketch,x,y);
        this.colour = personSketch.color(personSketch.random(39,123),personSketch.random(161,229),personSketch.random(169,236));
        this.yVelocity = -1;
        humanCount++;
    }


    public void makeNoise() {
        out.println("Got em");
    }

    public void takeDamage() {
        out.println("Ahhh!");
    }

}
