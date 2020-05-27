import processing.core.PApplet;
class Particle {

    PApplet p;

    final double ACCELERATION = 0.1;

    float x;
    float y;
    float xVelocity;
    float yVelocity;
    int c;
    float size;

    Particle(int x, int y, PApplet p, float xVelocity, float yVelocity, int c, float size) {
        this.x = p.mouseX;
        this.y = p.mouseY;
        this.p=p;
        this.xVelocity = p.random(-5, 5);
        this.yVelocity = p.random(-4, 0);
        this.c = p.color(p.random(100, 255), p.random(100, 255), p.random(100, 255), 75);
        this.size = p.random(10, 20);
    }


    Particle(int x, int y, PApplet p) {
        this.x = x;
        this.y = y;
        this.p=p;
        xVelocity = p.random(-2, 2);
        yVelocity = p.random(-4, 0);
        c = p.color(p.random(100, 255), p.random(100, 255), p.random(100, 255), 75);
        size = p.random(10, 20);
    }

    void draw() {
        p.stroke(150);
        p.fill(c);
        p.ellipse(x, y, size, size);
    }

    void move() {
        x += xVelocity;
        y += yVelocity;
        yVelocity += ACCELERATION;
    }
}