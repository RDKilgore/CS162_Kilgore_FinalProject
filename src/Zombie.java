import processing.core.PApplet;

public class Zombie extends Person{
    PApplet zombieSketch;
    int zombieCount = 0;

    Zombie(PApplet zombieSketch,float x, float y){
        super(zombieSketch,x,y);
        this.colour =  personSketch.color(personSketch.random(59,42),personSketch.random(156,242),personSketch.random(17,99));
        this.yVelocity = (float) .5;
        zombieCount++;
    }

//    public int getZombieCount() {
//        return zombieCount;
//    }
//
//    public void setZombieCount(int zombieCount) {
//        this.zombieCount = zombieCount;
//    }

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
