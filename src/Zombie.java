/**
 * This is the Zombie class. This class extends the person class and helps create instances of a zombie.
 * In this class, the selection for the zombies rock, paper, scissor response is created.
 */
import processing.core.PApplet;

public class Zombie extends Person{
    int zombieCount = 0;
    private String zombieShoot;

    Zombie(PApplet zombieSketch,float x, float y){
        super(zombieSketch,x,y);
        this.colour =  personSketch.color(personSketch.random(59,42),personSketch.random(156,242),personSketch.random(17,99),155);
        this.yVelocity = (float) .5;
        zombieCount++;
    }
    public String rockPaperScissorGuessSelector() {
        choice = (int) this.personSketch.random(2);
        if(choice == 0){
            zombieShoot = "Rock";
        } else if (choice == 1) {
            zombieShoot = "Paper";
        } else{ zombieShoot = "Scissors";
        }
        return zombieShoot;
    }
}
