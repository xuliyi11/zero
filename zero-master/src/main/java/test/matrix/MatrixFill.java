package test.matrix;

public class MatrixFill {
    public void func(int[][] matrix) {
        class Direction {
            int x;
            int y;
            Direction next;

            public Direction(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }
        Direction right = new Direction(0, 1);
        Direction down = new Direction(1, 0);
        Direction left = new Direction(0, -1);
        Direction up = new Direction(-1, 0);
        right.next = down;
        down.next = left;
        left.next = up;
        up.next = right;


        Direction d = right;

        int xlen = matrix.length;//数组行的长度
        int ylen = matrix[0].length; //数组列的长度
        int count = matrix.length * matrix[0].length; //数组里面数字的大小
        int x = 1; //初始化数字大小
        int ix = 0; //初始化横坐标大小
        int iy = 0;//初始化纵坐标大小
        while (true) {
            matrix[ix][iy] = x;
            if(x == count){
                break;
            }
            while (true) {
                int nextX = ix + d.x;
                int nextY = iy + d.y;
                if (nextX >= 0 && nextX < xlen && nextY >= 0 && nextY < ylen && matrix[nextX][nextY] == 0) {
                    ix = nextX;
                    iy = nextY;
                    x++;
                    break;
                }
                d = d.next;
            }
        }
        System.out.println(matrix);
    }

    public static void main(String[] args) {
        MatrixFill matrix = new MatrixFill();
        matrix.func(new int[3][4]);
    }
}
