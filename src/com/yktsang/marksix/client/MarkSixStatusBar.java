/*
 * MarkSixStatusBar.java
 *
 * Hong Kong Mark Six Simulator is a stand-alone application
 * simulating Hong Kong lottery.
 *
 * This class or interface is part of the Mark Six project.
 * The class or interface must not be used outside of this context.
 */
package com.yktsang.marksix.client;

import javax.swing.*;
import java.awt.*;
import java.io.Serial;

/**
 * Represents the status bar of the application.
 *
 * @author Tsang Yiu Kee Kay
 * @version 1.0
 */
public class MarkSixStatusBar extends JPanel {

    /**
     * The serial version UID.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The message label.
     */
    private final JLabel messageLabel;

    /**
     * Constructs a <code>MarkSixStatusBar</code>.
     */
    public MarkSixStatusBar() {
        setLayout(new BorderLayout());
        messageLabel = new JLabel("Welcome to Mark Six");
        messageLabel.setToolTipText("What you are doing or " +
                "what you have just done");
        add(messageLabel);
    }

    /**
     * Returns the message from the status bar.
     *
     * @return the message form the status bar
     */
    public String getMessage() {
        return messageLabel.getText();
    }

    /**
     * Assigns the message to the status bar.
     *
     * @param message the message
     */
    public final void setMessage(String message) {
        messageLabel.setText(message);
        add(messageLabel, BorderLayout.WEST);
    }

}
