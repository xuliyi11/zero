package test.array;

public class AroundMax {

    class Result {
        int realX;
        int realY;
        int max;

        public Result(int realX, int realY, int max) {
            this.realX = realX;
            this.realY = realY;
            this.max = max;
        }
    }

    /**
     * {
     * {1,2,3,4,5,6,7}
     * {8,9,10,11,12,13,14}
     * {16,17,18,19,10,21,22,23,24}
     * }
     *
     * @param array
     * @param x
     * @param y
     * @return
     */
    public int getAroundMax(int[][] array, int x, int y) {
        if (array == null)
            return 0;
        Result result = new Result(x, y, array[x][y]);

        int maxX = array.length;
        int maxY = array[0].length;

        if (x > 0 && array[x - 1][y] > result.max) {
            result.realX = x - 1;
            result.max = array[x - 1][y];
        }
        if (y < maxY - 1 && array[x][y + 1] > result.max) {
            result.max = array[x][y + 1];
            result.realY = y + 1;
        }
        if (x < maxX - 1 && array[x + 1][y] > result.max) {
            result.realX = x + 1;
            result.max = array[x + 1][y];
        }
        if (y > 0 && array[x][y - 1] > result.max) {
            result.max = array[x][y - 1];
            result.realY = y - 1;
        }

        if (result.max == array[x][y]) {
            return result.max;
        }

        return getAroundMax(array, result.realX, result.realY);
    }

    public static void main(String[] args) {
        int[][] ints = {
                {1, 2, 3, 4, 5, 6, 7},
                {8, 9, 10, 11, 12, 13, 14},
                {16, 17, 18, 19, 10, 21, 22}
        };

        AroundMax aroundMax = new AroundMax();
        System.out.println(aroundMax.getAroundMax(ints, 0, 3));
    }
}
