package pckg_23_24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class GameStats {

    private static HashMap<Player, List<GameScore>> playersData;
    private static HashMap<Player, Float> avgScores;

    public GameStats() {
        playersData = new HashMap<>();
        avgScores = new HashMap<>();
    }

    public void showPlayerStats(Player player){
        System.out.println("_________________________");
        System.out.println("Player: " + player + "- stats: ");
        for (GameScore gameScore : playersData.get(player)){
            System.out.println(gameScore.getAttempts());
        }
        System.out.println("_________________________");
        System.out.println("Average score: " + avgScores.get(player) + " attempts per guessed country. ");
    }

    public void addPlayerStats(Player player, GameScore gameScore){
        List<GameScore> list = new ArrayList<>();
        playersData.putIfAbsent(player, list);
        playersData.get(player).add(gameScore);
        float avg = calcAvgScore(player);
        avgScores.put(player, avg);
        System.out.println("Player stats is created and updated!\n" +
                           "Players avg score updated!");
    }

    public void listAllStats(){
        System.out.println("==================================== Player's stats ====================================");
        for (Player player : playersData.keySet()) {
            System.out.println("Player: " + player);
            System.out.println("_____________________________________________________________");
            for(GameScore gameScore : playersData.get(player)) {
                System.out.println("Game score: " +gameScore.getAttempts());
            }
            System.out.println("Avg score:" + avgScores.get(player));
        }
    }

    private float calcAvgScore(Player player){
        List<GameScore> gameScores = playersData.get(player);
        List<Integer> scores = gameScores.getFirst().getAttempts();
        float sum = 0;
        for (Integer i : scores){
            sum += i;
        }

        return sum/scores.size();
    }
}
