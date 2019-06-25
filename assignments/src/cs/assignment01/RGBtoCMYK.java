package cs.assignment01;

public class RGBtoCMYK {
    public static void main(String[] args) {
        int red = Integer.parseInt(args[0]);
        int green = Integer.parseInt(args[1]);
        int blue = Integer.parseInt(args[2]);
        int white = Math.max(red/255, Math.max(green/255, blue/255));
        int cyan = (white - red/255)/white;
        int magenta = (white - green/255)/white;
        int yellow = (white - blue/255)/white;
        int black = 1 - white;
        System.out.println(cyan);
        System.out.println(magenta);
        System.out.println(yellow);
        System.out.println(black);
    }
}
