import processing.core.PApplet;
import processing.sound.*;
import java.util.ArrayList;

public class Sketch extends PApplet {
    SoundFile file;

    ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    ArrayList<Human> humans = new ArrayList<Human>();
    ArrayList<ParticleSystem> p1 = new ArrayList<ParticleSystem>();
    int humanCount;
    int zombieCount;
    private int numberOfZombies;
    private int numberOfHumans;


    public void settings() {
        size(1000, 800);
        file = new SoundFile(this,"Zombie_Moan.wav" );
    }

    public void setup() {
        generateNumberZombies();
        generateNumberHumans();
        addZombies(zombies);
        addHumans(humans);
    }

    public void draw() {
        background(250);
        displayZombies(zombies);
        displayHumans(humans);
        collision();
        displayParticleSystem(p1);
    }

    public void collision() {
        for (int i = humans.size()-1; i >= 0; i--) {
            for (int j = zombies.size()-1; j >= 0; j--) {
                Human h1 = humans.get(i);
                Zombie z1 = zombies.get(j);
                if (collisionCheck(h1,z1) && (z1.stregth == 0)) {
                    float tempZombieX = z1.getX();
                    float tempZombieY = z1.getY();
                    zombies.remove(j);
                    System.out.println("zombie in the :" + j + "location removed");
                    zombieCount--;
                    ParticleSystem p = new ParticleSystem((int)tempZombieX, (int)tempZombieY, this);
                    p1.add(p);
                } else if(collisionCheck(h1,z1) && (h1.stregth== 0)){
                    h1.colour=color(random(59,42),random(156,242),random(17,99));
                    h1.setyVelocity((float) .5);
                    file.play();
                    h1.setStregth(5);
                    humanCount--;
                    zombieCount++;
                    break;
                  } else if (collisionCheck(h1,z1) && (h1.stregth == z1.stregth)){
                    z1.setStregth((int)random(4));
                    h1.setStregth((int)random(4));
                }   else if (collisionCheck(h1,z1) && (h1.stregth==2 && z1.stregth==3)){
                    h1.setColour(0);
                }
            }
        }
    }
    //check to see if a human intersects a zombie
    public boolean collisionCheck(Human human, Zombie zombie) {//pass human and zombie object
        return (human.touching(zombie));
    }

    private void addHumans(ArrayList<Human> humans) {
        for (int i = 0; i <numberOfHumans; ++i) {
            Human temp = new Human(this,(int)random(30,970),(int)random(600,700));
            humans.add(temp);
            humanCount++;
            System.out.println("Human added with stregth: " + temp.stregth);
        }
    }

    private void displayHumans (ArrayList<Human> humans) {
        for (Human human : humans) {
            human.display();
            displayTypeCount();
            human.move();
            human.walk();
        }
    }

    private void addZombies(ArrayList<Zombie> zombies) {
        for (int i = 0; i < numberOfZombies; ++i) {
            Zombie temp = new Zombie(this,(int)random(30,970),(int)random(200,300));
            zombies.add(temp);
            zombieCount++;
            System.out.println("Zombie added with stregth: " + temp.stregth);
        }
    }

    private void displayZombies (ArrayList<Zombie> zombies) {
        for (Zombie zombie : zombies) {
            zombie.display();
            displayTypeCount();
            zombie.move();
            zombie.walk();
            }
    }

    private void displayParticleSystem(ArrayList<ParticleSystem> particles){
        for(ParticleSystem p: particles){
            p.update();
            p.draw();
        }
    }

    public void displayTypeCount() {
        this.textSize(30);
        this.fill(0);
        this.text("Zombie Count: " + zombieCount, 400 ,150);
        this.text("Human Count: " + humanCount, 400 ,650);
    }

    public void generateNumberZombies(){
        int randomNumber = (int) this.random(4);
        if(randomNumber == 0){
            this.numberOfZombies = 30;
        } else if (randomNumber == 1) {
            this.numberOfZombies = 60;
        } else if (randomNumber == 2){
            this.numberOfZombies = 90;
        } else {
            this.numberOfZombies = 120;
        }
    }

    public void generateNumberHumans(){
        int RandomNumber = (int) this.random(4);
        if(RandomNumber == 0){
            this.numberOfHumans = 30;
        } else if (RandomNumber == 1) {
            this.numberOfHumans = 60;
        } else if (RandomNumber == 2){
            this.numberOfHumans = 90;
        } else {
            this.numberOfHumans = 120;
        }
    }
}
