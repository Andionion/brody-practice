package org.brody.leetcode;

/**
 * 字符串压缩
 * <p>
 * AAAA - A4
 * <p>
 * ABAB - AB2
 * <p>
 * ABCABCC - ABC2C
 */
public class Main3 {

    public static void main(String[] args) {
        getMsg("aaaa");
        getMsg("ABAB");
        getMsg("ABCABCC");
    }

    private static void getMsg(String msg) {
        char[] chars = msg.toCharArray();
        StringBuilder result = new StringBuilder();
        int num = 0;
        int index = 0;
        result.append(msg.charAt(0));
        for (int i = 1; i < chars.length; i++) {
            if (msg.charAt(i) == result.charAt(0)) {
                index = i;
                break;
            }
            result.append(msg.charAt(i));
        }
        int i = 0;
        int j = index;
        while (j <= msg.length()) {
            if (msg.substring(i, j).contentEquals(result)) {
                num++;
                i = j;
                j = j + index;
            }
        }
        String temp = result.toString() + num;
        if (msg.length() % index != 0) {
            temp = temp + msg.substring(msg.length() % index, msg.length() - 1);
        }
        System.out.println(temp);
    }
}
