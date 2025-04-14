package castle;

public abstract class Handler {
    abstract void handle(String word);

    public boolean bye() {
        return false;
    }
}
