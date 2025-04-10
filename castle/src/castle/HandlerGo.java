package castle;

public class HandlerGo extends Handler{
    public HandlerGo(Game game) {
        super(game);
    }

    @Override
    public void handle(String word) {
        game.goRoom(word);
    }
}
