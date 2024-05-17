/*
 * NumberGenerator.java
 *
 * Hong Kong Mark Six Simulator is a stand-alone application
 * simulating Hong Kong lottery.
 *
 * This class or interface is part of the Mark Six project.
 * The class or interface must not be used outside of this context.
 */
package com.yktsang.marksix.util;

import com.yktsang.marksix.entity.MarkSixBall;

import java.awt.*;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Generates the Mark Six numbers.
 *
 * @author Tsang Yiu Kee Kay
 * @version 1.0
 */
public class NumberGenerator {

    /**
     * The winning numbers.
     */
    private static Set<Integer> winningNumbers = new TreeSet<>();

    /**
     * Generates the available numbers.
     *
     * @param colors the array of colors
     * @return the available numbers
     */
    private static Set<Integer> generateNumbers(List<Color> colors) {
        Map<Integer, MarkSixBall> ballMap = MarkSixUtil.getNumberMap();
        Collection<MarkSixBall> col = ballMap.values();
        Set<Integer> redBalls = col.stream()
                .filter(c -> Color.RED.equals(c.color()))
                .map(MarkSixBall::number)
                .collect(Collectors.toSet());
        Set<Integer> blueBalls = col.stream()
                .filter(c -> Color.BLUE.equals(c.color()))
                .map(MarkSixBall::number)
                .collect(Collectors.toSet());
        Set<Integer> greenBalls = col.stream()
                .filter(c -> Color.GREEN.equals(c.color()))
                .map(MarkSixBall::number)
                .collect(Collectors.toSet());
        Set<Integer> coloredNumbers = new HashSet<>();
        for (Color color : colors) {
            if (color.equals(Color.RED)) {
                coloredNumbers.addAll(redBalls);
            }
            if (color.equals(Color.BLUE)) {
                coloredNumbers.addAll(blueBalls);
            }
            if (color.equals(Color.GREEN)) {
                coloredNumbers.addAll(greenBalls);
            }
        }
        return coloredNumbers;
    }

    /**
     * Generates the winning numbers.
     *
     * @param colors the array of colors
     * @return the winning numbers
     */
    public static Set<Integer> generateWinningNumbers(List<Color> colors) {
        Set<Integer> generatedNumbers = new TreeSet<>();
        Random random = new Random();
        Set<Integer> coloredNumbers = generateNumbers(colors);
        List<Integer> tempList = new ArrayList<>(coloredNumbers);
        while (generatedNumbers.size() != 6) {
            int num = tempList.get(random.nextInt(tempList.size()));
            generatedNumbers.add(num);
        }
        NumberGenerator.winningNumbers = generatedNumbers;
        return generatedNumbers;
    }

    /**
     * Generates the extra number from the numbers not in the
     * colored winning numbers.
     *
     * @param colors the array of colors
     * @return the extra number
     */
    public static int generateExtraNumber(List<Color> colors) {
        Random random = new Random();
        Set<Integer> coloredNumbers = generateNumbers(colors);
        List<Integer> tempList = new ArrayList<>(coloredNumbers);
        int extraNumber = tempList.get(random.nextInt(tempList.size()));
        do {
            if (NumberGenerator.winningNumbers.contains(extraNumber)) {
                extraNumber = tempList.get(random.nextInt(tempList.size()));
            }
        } while (NumberGenerator.winningNumbers.contains(extraNumber));
        return extraNumber;
    }

}
