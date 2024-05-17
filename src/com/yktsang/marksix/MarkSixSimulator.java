/*
 * MarkSixSimulator.java
 *
 * Hong Kong Mark Six Simulator is a stand-alone application
 * simulating Hong Kong lottery.
 *
 * This class or interface is part of the Mark Six project.
 * The class or interface must not be used outside of this context.
 */
package com.yktsang.marksix;

import com.yktsang.marksix.client.MarkSixClient;
import com.yktsang.marksix.util.MarkSixUtil;

import javax.swing.*;

/**
 * Provides the entry point for the application.
 *
 * @author Tsang Yiu Kee Kay
 * @version 1.0
 */
public class MarkSixSimulator {

    /**
     * Provides the entry point for the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // load the numbers
        MarkSixUtil.loadNumberMap();
        // main window
        SwingUtilities.invokeLater(MarkSixClient::new);
    }

} // end class Grok
