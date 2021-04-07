package com.log.zhouchen.leetcode.solution1247;

/**
 *
 *
 有两个长度相同的字符串 s1 和 s2，且它们其中 只含有 字符 "x" 和 "y"，你需要通过「交换字符」的方式使这两个字符串相同。
 每次「交换字符」的时候，你都可以在两个字符串中各选一个字符进行交换。
 交换只能发生在两个不同的字符串之间，绝对不能发生在同一个字符串内部。也就是说，我们可以交换 s1[i] 和 s2[j]，但不能交换 s1[i] 和 s1[j]。
 最后，请你返回使 s1 和 s2 相同的最小交换次数，如果没有方法能够使得这两个字符串相同，则返回 -1 。
 *
 输入：s1 = "xx", s2 = "yy"
 输出：1
 解释：
 交换 s1[0] 和 s2[1]，得到 s1 = "yx"，s2 = "yx"。

 输入：s1 = "xy", s2 = "yx"
 输出：2
 解释：
 交换 s1[0] 和 s2[0]，得到 s1 = "yy"，s2 = "xx" 。
 交换 s1[0] 和 s2[1]，得到 s1 = "xy"，s2 = "xy" 。
 注意，你不能交换 s1[0] 和 s1[1] 使得 s1 变成 "yx"，因为我们只能交换属于两个不同字符串的字符。

 * @author: shenzhouchen
 * @date: 2020/1/27 6:29 PM
 **/
public class Solution {

    /**
     * s1，s2不为空，长度相同，且都是由x/y字符组成
     * 1 <= s1.length, s2.length <= 1000
     */
    public int minimumSwap(String s1, String s2) {
        // xy表示相同位置下 s1对应位置为x，s2对应位置为y 的数量
        // yx表示相同位置下 s1对应位置为y，s2对应位置为x 的数量
        int xy = 0, yx = 0;
        int length = s1.length();
        for (int i = 0; i < length; i++) {
            char char1 = s1.charAt(i);
            char char2 = s2.charAt(i);
            if (char1 == char2) {
                continue;
            }

            // 该位置字符有差异
            if (char1 == 'x') {
                xy ++;
            } else {
                yx ++;
            }
        }

        // s1中 xx，s2中 yy， 或者 s1中 yy，s2中 xx  只需要移动1次就可以相等
        int count = xy / 2 + yx / 2;

        // s1中 xy, s2中 yx，需要移动2次
        int xyLeft = xy % 2;
        int yxLeft = yx % 2;
        if (xyLeft != yxLeft) {
            return -1;
        }
        // 此处 xyLeft 和 yxLeft相等，要么都为1，要么都为0
        count = count + xyLeft * 2;
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minimumSwap("xxyyxyxyxx", "xyyxyxxxyx"));
    }
}
