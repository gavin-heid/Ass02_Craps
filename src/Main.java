import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Random rnd = new Random();
        Scanner in = new Scanner(System.in);
        int crapsRoll = 0;
        int thePoint = 0;
        int roll = 0;
        boolean done = false;
        boolean done2 = false;
        boolean win = false;
        String playAgain;
        int rollCounter = 0;//initalize stuffs
        System.out.println("Welcome to Craps!");
        do {//loop for if they are done playing
            done = false;
            do {//loop for if they won or lost
                rollCounter++;
                int die1 = rnd.nextInt(6);//dice rolls
                int die2 = rnd.nextInt(6);
                die1 = die1 + 1;
                die2 = die2 + 1;
                crapsRoll = die1 + die2;

                System.out.println("You rolled " + die1 + " and " + die2);
                System.out.println("Your roll total is " + crapsRoll);//see what they rolled
                switch (crapsRoll) {//testing if they won or lost
                    case 7:
                    case 11:
                        win = true;
                        System.out.println("You win, you rolled a " + crapsRoll);
                        break;
                    case 2:
                    case 3:
                    case 12:
                        System.out.println("You lost, you rolled a " + crapsRoll);
                        win = true;
                        break;
                    default:
                        if (crapsRoll == thePoint) {//did they get the point or not
                            System.out.println("You win, you rolled the point");
                            System.out.println("You rolled " + die1 + " and " + die2);
                            win = true;
                        }
                        if (rollCounter == 1) {//setting the point at the beginning and never again
                            thePoint = crapsRoll;
                            System.out.println("You didnt win or lose, " + crapsRoll + " is now the point. Please roll again.");
                            win = false;
                        }

                }
            }while (!win);
            do{//see if they want to play again
                System.out.println("Would you like to play again? (Y/N)");
                playAgain = in.next().toUpperCase();
                switch (playAgain) {
                    case "N":
                        done2 = true;
                        done = true;
                        break;
                    case "Y":
                        rollCounter = 0;
                        done2 = true;
                        done = false;
                        break;
                    default:
                            System.out.println("Invalid choice! Please choose Y or N");
                    }

                }while (!done2);
            }while (!done);
        }
    }

