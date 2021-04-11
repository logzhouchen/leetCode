package com.log.zhouchen.leetcode.datastructure.parallelogram;

/**
 * 判定 平行四边形
 **/
public class Determine {

    public boolean checkParallelogram(Point a, Point b, Point c, Point d) {
        if (a == null || b == null || c == null || d == null) {
            return false;
        }

        // 判断对边平行
        if (!checkIfSlopeEqual(a, b, c, d) && !checkIfSlopeEqual(a, b, d, c) ) {
            if (!checkIfSlopeEqual(a, c, b, d) && !checkIfSlopeEqual(a, c, d, b) ) {
                return false;
            }
            Point temp = b;
            b = c;
            c = temp;
        }

        // 判断对边长度相等
        double edgeLength1 = calculateEdgeLength(a, b);
        double edgeLength2 = calculateEdgeLength(c, d);
        if (edgeLength1 != edgeLength2) {
            return false;
        }

        // 判断不再一条直线上
        if (checkIfSlopeEqual(a, c, b, c) || checkIfSlopeEqual(a, c, c, b)) {
            return false;
        }

        return true;
    }

    /**
     * 计算斜率是否相等
     */
    private boolean checkIfSlopeEqual(Point a, Point b, Point c, Point d) {
        int sum1 = (b.getY() - a.getY()) * (d.getX() - c.getX());
        int sum2 = (b.getX() - a.getX()) * (d.getY() - c.getY());
        return sum1 == sum2;
    }

    /**
     * 计算边长度
     */
    private double calculateEdgeLength(Point a, Point b) {
        double edge1Sum = Math.pow((b.getY() - a.getY()), 2);
        double edge2Sum = Math.pow((b.getX() - a.getX()), 2);

        return Math.sqrt(edge1Sum + edge2Sum);
    }

    public static void main(String[] args) {
        Determine determine = new Determine();

        Point a = new Point(0, 0);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        Point d = new Point(5, 5);

        System.out.println(determine.checkParallelogram(a, b, c, d));
    }
}
