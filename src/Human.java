import processing.core.PApplet;

public class Human extends Person {
    int humanCount;


    Human(PApplet humanSketch, float x, float y){
        super(humanSketch,x,y);
        this.colour = personSketch.color(personSketch.random(39,123),personSketch.random(161,229),personSketch.random(169,236),155);
        this.yVelocity = (float) -.5;
        humanCount++;
    }

    public void makeNoise() {
        System.out.println("Got em");
    }

    public void takeDamage() {
        System.out.println("Ahhh!");
    }

}
