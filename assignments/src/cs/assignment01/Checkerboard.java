package cs.assignment01;

public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        char grid[][] = new char[2*n][2*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int c = (i + j) % 2;
                if (c == 0) grid[i][j] = '*';
                else {
                    grid[i][j] = ' ';
                }
            }
        }
    }
}
