import processing.core.PApplet;

public class Zombie extends Person{
    int zombieCount = 0;

    Zombie(PApplet zombieSketch,float x, float y){
        super(zombieSketch,x,y);
        this.colour =  personSketch.color(personSketch.random(59,42),personSketch.random(156,242),personSketch.random(17,99),155);
        this.yVelocity = (float) .5;
        zombieCount++;
    }
}
