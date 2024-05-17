/*
 * MarkSixBall.java
 *
 * Hong Kong Mark Six Simulator is a stand-alone application
 * simulating Hong Kong lottery.
 *
 * This class or interface is part of the Mark Six project.
 * The class or interface must not be used outside of this context.
 */
package com.yktsang.marksix.entity;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * The Mark Six Ball having a number, a color, and an image.
 *
 * @param number the number
 * @param color  the color
 * @param image  the image
 * @author Tsang Yiu Kee Kay
 * @version 1.0
 */
public record MarkSixBall(int number, Color color, BufferedImage image) {
}
