/*
 * OutputFile.java
 *
 * Hong Kong Mark Six Simulator is a stand-alone application
 * simulating Hong Kong lottery.
 *
 * This class or interface is part of the Mark Six project.
 * The class or interface must not be used outside of this context.
 */
package com.yktsang.marksix.client;

import com.yktsang.marksix.util.OutputFileProcess;
import com.yktsang.marksix.util.WindowPositioner;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.Serial;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * Output file window.
 *
 * @author Tsang Yiu Kee Kay
 * @version 1.0
 */
public class OutputFile extends AbstractAction {

    /**
     * The serial version UID.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The output file window.
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
     * Constructs a <code>OutputFile</code>.
     */
    public OutputFile() {
        putValue(AbstractAction.NAME, "Output File");
        putValue(AbstractAction.SHORT_DESCRIPTION,
                "Output combinations to file");
    }

    /**
     * Output combinations to file.
     *
     * @param ae the action event
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        statusBar = MarkSixClient.getStatusBar();
        prevMessage = statusBar.getMessage();
        statusBar.setMessage("Viewing Output File");

        dialog = new JDialog();
        dialog.setTitle("Output File");
        dialog.setModal(true);
        dialog.setResizable(false);
        dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);

        JPanel infoPanel = new JPanel();
        infoPanel.setBorder(new EmptyBorder(10, 10, 10, 10));
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        JLabel longProcessTaskLabel01 =
                new JLabel("Start will output all the combinations to a text file.");
        infoPanel.add(longProcessTaskLabel01);
        dialog.add(infoPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        JButton startButton = new JButton(new ExecuteOutputFile());
        buttonPanel.add(startButton);
        JButton cancelButton = new JButton(new DisposeOutputFile());
        buttonPanel.add(cancelButton);
        dialog.add(buttonPanel, BorderLayout.SOUTH);

        dialog.pack();
        Rectangle rect = dialog.getBounds();
        int x = WindowPositioner.getXPosition(rect);
        int y = WindowPositioner.getYPosition(rect);
        dialog.setBounds(x, y, rect.width, rect.height);
        dialog.setVisible(true);
    }

    /**
     * Disposes the output file window.
     */
    private class DisposeOutputFile extends AbstractAction {

        /**
         * The serial version UID.
         */
        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * Constructs a <code>DisposeOutputFile</code>.
         */
        private DisposeOutputFile() {
            putValue(AbstractAction.NAME, "Cancel");
            putValue(AbstractAction.SHORT_DESCRIPTION, "Cancel");
        }

        /**
         * Disposes output file window.
         *
         * @param ae the action event
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            statusBar.setMessage(prevMessage);
            dialog.dispose();
        }

    }

    /**
     * Execute the output file.
     */
    private class ExecuteOutputFile extends AbstractAction {

        /**
         * The serial version UID.
         */
        @Serial
        private static final long serialVersionUID = 1L;

        /**
         * Constructs a <code>ExecuteOutputFile</code>.
         */
        private ExecuteOutputFile() {
            putValue(AbstractAction.NAME, "Start");
            putValue(AbstractAction.SHORT_DESCRIPTION, "Start");
        }

        /**
         * Execute the output file.
         *
         * @param ae the action event
         */
        @Override
        public void actionPerformed(ActionEvent ae) {
            System.out.println("start output="+LocalDateTime.now());
            Thread t = new Thread(new OutputFileProcess());
            t.start();
            try {
                TimeUnit.SECONDS.sleep(15);
            } catch (InterruptedException ie) {
                throw new RuntimeException(ie);
            }
            statusBar.setMessage("Output file is completed");
            dialog.dispose();
            System.out.println("done output="+LocalDateTime.now());
        }

    }

}
