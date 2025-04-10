package castle;

public class Handler {
    protected Game game;

    public Handler(Game game) {
        this.game = game;
    }

    public void handle(String word) {

    }

    public boolean bye() {
        return false;
    }
}
