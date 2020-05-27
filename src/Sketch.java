import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Collections;

public class Sketch extends PApplet {
    Zombie zombie;
    Zombie zombieSquad;
    Human human;
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    ArrayList<Human> humans = new ArrayList<Human>();


    public void settings() {
        size(1000, 800);
    }

    public void setup() {
        background(250);
        //Particle q = new Particle(this);

        Human h = new Human(100, 100, this);
        Zombie z = new Zombie(700, 700, this);
        Zombie z2 = new Zombie(10, 20, this);
        Particle p = new Particle(700, 200, this);
        ParticleSystem ps = new ParticleSystem(700,200,this);
        h.displayTypeCount();
        displayZombies(zombies);
        z.displayTypeCount();
        ps.update();
        ps.draw();

        h.draw();
        h.move();
        z.draw();
        z.move();
    }


    public void draw() {
    }

    private void add(ArrayList<Zombie> zombies) {
        for (int i = 0; i < 10; ++i) {
            Zombie temp = new Zombie((int) random(0, 1000), (int) random(0, 1000), this);
            zombies.add(temp);
            System.out.println("added");
        }
    }
        private void displayZombies (ArrayList<Zombie> zombies) {
            for (Zombie zombie : zombies) {
                zombie.draw();
                System.out.println(zombie);
                zombie.draw(this);
            }
        }
    }
