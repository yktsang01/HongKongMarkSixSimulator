/*
 * ExitApp.java
 *
 * Hong Kong Mark Six Simulator is a stand-alone application
 * simulating Hong Kong lottery.
 *
 * This class or interface is part of the Mark Six project.
 * The class or interface must not be used outside of this context.
 */
package com.yktsang.marksix.client;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.Serial;

/**
 * Exits the application.
 *
 * @author Tsang Yiu Kee Kay
 * @version 1.0
 */
public class ExitApp extends AbstractAction {

    /**
     * The serial version UID.
     */
    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a <code>ExitApp</code>.
     */
    public ExitApp() {
        putValue(AbstractAction.NAME, "Exit");
        putValue(AbstractAction.SHORT_DESCRIPTION,
                "Exits application");
    }

    /**
     * Exits application.
     *
     * @param ae action event
     */
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.exit(0);
    }

}
