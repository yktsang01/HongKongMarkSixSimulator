/*
 * MarkSixMenuBar.java
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
import java.awt.event.KeyEvent;
import java.io.Serial;

/**
 * Represents the menu bar of the application.
 *
 * @author Tsang Yiu Kee Kay
 * @version 1.0
 */
public class MarkSixMenuBar extends JMenuBar {

    /**
     * The serial version UID.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a <code>MarkSixMenuBar</code>.
     */
    public MarkSixMenuBar() {
        displayFileMenu();
        displayBatchMenu();
        displayHelpMenu();
    }

    /**
     * Displays the file menu.
     */
    private void displayFileMenu() {
        JMenu menu = new JMenu("File");
        menu.setMnemonic(KeyEvent.VK_F);

        JMenuItem exitItem = new JMenuItem(new ExitApp());
        exitItem.setToolTipText("Exit application");
        exitItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        menu.add(exitItem);

        add(menu);
    }

    /**
     * Displays the batch menu.
     */
    private void displayBatchMenu() {
        JMenu menu = new JMenu("Batch");
        menu.setMnemonic(KeyEvent.VK_B);

        JMenuItem outputFileItem = new JMenuItem(new OutputFile());
        outputFileItem.setToolTipText("Output all combinations to file");
        outputFileItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        menu.add(outputFileItem);

        add(menu);
    }

    /**
     * Displays the help menu.
     */
    private void displayHelpMenu() {
        JMenu menu = new JMenu("Help");
        menu.setMnemonic(KeyEvent.VK_H);

        JMenuItem aboutItem =
                new JMenuItem(new AboutApp());
        aboutItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,
                Toolkit.getDefaultToolkit().getMenuShortcutKeyMaskEx()));
        menu.add(aboutItem);

        add(menu);
    }

}
