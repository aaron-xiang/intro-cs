package cs.assignment01;

public class RandomWalker {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int t = Integer.parseInt(args[1]);
        int x = 0;
        int y = 0;
        while (t > 0) {
            t = t - 1;
            while (n > 0) {
                double a = Math.random();
                n = n - 1;
                if (a <= 0.25) {
                    x = x + 1;
                } else if (a <= 0.5) {
                    x = x - 1;
                } else if (a <= 0.75) {
                    y = y + 1;
                } else if (a <= 1.00) {
                    y = y - 1;
                }
            }
        }
        System.out.println("squared distance = " + (x * x) + (y * y));
    }
}
