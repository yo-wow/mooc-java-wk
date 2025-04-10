package castle;

public class HandlerBye extends Handler{
    public HandlerBye(Game game) {
        super(game);
    }

    @Override
    public void handle(String word) {
        System.out.println("感谢您的光临。再见！");
    }

    @Override
    public boolean bye() {
        return true;
    }
}
