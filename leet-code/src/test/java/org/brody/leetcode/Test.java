package org.brody.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String version = sc.nextLine();
            List<String> list = new ArrayList<>();
            String[] split = version.split("\\.");
            list.add(split[0]);
            list.add(split[1]);
            if (split.length == 3) {
                String[] split1 = split[2].split("-");
                list.add(split1[0]);
                if (split1.length == 2) {
                    list.add(split1[1]);
                }
            }
            System.out.println(list);
        }
    }
}
