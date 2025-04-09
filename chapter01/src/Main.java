import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fraction a = new Fraction(in.nextInt(), in.nextInt());
        Fraction b = new Fraction(in.nextInt(), in.nextInt());
        a.print();
        b.print();
        a.plus(b).print();
        a.multiply(b).plus(new Fraction(5, 6)).print();
        a.print();
        b.print();
        in.close();
    }
}

class Fraction {
    int a;
    int b;

    Fraction(int a, int b) {
        this.a = a;
        this.b = b;
    }

    double toDouble() {
        return (double) a / b;
    }

    Fraction plus(Fraction r) {
        // 分子
        int a = this.a * r.b + r.a * this.b;
        // 分母
        int b = this.b * r.b;
        return new Fraction(a, b);
    }

    Fraction multiply(Fraction r) {
        // 分子
        int a = this.a * r.a;
        // 分母
        int b = this.b * r.b;
        return new Fraction(a, b);
    }

    void print() {
        // 2
        while (this.a >= 2 && this.b >= 2 && this.a % 2 == 0 && this.b % 2 == 0) {
            this.a /= 2;
            this.b /= 2;
        }
        // 3
        while (this.a >= 3 && this.b >= 3 && this.a % 3 == 0 && this.b % 3 == 0) {
            this.a /= 3;
            this.b /= 3;
        }
        // 5
        while (this.a >= 5 && this.b >= 5 && this.a % 5 == 0 && this.b % 5 == 0) {
            this.a /= 5;
            this.b /= 5;
        }
        if (toDouble() == 1.0) {
            System.out.println("1");
        } else {
            System.out.printf("%d/%d%n", a, b);
        }
    }
}
