import processing.core.PApplet;

public class Zombie extends Person{
    PApplet zombieSketch;
    int zombieCount = 0;

    Zombie(PApplet zombieSketch,int x, int y){
        super(zombieSketch,x,y);
        this.colour =  personSketch.color(personSketch.random(59,42),personSketch.random(156,242),personSketch.random(17,99));
        this.yVelocity = 1;
        zombieCount++;
    }

    public int getZombieCount() {
        return zombieCount;
    }
//

    public void displayTypeCount() {
        zombieSketch.textSize(30);
        zombieSketch.fill(0);
        zombieSketch.text("Zombie Count: " + zombieCount, 450 ,200);
    }
//
//    @Override
//    public void makeNoise() {
//        System.out.println("Grrrrr");
//    }
//
//    @Override
//    public void takeDamage() {
//        System.out.println("huhhhhhhh");
//    }
//
//    @Override
//    public String toString() {
//        return "Zombie{" + "p=" + p + ", zombieCount=" + zombieCount + '}';
//    }
}
