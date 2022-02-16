// import java.util.*;

public class GameLauncher {

    public static void main(String[] args) {
        GuessGame game = new GuessGame();
        game.startGame();
    }
}

class Player{
    
    int number;

    void guess(){
        number= (int)(Math.random()*10);
        System.out.println("I'm guessing "+number);
    }
}

class GuessGame{

    Player P1;
    Player P2;
    Player P3;

    void startGame()
    {
        P1 = new Player();
        P2 = new Player();
        P3 = new Player();
        System.out.println("Let's Start the Game : ");
        while(true)
        {
            System.out.println("I'm thinking a number between 0 and 9 : ");
            int randomNum = (int)(Math.random()*10);
            System.out.println("Number to guess is : "+randomNum);
            P1.guess();
            P2.guess();
            P3.guess();
            System.out.println("Player 1 guessed "+P1.number);
            System.out.println("Player 2 guessed "+P2.number);
            System.out.println("Player 3 guessed "+P3.number);
            boolean p1Answer = (P1.number == randomNum)? true : false;
            boolean p2Answer = (P2.number == randomNum)? true : false;
            boolean p3Answer = (P3.number == randomNum)? true : false;
            if(p1Answer || p2Answer || p3Answer)
            {
                System.out.println("We have a Winner!!!");
                System.out.println("Player 1 got it right? "+p1Answer);
                System.out.println("Player 2 got it right? "+p2Answer);
                System.out.println("Player 3 got it right? "+p3Answer);
                System.out.println("Gama is Over.");
                break;
            }
            else
            {
                System.out.println("Players will have to try again.");
            }
        }
    }
}