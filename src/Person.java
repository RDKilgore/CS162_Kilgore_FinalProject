/**
 * This is the Person class. This class is used to make all "bodys" in this simulation and sets variables accordingly.
 *
 */

import processing.core.PApplet;

public abstract class Person{
    protected int colour, choice;
    protected float x,y;
    private float xVelocity;
    protected float yVelocity;
    private float radius;
    protected int strength;
    protected PApplet personSketch;
    private int personCount;
    private String shootGuess;


    Person(PApplet sketch, float x, float y){
        this.x = x;
        this.y = y;
        personSketch = sketch;
        setRadius(personSketch.random(10,25));
        this.colour = sketch.color(0);
        personCount++;
        strength = (int) personSketch.random(4);
    }

    public boolean touching(Person other){
        float distance = personSketch.dist(this.x,this.y,other.x,other.y);
        return distance <= this.radius + other.radius;
        }


    public void display() {
        personSketch.fill(colour);
        personSketch.circle(this.x, this.y, radius*2);
    }

    public void move(){
        y+=yVelocity;
    }

    public void walk(){
        choice = (int) this.personSketch.random(4);
        if(choice == 0){
            this.x++;
        } else if (choice == 1) {
            this.x--;
        } else if (choice == 2){
            this.y++;
        } else {
            this.y--;
        }
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getColour() {
        return colour;
    }
    public void setColour(int colour){
        this.colour = colour;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getStrength() {
        return strength;
    }

    public float getXVelocity() {
        return xVelocity;
    }

    public void setXVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getYVelocity() {
        return yVelocity;
    }

    public void setYVelocity(float yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getTotalCount() {
        return personCount;
    }

    // selects the guess between rock paper scissor and assigns it to a variable.
    public abstract String rockPaperScissorGuessSelector();
}


