/*
 * MarkSixUtil.java
 *
 * Hong Kong Mark Six Simulator is a stand-alone application
 * simulating Hong Kong lottery.
 *
 * This class or interface is part of the Mark Six project.
 * The class or interface must not be used outside of this context.
 */
package com.yktsang.marksix.util;

import com.yktsang.marksix.entity.MarkSixBall;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

/**
 * Provides the common utilities for the application.
 *
 * @author Tsang Yiu Kee Kay
 * @version 1.0
 */
public class MarkSixUtil {

    /**
     * The map of numbers. The number is represented as
     * a <code>MarkSixBall</code>.
     */
    private static final Map<Integer, MarkSixBall> numberMap
            = new TreeMap<>();

    /**
     * Populates the <code>numberMap</code>. Each number represents
     * a <code>MarkSixBall</code>.
     */
    public static void loadNumberMap() {
        try {
            numberMap.put(1, new MarkSixBall(1, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                    .getClassLoader().getResourceAsStream(
                            "com/yktsang/marksix/entity/img/no_01.gif")))));
            numberMap.put(2, new MarkSixBall(2, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_02.gif")))));
            numberMap.put(3, new MarkSixBall(3, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_03.gif")))));
            numberMap.put(4, new MarkSixBall(4, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_04.gif")))));
            numberMap.put(5, new MarkSixBall(5, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_05.gif")))));
            numberMap.put(6, new MarkSixBall(6, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_06.gif")))));
            numberMap.put(7, new MarkSixBall(7, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_07.gif")))));
            numberMap.put(8, new MarkSixBall(8, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_08.gif")))));
            numberMap.put(9, new MarkSixBall(9, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_09.gif")))));
            numberMap.put(10, new MarkSixBall(10, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_10.gif")))));
            numberMap.put(11, new MarkSixBall(11, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_11.gif")))));
            numberMap.put(12, new MarkSixBall(12, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_12.gif")))));
            numberMap.put(13, new MarkSixBall(13, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_13.gif")))));
            numberMap.put(14, new MarkSixBall(14, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_14.gif")))));
            numberMap.put(15, new MarkSixBall(15, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_15.gif")))));
            numberMap.put(16, new MarkSixBall(16, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_16.gif")))));
            numberMap.put(17, new MarkSixBall(17, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_17.gif")))));
            numberMap.put(18, new MarkSixBall(18, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_18.gif")))));
            numberMap.put(19, new MarkSixBall(19, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_19.gif")))));
            numberMap.put(20, new MarkSixBall(20, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_20.gif")))));
            numberMap.put(21, new MarkSixBall(21, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_21.gif")))));
            numberMap.put(22, new MarkSixBall(22, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_22.gif")))));
            numberMap.put(23, new MarkSixBall(23, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_23.gif")))));
            numberMap.put(24, new MarkSixBall(24, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_24.gif")))));
            numberMap.put(25, new MarkSixBall(25, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_25.gif")))));
            numberMap.put(26, new MarkSixBall(26, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_26.gif")))));
            numberMap.put(27, new MarkSixBall(27, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_27.gif")))));
            numberMap.put(28, new MarkSixBall(28, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_28.gif")))));
            numberMap.put(29, new MarkSixBall(29, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_29.gif")))));
            numberMap.put(30, new MarkSixBall(30, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_30.gif")))));
            numberMap.put(31, new MarkSixBall(31, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_31.gif")))));
            numberMap.put(32, new MarkSixBall(32, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_32.gif")))));
            numberMap.put(33, new MarkSixBall(33, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_33.gif")))));
            numberMap.put(34, new MarkSixBall(34, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_34.gif")))));
            numberMap.put(35, new MarkSixBall(35, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_35.gif")))));
            numberMap.put(36, new MarkSixBall(36, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_36.gif")))));
            numberMap.put(37, new MarkSixBall(37, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_37.gif")))));
            numberMap.put(38, new MarkSixBall(38, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_38.gif")))));
            numberMap.put(39, new MarkSixBall(39, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_39.gif")))));
            numberMap.put(40, new MarkSixBall(40, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_40.gif")))));
            numberMap.put(41, new MarkSixBall(41, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_41.gif")))));
            numberMap.put(42, new MarkSixBall(42, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_42.gif")))));
            numberMap.put(43, new MarkSixBall(43, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_43.gif")))));
            numberMap.put(44, new MarkSixBall(44, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_44.gif")))));
            numberMap.put(45, new MarkSixBall(45, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_45.gif")))));
            numberMap.put(46, new MarkSixBall(46, Color.RED,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_46.gif")))));
            numberMap.put(47, new MarkSixBall(47, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_47.gif")))));
            numberMap.put(48, new MarkSixBall(48, Color.BLUE,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_48.gif")))));
            numberMap.put(49, new MarkSixBall(49, Color.GREEN,
                    ImageIO.read(Objects.requireNonNull(MarkSixUtil.class
                            .getClassLoader().getResourceAsStream(
                                    "com/yktsang/marksix/entity/img/no_49.gif")))));
        } catch (IllegalArgumentException | IOException ex) {
            System.err.println(ex.getMessage());
        }
    }

    /**
     * Returns the <code>numberMap</code>.
     *
     * @return the numberMap
     */
    public static Map<Integer, MarkSixBall> getNumberMap() {
        return numberMap;
    }

    /**
     * Calculates the factorial of a number n!.
     * Formula = n * (n-1) * (n-2) * ... * 1
     *
     * @param n the number to calculate
     * @return the factorial
     */
    public static BigInteger factorial(int n) {
        BigInteger factorial = BigInteger.ONE;
        if (n == 1) {
            return BigInteger.ONE;
        } else {
            for (int i=n; i >= 1; i--) {
                factorial = factorial.multiply(BigInteger.valueOf(i));
            }
            return factorial;
        }
    }

    /**
     * Calculates the combination C(n,k).
     * Given n, choose k.
     * Formula = n! / [(n-k)! * k!].
     *
     * @param num the total available number
     * @param choose the number to choose
     * @return the combination
     */
    public static BigInteger combination(int num, int choose) {
        return factorial(num).divide(factorial(num - choose).multiply(factorial(choose)));
    }

}
