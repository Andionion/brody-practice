package org.brody.leetcode;

import java.util.Scanner;

/**
 * 蛇形矩阵
 * 蛇形矩阵是由 1 开始的自然数依次排列成的一个矩阵上三角形。
 * <p>
 * 例如，当输入 5 时，应该输出的三角形为：
 * <p>
 * 1 3 6 10 15
 * <p>
 * 2 5 9 14
 * <p>
 * 4 8 13
 * <p>
 * 7 12
 * <p>
 * 11
 */
public class SnakeMatrix {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            // 读入正整数n
            int n = in.nextInt();
            // 创建一个n行的矩阵
            int[][] result = new int[n][];
            // 要填入的数字
            int t = 1;
            // 每行开始，然后依次递减每列
            for (int i = 0; i < n; i++) {
                // 每一行有n-i个数字
                result[i] = new int[n - i];
                for (int j = 0; j < i + 1; j++) {
                    result[i - j][j] = t++;
                }
            }

            for (int[] ints : result) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        }
    }
}
