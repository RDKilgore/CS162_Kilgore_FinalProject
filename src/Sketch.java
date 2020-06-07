/**
 * This is the main sketch class. Variables are initialized and the three main methods for processing are execute.
 * The program was created to be a zombie vs human simulator. At the start of the program a random number of zombies/humans
 * are created. The zombies are the green circles at the top of screen and humans are blue circles at the bottom of screen.
 *
 * the zombies and humans walk towards eachother and collide in the middle. When a collision occurs, one of three possibilities occur.
 * if a collison between and zombie/human occurs and the zombie has a stregth of 0, the human will kill the zombie; The zombie
 * will explode into a particle system. If a collison between human/ zombie occurs and the humans strength is 0, the human converts to a zombie.
 * Finally, if the two meet with a tie, they engage in an intense game of rock paper scissors and the winner turns gold
 * to represent a gold medal received.
 */

import processing.core.PApplet;
import processing.core.PFont;
import processing.sound.*;
import java.util.ArrayList;

public class Sketch extends PApplet {
    PFont font;
    SoundFile file;
    ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    ArrayList<Human> humans = new ArrayList<Human>();
    ArrayList<ParticleSystem> p1 = new ArrayList<ParticleSystem>();
    //ArrayList<Alien> aliens = new ArrayList<>();
    int humanCount, zombieCount;
    int humanWins, zombieWins, winner;
    private int numberOfZombies;
    private int numberOfHumans;


    public void settings() {
        size(1000, 800);

    }

    public void setup() {
        file = new SoundFile(this, "Zombie_Moan.wav");
        font = createFont("LongHairedFreakyPeople.otf", 45, true);
        generateNumberZombies();
        generateNumberHumans();
        addZombies(zombies);
        addHumans(humans);
    }

    public void draw() {
        background(250);
        displayZombies(zombies);
        displayHumans(humans);
        //displayAliens(aliens);
        collision();
        displayParticleSystem(p1);
    }

    public void generateNumberZombies() {
        int randomNumber = (int) this.random(4);
        if (randomNumber == 0) {
            this.numberOfZombies = 30;
        } else if (randomNumber == 1) {
            this.numberOfZombies = 60;
        } else if (randomNumber == 2) {
            this.numberOfZombies = 90;
        } else {
            this.numberOfZombies = 120;
        }
    }

    public void generateNumberHumans() {
        int RandomNumber = (int) this.random(4);
        if (RandomNumber == 0) {
            this.numberOfHumans = 30;
        } else if (RandomNumber == 1) {
            this.numberOfHumans = 60;
        } else if (RandomNumber == 2) {
            this.numberOfHumans = 90;
        } else {
            this.numberOfHumans = 120;
        }
    }

    private void addHumans(ArrayList<Human> humans) {
        for (int i = 0; i < numberOfHumans; ++i) {
            Human temp = new Human(this, (int) random(30, 970), (int) random(600, 700));
            humans.add(temp);
            humanCount++;
            System.out.println("Human added with strength: " + temp.strength);
        }
    }

    private void addZombies(ArrayList<Zombie> zombies) {
        for (int i = 0; i < numberOfZombies; ++i) {
            Zombie temp = new Zombie(this, (int) random(30, 970), (int) random(200, 300));
            zombies.add(temp);
            zombieCount++;
            System.out.println("Zombie added with stregth: " + temp.strength);
        }
    }

    private void displayHumans(ArrayList<Human> humans) {
        for (Human human : humans) {
            human.display();
            displayTypeCount();
            human.move();
            human.walk();
        }
    }

    private void displayZombies(ArrayList<Zombie> zombies) {
        for (Zombie zombie : zombies) {
            zombie.display();
            displayTypeCount();
            zombie.move();
            zombie.walk();
        }
    }

    public void displayTypeCount() {
        this.textFont(font);
        // text(str, x1, y1, x2, y2)
        //this.textSize(30);
        this.fill(0);
        this.text("Zombie Count: " + zombieCount, 400, 150, 445, 175);
        this.text("Zombie wins: " + zombieWins, 400, 200, 445, 225);
        this.text("Human Count: " + humanCount, 400, 650, 445, 675);
        this.text("Human wins: " + humanWins, 400, 700, 445, 725);
    }

    private void displayParticleSystem(ArrayList<ParticleSystem> particles) {
        for (ParticleSystem p : particles) {
            p.update();
            p.draw();
        }
    }

    public boolean collisionCheck(Human human, Zombie zombie) {//pass human and zombie object
        return (human.touching(zombie));
    }

    public void collision() {
        for (int i = humans.size() - 1; i >= 0; i--) {
            for (int j = zombies.size() - 1; j >= 0; j--) {
                //for (int k = aliens.size() - 1; k >= 0; k--) {
                //Alien a1 = aliens.get(k);
                Human h1 = humans.get(i);
                Zombie z1 = zombies.get(j);
                if (collisionCheck(h1, z1) && (z1.strength == 0)) {
                    float tempZombieX = z1.getX();
                    float tempZombieY = z1.getY();
                    zombies.remove(j);
                    System.out.println("zombie in the :" + j + "location removed");
                    zombieCount--;
                    ParticleSystem p = new ParticleSystem((int) tempZombieX, (int) tempZombieY, this);
                    p1.add(p);
                } else if (collisionCheck(h1, z1) && (h1.strength == 0)) {
                    h1.colour = color(random(59, 42), random(156, 242), random(17, 99),150);
                    h1.setYVelocity((float) .5);
                    file.play();
                    h1.setStrength(5);
                    humanCount--;
                    zombieCount++;
                    break;
                } else if (collisionCheck(h1, z1) && (h1.strength == z1.strength)) {
                    try {
                        Person winningPlayer = playRockPaperScissors(h1, z1);
                        winningPlayer.colour = color(212, 175, 55,150);
                        if (winningPlayer instanceof Human) {
                            humanWins++;
                            System.out.println("Human here");
                        } else if (winningPlayer instanceof Zombie) {
                            zombieWins++;
                            System.out.println("Zombie here");
                        }
                    } catch (Exception e) {
                        //learned about how exception works and when it would be good to use it.
                        //My program kept freezing and I used this to figure out the problem :)
                        System.out.println("Exception thrown : " + e);
                    }
                }
                //}
            }
        }
    }

    public int rockPaperScissorRules(String zombieShoot, String humanShoot) {
        if (zombieShoot.equals("Rock")) {
            if (humanShoot.equals("Paper")) {
                System.out.println("Human win. Paper Covers Rock");
                winner = 0;
            } else if (humanShoot.equals("Scissors")) {
                System.out.println("Zombie win, Scissors breaks rock.");
                winner = 1;
            } else {
                System.out.println("Draw. Rock and Rock");
                winner = 2;
            }
        }
        if (zombieShoot.equals("Paper")) {
            if (humanShoot.equals("Rock")) {
                System.out.println("Zombie win. Paper Covers Rock");
                winner = 1;
            } else if (humanShoot.equals("Scissors")) {
                System.out.println("Human win, Scissors cuts paper.");
                winner = 0;
            } else {
                System.out.println("Draw. Paper and Paper");
                winner = 2;
            }
        }
        if (zombieShoot.equals("Scissor")) {
            if (humanShoot.equals("Rock")) {
                System.out.println("Human win. Rock breaks Scissors");
                winner = 0;
            } else if (humanShoot.equals("Paper")) {
                System.out.println("Zombie win, Scissors cuts paper.");
                winner = 1;
            } else
                System.out.println("Draw. Scissor and Scissor");
            winner = 2;
        }
        return winner;
    }

    public Person playRockPaperScissors(Human human, Zombie zombie) {
        String humanShoot = human.rockPaperScissorGuessSelector();
        String zombieShoot = zombie.rockPaperScissorGuessSelector();
        int answer = rockPaperScissorRules(humanShoot, zombieShoot);
        if (answer == 0) {
            human.strength++;
            Person winningPerson = human;
            return winningPerson;
        } else if (answer == 1) {
            zombie.strength++;
            Person winningPerson = zombie;
            return winningPerson;
        } else {
            System.out.println("Draw.");
            zombie.setStrength(8);
            human.setStrength(9);
        }
        Person person = new Alien(this, (int) random(30, 970), (int) random(600, 700));
        return person;
    }
}

    //check to see if a objects intersect

//    public boolean collideWithAlien(Human human, Zombie zombie,Alien alien){
//        return (alien.touching(human)) || alien.touching(zombie);
//    }



//    private void displayAliens (ArrayList<Alien> aliens) {
//        for (Alien alien : aliens) {
//            alien.display();
//            alien.move();
//            alien.walk();
//        }
//    }

