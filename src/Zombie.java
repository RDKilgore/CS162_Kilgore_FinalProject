import processing.core.PApplet;

public class Zombie extends Person{
    PApplet p;
    int zombieCount = 0;

    Zombie(int x, int y, PApplet p){
        super(x, y, p);
        this.c= p.color(p.random(240, 255), p.random(0, 0), p.random(0, 0), 255);
        System.out.println("Zombie created");
        ++zombieCount;
        setId(zombieCount);
    }

    public int getZombieCount() {
        return zombieCount;
    }

    @Override
    public void displayTypeCount() {
        super.p.textSize(15);
        super.p.fill(0);
        super.p.text("Zombie Count: " + zombieCount, 450 ,200);
    }

    @Override
    public void makeNoise() {
        System.out.println("Grrrrr");
    }

    @Override
    public void takeDamage() {
        System.out.println("huhhhhhhh");
    }

    public void draw(PApplet p) {
        this.p = p;
        p.draw();
    }

    @Override
    public String toString() {
        return "Zombie{" + "p=" + p + ", zombieCount=" + zombieCount + '}';
    }
}
