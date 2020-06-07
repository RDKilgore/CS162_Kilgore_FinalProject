/**
 * This class was used as a way to clear whatever comes in the way of the alien object. Right now it is not used.
 */

import processing.core.PApplet;

public class Alien extends Person {


    Alien(PApplet zombieSketch, float x, float y) {
        super(zombieSketch, x, y);
        this.colour = personSketch.color(personSketch.random(153, 255), personSketch.random(0, 0), personSketch.random(0, 0), 155);
        this.yVelocity = (float) -1.5;
    }

    @Override
    public String rockPaperScissorGuessSelector() {
        return "Aliens don't play games";
    }
}