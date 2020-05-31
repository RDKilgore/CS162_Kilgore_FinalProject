import processing.core.PApplet;

import java.util.ArrayList;

public class Person{
    final private double ACCELERATION = 0.2;
    int colour, choice;
    int x,y,g,b;
    float xVelocity;
    double yVelocity;
    float radius, health;
    PApplet personSketch;
    int personCount;


    Person(PApplet sketch, int x, int y){
        this.x = x;
        this.y = y;
        personSketch = sketch;
        setRadius(personSketch.random(10,35));
        this.colour = sketch.color(0);
        personCount++;
    }
    public boolean intersects(Zombie other){
        var distance = personSketch.dist(this.x,this.y,other.x,other.y);
        if(distance <= this.radius + other.radius){
            return true;
        } else  return false;
    }

    public void display() {
        personSketch.fill(colour);
        personSketch.circle(this.x, this.y, radius);
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getxVelocity() {
        return xVelocity;
    }

    public void setxVelocity(float xVelocity) {
        this.xVelocity = xVelocity;
    }

    public double getyVelocity() {
        return yVelocity;
    }

    public void setyVelocity(double yVelocity) {
        this.yVelocity = yVelocity;
    }

    public int getTotalCount() {
        return personCount;
    }

}
