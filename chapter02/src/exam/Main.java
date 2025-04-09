package exam;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            Clock clock = new Clock(getLegalIn(23, in), getLegalIn(59, in), getLegalIn(59, in));
            clock.tick();
            System.out.println(clock);
        }
    }

    public static int getLegalIn(int limit, Scanner in) {
        int legalIn;
        do {
            System.out.printf("Please input legal int, this value need less than %s:%n", limit);
            legalIn = in.nextInt();
        } while (legalIn > limit);

        return legalIn;
    }
}

class Clock {
    private final Display hours;
    private final Display minutes;
    private final Display seconds;

    public Clock(int hours, int minutes, int seconds) {
        this.hours = new Display(hours, 24);
        this.minutes = new Display(minutes, 60);
        this.seconds = new Display(seconds, 60);
    }

    public void tick() {
        boolean minutesFlip = this.seconds.increase();
        if (minutesFlip) {
            boolean hoursFlip = this.minutes.increase();
            if (hoursFlip) {
                this.hours.increase();
            }
        }
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d%n", this.hours.getValue(), this.minutes.getValue(), this.seconds.getValue());
    }
}

class Display {
    private int value;
    private final int limit;

    public Display(int value, int limit) {
        this.value = value;
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
