package cs.assignment01;

public class Ordered {
    public static void main(String[] args) {
        boolean isOrdered = false;
        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);
        int z = Integer.parseInt(args[2]);
        if (x < y && y < z || x > y && y > z) {
            isOrdered = true;
        }
        System.out.println(isOrdered);
    }
}