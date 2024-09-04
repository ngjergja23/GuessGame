package pckg_23_24;

public class Player {
    private String name;
    private static int cntID = 10;
    private int id;

    public Player(String name) {
        this.name = name;
        this.id = cntID++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
