import java.util.Scanner;

public class NQueen {
    static int N;
    static int[] board;
    static boolean found = false;

    static boolean isSafe(int row, int col) {
        for (int i = 1; i < row; i++) {
            if (board[i] == col)
                return false;

            if (Math.abs(board[i] - col) == Math.abs(i - row))
                return false;
        }
        return true;
    }

    static void nQueen(int row) {
        if (row > N) {
            found = true;

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (board[i] == j)
                        System.out.print("Q ");
                    else
                        System.out.print(". ");
                }
                System.out.println();
            }
            System.out.println();
            return;
        }

        for (int col = 1; col <= N; col++) {
            if (isSafe(row, col)) {
                board[row] = col;
                nQueen(row + 1);
                board[row] = 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        N = sc.nextInt();

        board = new int[N + 1];

        nQueen(1);

        if (!found)
            System.out.println("No solution exists for N = " + N);

        sc.close();
    }
}