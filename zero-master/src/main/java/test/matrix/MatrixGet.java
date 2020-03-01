package test.matrix;

import java.util.ArrayList;

public class MatrixGet {
    class Direction {
        int x;
        int y;
        Direction next;

        public Direction(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    /**
     * {
     * 1, 2, 3, 4
     * 5, 6, 7, 8
     * 9,10,11,12
     * }
     *
     * @param matrix
     * @return
     */
    public ArrayList<Integer> get(int[][] matrix) {
        Direction right = new Direction(0, 1);
        Direction down = new Direction(1, 0);
        Direction left = new Direction(0, -1);
        Direction up = new Direction(-1, 0);

        right.next = down;
        down.next = left;
        left.next = up;
        up.next = right;

        Direction d = right;
        int maxX = matrix.length;
        int maxY = matrix[0].length;
        int x = 0;
        int y = 0;
        int countAll = maxX * maxY;

        ArrayList<Integer> integers = new ArrayList<>();

        while (integers.size() < countAll) {
            integers.add(matrix[x][y]);
            matrix[x][y] = 0;
            while (integers.size() < countAll) {
                int nextX = x + d.x;
                int nextY= y + d.y;
                if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY< maxY && matrix[nextX][nextY] != 0) {
                    x = nextX;
                    y = nextY;
                    break;
                }
                d = d.next;
            }
        }
        return integers;
    }

    public static void main(String[] args) {
        MatrixGet matrixGet = new MatrixGet();
        int[][] arr = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        matrixGet.get(arr);
    }
}
