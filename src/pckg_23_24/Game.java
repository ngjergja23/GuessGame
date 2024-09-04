package pckg_23_24;

import java.util.Scanner;

public class Game {

    private boolean play;
    private boolean in_same_guess;
    private Player player;
    private GameScore gameScore;
    private  GameStats gameStats;
    private String playerGuess;
    private Scanner scanner;

    public Game() {
        gameScore = new GameScore();
        gameStats = new GameStats();
    }

    public void startGame(Player player){

        scanner = new Scanner(System.in);
        System.out.println("--------- Starting a new Game ---------");
        int totalAttempts = 0;
        play = true;
        while (play) {
            System.out.println("Guess this: ");
            //generates a country to guess (once per round)
            String country2Guess = GuessGame.pickRandomCountry();
            int attempts = 0;
            in_same_guess = true;
            while (in_same_guess) {
                //displays a masked country (multiple times if user wants to guess again)
                GuessGame.printGuessFields(country2Guess);
                System.out.println("Please enter your guess...");
                playerGuess = scanner.nextLine();
                attempts++;
                //check if playerGuess is equal to masked country to guess
                if (GuessGame.checkGuess(playerGuess, country2Guess)) {
                    System.out.println("You won!");
                    System.out.println("Your guess: " + playerGuess + " == " + country2Guess);
                    gameScore.addScore(attempts);
                    in_same_guess = false;
                } else {
                    System.out.println("You missed!");
                    System.out.println("Your guess: " + playerGuess + " != lookup country");

                    System.out.println("Guess again? 'y' for yes, other for no: ");
                    Scanner s = new Scanner(System.in);
                    String cont = s.next().toLowerCase();
                    if (!cont.equals("y")){
                        in_same_guess = false;
                    }
                }
            }
            System.out.println("====================================");
            proceedToPlay();
//            gameScore.listAttempts();
        }
        System.out.println("You chose to quit the game! ");

        gameStats.addPlayerStats(player, gameScore);
        gameStats.showPlayerStats(player);
        gameStats.listAllStats();
    }

    public void proceedToPlay(){
        System.out.println("To proceed enter 'y',any other to quit: ");
        Scanner sc = new Scanner(System.in);
        String cont = sc.next();
        if (cont.equals("y")){
            // game continues
            play = true;
        }else {
            // game exit - stats shown
            play = false;
        }
    }

}
