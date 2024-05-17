/*
 * MarkSixClient.java
 *
 * Hong Kong Mark Six Simulator is a stand-alone application
 * simulating Hong Kong lottery.
 *
 * This class or interface is part of the Mark Six project.
 * The class or interface must not be used outside of this context.
 */
package com.yktsang.marksix.client;

import com.yktsang.marksix.entity.MarkSixBall;
import com.yktsang.marksix.util.MarkSixUtil;
import com.yktsang.marksix.util.NumberGenerator;
import com.yktsang.marksix.util.WindowPositioner;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Serial;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Represents the main window of the application.
 *
 * @author Tsang Yiu Kee Kay
 * @version 1.0
 */
public class MarkSixClient extends JFrame {

    /**
     * The serial version UID.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The status bar.
     */
    private static MarkSixStatusBar statusBar;

    /**
     * The colors.
     */
    private final List<Color> colors = new ArrayList<>();
    /**
     * The checkbox for red ball.
     */
    JCheckBox redCheckBox;
    /**
     * The checkbox for blue ball.
     */
    JCheckBox blueCheckBox;
    /**
     * The checkbox for green ball.
     */
    JCheckBox greenCheckBox;
    /**
     * The generate button.
     */
    JButton generateButton;
    /**
     * The number panel.
     */
    JPanel numberPanel;

    /**
     * Constructs a <code>MarkSixClient</code>.
     */
    public MarkSixClient() {
        super("Mark Six Simulator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        JPanel buttonPanel = populateButtonPanel();
        JPanel numberPanel = populateNumberPanel();
        mainPanel.add(numberPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        statusBar = new MarkSixStatusBar();
        add(statusBar, BorderLayout.SOUTH);

        add(new MarkSixMenuBar(), BorderLayout.NORTH);

        add(mainPanel, BorderLayout.CENTER);
        pack();
        Rectangle rect = getBounds();
        int x = WindowPositioner.getXPosition(rect);
        int y = WindowPositioner.getYPosition(rect);
        setBounds(x, y, rect.width, rect.height);
        setResizable(false);
        setVisible(true);
    }

    /**
     * Generates the numbers.
     */
    private void generateNumbers() {
        Set<Integer> winningNumbers = NumberGenerator.generateWinningNumbers(colors);
        int extraNumber = NumberGenerator.generateExtraNumber(colors);
        Map<Integer, MarkSixBall> numMap = MarkSixUtil.getNumberMap();
        for (Integer num : winningNumbers) {
            numberPanel.add(new JLabel(new ImageIcon(numMap.get(num).image())));
        }
        numberPanel.add(new JLabel("+"));
        numberPanel.add(new JLabel(new ImageIcon(numMap.get(extraNumber).image())));
    }

    /**
     * Populates the number panel.
     *
     * @return the number panel
     */
    private JPanel populateNumberPanel() {
        colors.add(Color.RED);
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        numberPanel = new JPanel();
        generateNumbers();
        return numberPanel;
    }

    /**
     * Populates the button panel.
     *
     * @return the button panel
     */
    private JPanel populateButtonPanel() {
        JPanel buttonPanel = new JPanel();
        redCheckBox = new JCheckBox(new RedChecker());
        redCheckBox.setSelected(true);
        blueCheckBox = new JCheckBox(new BlueChecker());
        blueCheckBox.setSelected(true);
        greenCheckBox = new JCheckBox(new GreenChecker());
        greenCheckBox.setSelected(true);
        generateButton = new JButton(new Generate());
        buttonPanel.add(redCheckBox);
        buttonPanel.add(blueCheckBox);
        buttonPanel.add(greenCheckBox);
        buttonPanel.add(generateButton);
        return buttonPanel;
    }

    /**
     * Returns the <code>MarkSixStatusBar</code>.
     *
     * @return the status bar
     */
    public static MarkSixStatusBar getStatusBar() {
        return statusBar;
    }

    /**
     * The action for the red balls' checkbox.
     */
    private class RedChecker extends AbstractAction {

        /**
         * The serial version UID.
         */
        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * Constructs a <code>RedChecker</code>.
         */
        public RedChecker() {
            putValue(AbstractAction.NAME, "Red balls");
            putValue(AbstractAction.SHORT_DESCRIPTION, "Red ball");
        }

        /**
         * The action for the red balls' checkbox.
         *
         * @param ae the action event
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (redCheckBox.isSelected()) {
                getStatusBar().setMessage("Red is selected");
                colors.add(Color.RED);
            } else {
                getStatusBar().setMessage("Red is not selected");
                colors.remove(Color.RED);
            }
            generateButton.setEnabled(!colors.isEmpty());
        }
    }

    /**
     * The action for the blue balls' checkbox.
     */
    private class BlueChecker extends AbstractAction {

        /**
         * The serial version UID.
         */
        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * Constructs a <code>BlueChecker</code>.
         */
        public BlueChecker() {
            putValue(AbstractAction.NAME, "Blue balls");
            putValue(AbstractAction.SHORT_DESCRIPTION, "Blue ball");
        }

        /**
         * The action for the blue balls' checkbox.
         *
         * @param ae the action event
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (blueCheckBox.isSelected()) {
                getStatusBar().setMessage("Blue is selected");
                colors.add(Color.BLUE);
            } else {
                getStatusBar().setMessage("Blue is not selected");
                colors.remove(Color.BLUE);
            }
            generateButton.setEnabled(!colors.isEmpty());
        }
    }

    /**
     * The action for the green balls' checkbox.
     */
    private class GreenChecker extends AbstractAction {

        /**
         * The serial version UID.
         */
        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * Constructs a <code>GreenChecker</code>.
         */
        public GreenChecker() {
            putValue(AbstractAction.NAME, "Green balls");
            putValue(AbstractAction.SHORT_DESCRIPTION, "Green ball");
        }

        /**
         * The action for the green balls' checkbox.
         *
         * @param ae the action event
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            if (greenCheckBox.isSelected()) {
                getStatusBar().setMessage("Green is selected");
                colors.add(Color.GREEN);
            } else {
                getStatusBar().setMessage("Green is not selected");
                colors.remove(Color.GREEN);
            }
            generateButton.setEnabled(!colors.isEmpty());
        }
    }

    /**
     * The action for the generate button.
     */
    private class Generate extends AbstractAction {

        /**
         * The serial version UID.
         */
        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * Constructs a <code>Generate</code>.
         */
        public Generate() {
            putValue(AbstractAction.NAME, "Generate");
            putValue(AbstractAction.SHORT_DESCRIPTION, "Generate winning numbers");
        }

        /**
         * The action for the generate button.
         *
         * @param ae the action event
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            getStatusBar().setMessage("Generating winning numbers");
            numberPanel.removeAll();
            generateNumbers();
            numberPanel.revalidate();
            getStatusBar().setMessage("Generated winning numbers");
        }
    }

}
