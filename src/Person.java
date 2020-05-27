import processing.core.PApplet;

import java.awt.*;

public abstract class Person extends Particle{
    private Point position; // might not need for this.
    float size, xVelocity, yVelocity, health;
    int totalCount;
    private int id;

    Person(int x, int y, PApplet p){
        super(x, y, p);
        this.c= p.color(p.random(100, 255), p.random(100, 255), p.random(100, 255), 75);
        totalCount++;
        setId(totalCount);
    }
    public int getTotalCount() {
        return totalCount;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public abstract void makeNoise();
    public abstract void takeDamage();
    public abstract void displayTypeCount();
    abstract public void draw(PApplet p);

    @Override
    public String toString() {
        return "hello";
    }
}
