package course;

public class Display {
    private int value = 0;
    private int limit = 0;

    public Display(int limit) {
        this.limit = limit;
    }

    public boolean increase() {
        this.value++;
        if (this.value == this.limit) {
            this.value = 0;
            return true;
        }
        return false;
    }

    public int getValue() {
        return this.value;
    }
}
