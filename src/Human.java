import processing.core.PApplet;

import static java.lang.System.out;

public class Human extends Person {
    PApplet p;
    int humanCount;

    Human(int x, int y, PApplet p){
        //inherits x position, y position, and the p object
        super(x, y, p);
        this.c= p.color(p.random(00, 0), p.random(0, 0), p.random(250, 255), 255);
        humanCount++;
    }
    //should create a textBox in the upper 1/4 center
    //Human: humanCount
    public void displayTypeCount(){
        super.p.textSize(15);
        super.p.fill(0);
        super.p.text("Human Count: " + humanCount, 450 ,600);
    }


    public void setHumanCount(int humanCount) {
        this.humanCount = humanCount;
    }

    public int getHumanCount() {
        return humanCount;
    }

    @Override
    public void makeNoise() {
        out.println("Got em");
    }

    @Override
    public void takeDamage() {
        out.println("Ahhh!");
    }
    public void draw(PApplet p) {
        this.p = p;
        draw(p);
    }
}
