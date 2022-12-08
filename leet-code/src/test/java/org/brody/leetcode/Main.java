package org.brody.leetcode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        int[][] nums = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            s = s.replace(" ", "");
            for (int j = 0; j < n; j++) {
                nums[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        int result = 1;
        for (int i = 0; i < n; i++) {
            boolean bool = true;
            for (int j = i + 1; j < n; j++) {
                if (nums[i][j] != 1) {
                    bool = false;
                    break;
                }
            }
            if (bool) {
                break;
            }
            result++;
        }
        System.out.println(result);
    }
}
