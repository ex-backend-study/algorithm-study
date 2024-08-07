package leeyuna.week1;

import java.util.Arrays;

public class programmers68936 {

    private record Count(int zero, int one) {

        public Count add(Count input) {
            return new Count(zero + input.zero, one + input.one);
        }
    }

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}};
        System.out.println(Arrays.toString(solution(arr)));
    }

    public static int[] solution(int[][] arr) {
        Count count = count(arr, 0, 0, arr.length);
        return new int[]{count.zero, count.one};
    }

    private static Count count(int[][] arr, int offsetX, int offsetY, int size) {
        // (offsetX, offsetY)
        // (offsetX + size, offsetY)
        // (offsetX, offsetY + size)
        // (offsetX + size, offsetY + size)

        // 종료조건 count의 (0, 1) / (1, 0)

        int height = size / 2;

        for (int x = offsetX; x < offsetX + size; x++) {
            for (int y = offsetY; y < offsetY + size; y++) {
                if (arr[x][y] != arr[offsetX][offsetY]) {
                    return count(arr, offsetX, offsetY, height)
                            .add(count(arr, offsetX + height, offsetY, height))
                            .add(count(arr, offsetX, offsetY + height, height))
                            .add(count(arr, offsetX + height, offsetY + height, height));
                }
            }
        }

        if (arr[offsetX][offsetY] == 1) {
            return new Count(0, 1);
        }
        return new Count(1, 0);
    }
}
