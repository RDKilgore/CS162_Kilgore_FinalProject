import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Collections;

public class Sketch extends PApplet {
    Zombie zombie;
    boolean collision = false;
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    ArrayList<Human> humans = new ArrayList<Human>();
    Human h = new Human(this,200,400);
    Zombie z = new Zombie(this,200,200);
int humanCount = 0;
int zombieCount = 0;



    public void settings() {
        size(1000, 800);
    }

    public void setup() {

//        Person p = new Person(this);
        Human h = new Human(this,200,200);
        Zombie z = new Zombie(this,200,400);
        addZombies(zombies);
        addHumans(humans);
        //z.display();
//        h.display();
//        p.display();

    }


    public void draw() {
        background(250);
        z.display();
        z.move();
        z.walk();
        h.display();
        h.move();
        h.walk();
        collision();

        displayZombies(zombies);
        displayHumans(humans);



    }

    private void addZombies(ArrayList<Zombie> zombies) {
        for (int i = 0; i < 100; ++i) {
            Zombie temp = new Zombie(this,(int)random(30,970),(int)random(200,300));
            zombies.add(temp);
            zombieCount++;
            System.out.println("Zombie added");
        }
    }
    public void collision(){
        if(h.intersects(z)) {
            System.out.println("collision");
            h.yVelocity *= -1;
            h.colour = 0;
            z.yVelocity *= -1;
        }
    }
    private void addHumans(ArrayList<Human> humans) {
        for (int i = 0; i < 100; ++i) {
            Human temp = new Human(this,(int)random(30,970),(int)random(600,700));
            humans.add(temp);
            humanCount++;
            System.out.println("Human added");
        }
    }
    private void displayZombies (ArrayList<Zombie> zombies) {
        for (Zombie zombie : zombies) {
            zombie.display();
            displayTypeCount();
            zombie.move();
            zombie.walk();
            collision();
            }
    }

//    public boolean checkCollisionWithZombie(Zombie zombie){
//        double xDiff = humans.x - zombie.getX();
//        double yDiff = this.y - zombie.getY();
//        double distance =Math.sqrt((Math.pow(xDiff,2) + Math.pow(yDiff,2)));
//        System.out.println("checking");;
//        return distance < (radius + zombie.getRadius());
//    }

    private void displayHumans (ArrayList<Human> humans) {
        for (Human human : humans) {
            human.display();
            displayTypeCount();
            human.move();
            human.walk();
            collision();
            //System.out.println(zombie);
        }
    }
    public void displayTypeCount() {
        this.textSize(30);
        this.fill(0);
        this.text("Zombie Count: " + zombieCount, 400 ,150);
        this.text("Human Count: " + humanCount, 400 ,650);
    }
//    public void collisionDetection(Zombie zombie){
//        if (dist()
//    }
}
