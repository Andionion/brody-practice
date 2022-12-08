package org.brody.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String version1 = sc.nextLine();
        String version2 = sc.nextLine();
        String result = version1;
        List<String> version1List = split(version1);
        List<String> version2List = split(version2);
        for (int i = 0; i < 4; i++) {
            String v14 = version1List.get(i);
            String v24 = version2List.get(i);
            
            if (i == 3) {
                // 里程碑版本不一致
                int index = 0;
                while (index < v14.length() && index < v24.length()) {
                    if (v24.indexOf(index) > v14.indexOf(index)) {
                        result = version2;
                        break;
                    }
                    if (v14.indexOf(index) > v24.indexOf(index)) {
                        result = version1;
                        break;
                    }
                    index++;
                }
                break;
            }

        }
    }

    private static List<String> split(String version) {
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
        return list;
    }
}
