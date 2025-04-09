package course;

public class Clock {
    private Display hour;
    private Display minute;
    public Clock(Display hour, Display minute) {
        this.hour = hour;
        this.minute = minute;
    }

    public void start() {
        while (true) {
            boolean flip = this.minute.increase();
            if (flip) {
                hour.increase();
            }
            System.out.printf("%02d:%02d\n", hour.getValue(), minute.getValue());
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        Clock clock = new Clock(new Display(24), new Display(60));
        clock.start();
    }
}
