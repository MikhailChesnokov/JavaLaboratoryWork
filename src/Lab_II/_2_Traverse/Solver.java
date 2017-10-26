package Lab_II._2_Traverse;

public class Solver {
    static int n = 5;
    static int value = 1;
    static int[][] array = new int[n+1][n+1];

    public static void main() {
        traverseFirstWay(0,1,1);
        printMatrix();

        traverseSecondWay(1,1);
        printMatrix();

        traverseThirdWay(1);
        printMatrix();
    }

    public static void printMatrix() {
        for (int i = 1; i <= n; i++,System.out.println())
            for (int j = 1; j <= n; j++)
                System.out.printf("%3d",array[i][j]);
        System.out.println();
    }

    public static void traverseFirstWay(int turns, int row, int col) {
        int distance = n - (int)Math.round((float) turns / 2 + 0.25);
        if (distance == 0) return;
        int irow, icol;
        switch (turns % 4) {
            case 0: // Right
                for (icol = col; icol < col + distance; icol++)
                    array[row][icol] = value++;
                traverseFirstWay(++turns, ++row, --icol); break;
            case 1: // Down
                for (irow = row; irow < row + distance; irow++)
                    array[irow][col] = value++;
                traverseFirstWay(++turns,--irow,--col); break;
            case 2: // Left
                for (icol = col; icol > col - distance; icol--)
                    array[row][icol] = value++;
                traverseFirstWay(++turns,--row,++icol); break;
            case 3: // Up
                for (irow = row; irow > row - distance; irow--)
                    array[irow][col] = value++;
                traverseFirstWay(++turns, ++irow, ++col); break;
        }
    }

    public static void traverseSecondWay(int row, int col) {
        array[col][row] = value++;
        if (row == n && col == n) return;

        if ((row + col) % 2 == 0)
            if (row == n)
                traverseSecondWay(row, ++col);
            else
                traverseSecondWay(++row, col == 1 ? col : --col);
        else
            if (col == n)
                traverseSecondWay(++row, col);
            else
                traverseSecondWay(row == 1 ? row : --row, ++col);
    }

    public static void traverseThirdWay(int col) {
        if (col > n) return;
        else
            if (col % 2 == 0) {
                for (int row = n; row > 0; row--)
                    array[row][col] = value++;
                traverseThirdWay(++col);
            }
            else {
                for (int i = 1; i <= n; i++)
                    array[i][col] = value++;
                traverseThirdWay(++col);
            }
    }
}