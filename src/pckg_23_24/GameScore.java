package pckg_23_24;

import java.util.ArrayList;
import java.util.List;

public class GameScore {

    private List<Integer> attempts;

    public GameScore() {
        this.attempts = new ArrayList<>();
    }

    public void addScore(int attempt){
        attempts.add(attempt);
    }

    public void listAttempts(){
        System.out.println(attempts);
    }

    public List<Integer> getAttempts(){
        return attempts;
    }

}
