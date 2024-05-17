/*
 * AboutApp.java
 *
 * Hong Kong Mark Six Simulator is a stand-alone application
 * simulating Hong Kong lottery.
 *
 * This class or interface is part of the Mark Six project.
 * The class or interface must not be used outside of this context.
 */
package com.yktsang.marksix.client;

import com.yktsang.marksix.util.WindowPositioner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Serial;

/**
 * Displays the about window.
 *
 * @author Tsang Yiu Kee Kay
 * @version 1.0
 */
public class AboutApp extends AbstractAction {

    /**
     * The serial version UID.
     */
    @Serial
    private static final long serialVersionUID = 1L;
    /**
     * The dialog window.
     */
    private JDialog dialog;
    /**
     * The <code>MarkSixStatusBar</code>.
     */
    private MarkSixStatusBar statusBar;
    /**
     * The status bar existing message.
     */
    private String prevMessage;

    /**
     * Constructs a <code>AboutApp</code>.
     */
    public AboutApp() {
        putValue(AbstractAction.NAME, "About");
        putValue(AbstractAction.SHORT_DESCRIPTION,
                "What this application is about");
    }

    /**
     * Displays the about window.
     *
     * @param ae the action event
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        statusBar = MarkSixClient.getStatusBar();
        prevMessage = statusBar.getMessage();
        statusBar.setMessage("Viewing about");

        dialog = new JDialog();
        dialog.setTitle("About");
        dialog.setModal(true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        // info panel
        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        JLabel versionLabel = new JLabel("Product Version: Mark Six Simulator 1.0");
        infoPanel.add(versionLabel);
        infoPanel.add(new JLabel("\n"));
        JLabel imgLabel = new JLabel("Images for the application are "
                + "by courtesy of http://www.hkjc.com");
        infoPanel.add(imgLabel);
        dialog.add(infoPanel, BorderLayout.CENTER);

        // button panel
        JPanel panel = new JPanel();
        JButton button = new JButton(new DisposeAbout());
        panel.add(button);
        dialog.add(panel, BorderLayout.SOUTH);

        dialog.pack();
        Rectangle rect = dialog.getBounds();
        int x = WindowPositioner.getXPosition(rect);
        int y = WindowPositioner.getYPosition(rect);
        dialog.setBounds(x, y, rect.width, rect.height);
        dialog.setVisible(true);

    }

    /**
     * Disposes the about window.
     */
    private class DisposeAbout extends AbstractAction {

        /**
         * The serial version UID.
         */
        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * Constructs a <code>DisposeAbout</code>.
         */
        private DisposeAbout() {
            putValue(AbstractAction.NAME, "Close");
            putValue(AbstractAction.SHORT_DESCRIPTION, "Close");
        }

        /**
         * Disposes about window.
         *
         * @param ae the action event
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            statusBar.setMessage(prevMessage);
            dialog.dispose();
        }

    }

}
