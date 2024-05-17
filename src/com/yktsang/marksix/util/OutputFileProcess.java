/*
 * OutputFileProcess.java
 *
 * Hong Kong Mark Six Simulator is a stand-alone application
 * simulating Hong Kong lottery.
 *
 * This class or interface is part of the Mark Six project.
 * The class or interface must not be used outside of this context.
 */
package com.yktsang.marksix.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;

/**
 * The output file process.
 *
 * @author Tsang Yiu Kee Kay
 * @version 1.0
 */
public class OutputFileProcess implements Runnable {

    @Override
    public void run() {
        Set<Integer> base = new TreeSet<>();

        BigInteger numOfCombos =  MarkSixUtil.combination(49,6);
        NumberFormat nf = NumberFormat.getInstance();
        int count = 1;

        String fileName = "mark-six_combination_output.txt";
        File f = new File(fileName);
        if (f.exists()) {
            f.delete();
        }
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException ie) {
            throw new RuntimeException(ie);
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(f))) {
            bw.write(nf.format(numOfCombos)
                    + " combinations of Mark Six winning (6) numbers");
            bw.newLine();
            bw.newLine();
            bw.write("The list of combinations are:");
            bw.newLine();

            for (int i=1; i<=44; i++) {
                base.add(i);
                for (int j=i+1; j<=45; j++) {
                    base.add(j);
                    for (int k=j+1; k<=46; k++) {
                        base.add(k);
                        for (int p=k+1; p<=47; p++) {
                            base.add(p);
                            for (int q=p+1; q<=48; q++) {
                                base.add(q);
                                for (int r=q+1; r<=49; r++) {
                                    base.add(r);
                                    bw.write(count + ": " + base);
                                    base.remove(r);
                                    bw.newLine();
                                    if (count%1000 == 0) {
                                        bw.flush();
                                    }
                                    count++;
                                }
                                base.remove(q);
                            }
                            base.remove(p);
                        }
                        base.remove(k);
                    }
                    base.remove(j);
                }
                base.remove(i);
            }
            bw.flush();
        } catch (IOException ioe) {
            ioe.printStackTrace(System.err);
        }
    }
}
