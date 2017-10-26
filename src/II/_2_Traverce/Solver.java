package II._2_Traverce;

public class Solver {
    static int n = 5;
    static int curr = 1;
    static int[][] array = new int[n+2][n+2];

    public static void main() {
        traverseFirstWay(0,1,1);
        printMatrix();
        System.out.println();

        traverseSecondWay(1,1);
        printMatrix();
        System.out.println();

        traverseThirdWay(1);
        printMatrix();
        System.out.println();
    }

    public static void printMatrix() {
        for (int i = 1; i <= n; i++,System.out.println())
            for (int j = 1; j <= n; j++)
                System.out.printf("%3d",array[i][j]);
    }

    public static void traverseFirstWay(int line, int i, int j) {
        int ii,jj;
        int d = n - (int)Math.round((float)line / 2 + 0.25);
        if (d == 0) return;
        switch (line % 4) {
            case 0:
                for (jj = j; jj < j + d; jj++) array[i][jj] = curr++;
                traverseFirstWay(++line, ++i, --jj); break;
            case 1:
                for (ii = i; ii < i + d; ii++) array[ii][j] = curr++;
                traverseFirstWay(++line,--ii,--j); break;
            case 2:
                for (jj = j; jj > j - d; jj--) array[i][jj] = curr++;
                traverseFirstWay(++line,--i,++jj); break;
            case 3:
                for (ii = i; ii > i - d; ii--) array[ii][j] = curr++;
                traverseFirstWay(++line, ++ii, ++j); break;
        }
    }

    public static void traverseSecondWay(int row, int col) {
        array[col][row] = curr++;
        if (row == n && col == n) return;

        if ((row + col) % 2 == 0)
            if (row == n)
                traverseSecondWay(row, ++col); // right
            else
                if (col == 1)
                    traverseSecondWay(++row, col); // down
                else
                    traverseSecondWay(++row, --col); // down left
        else
            if (col == n)
                traverseSecondWay(++row, col); // down
            else
                if (row == 1)
                    traverseSecondWay(row, ++col); // right
                else
                    traverseSecondWay(--row, ++col); // up right
    }

    public static void traverseThirdWay(int count) {
        if (count > n) return;
        else
            if (count % 2 == 0) {
                for (int i = n; i > 0; i--) array[i][count] = curr++;
                traverseThirdWay(++count);
            }
            else {
                for (int i = 1; i <= n; i++) array[i][count] = curr++;
                traverseThirdWay(++count);
            }
    }
}
