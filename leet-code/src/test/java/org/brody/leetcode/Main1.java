package org.brody.leetcode;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Main1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String in = sc.nextLine();
        String[] split = in.split(",");
        long taskA = Integer.parseInt(split[0]);
        long taskB = Integer.parseInt(split[1]);
        long num = Integer.parseInt(split[2]);
        Set<Long> result = new HashSet<>();
        for (long i = num; i >= 0; i--) {
            long time = taskA * i + taskB * (num - i);
            result.add(time);
        }
        result = result.stream().sorted().collect(Collectors.toCollection(LinkedHashSet::new));
        System.out.println(result);
    }
}
