/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 * @author Fedor Uvarychev
 */
public class Internet {

    /**
     * Constructor of 'Internet' class, which gathers information from file in
     * project directory with given name. First line must have the number of
     * computers, block of lines after '[matrix]' is responsible for the graph,
     * block of lines after '[computers]' contains info about all machines in
     * order of growth.
     *
     * @param path
     * @throws FileNotFoundException
     */
    public Internet(String matrixPath, String infoPath) throws FileNotFoundException {
        Scanner matrixScan = new Scanner(new File(matrixPath));
        if (matrixScan.hasNext()) {
            int size = matrixScan.nextInt();
            comps = new ArrayList<>(size);
            matrix = new boolean[size][size];
            while (matrixScan.hasNext()) {
                int first = matrixScan.nextInt();
                int second = matrixScan.nextInt();
                matrix[first][second] = true;
                matrix[second][first] = true;
            }
        }

        Scanner infoScan = new Scanner(new File(infoPath));
        // OHO. PAbOTAET. HEnPABuJlbHO. 
        while (infoScan.hasNext()) {
            int num = infoScan.nextInt();
            int opSystem = infoScan.nextInt();
            int info = infoScan.nextInt();
            Computer temp = new Computer(num, opSystem, info);
            comps.add(temp);
            System.out.format("%d %d %d constr\n", num, opSystem, info);
        }
        System.out.println("There shall be reckoning");
    }

    /**
     * After the invoking this method infected computers in the net will try to
     * infect their neighbours.
     */
    public void update() {
        //
        boolean[] flags =  new boolean[comps.size()];
        
        for (Computer comp : comps) {
            if (comp.getState() && !flags[comp.getNumber()]) {
                for (int i = 0; i < matrix.length; i++) {
                    if (matrix[comp.getNumber()][i] && !comps.get(i).getState()) {
                        comps.get(i).infestation();
                        flags[i] = true;
                    }
                }
            }
        }
    }

    public void show() {
        for (Computer comp : comps) {
            System.out.format("%d %s %b\n", comp.getNumber(), comp.getOS(), comp.getState());
        }
    }

    public ArrayList<Computer> getComps() {
        return comps;
    }
    private boolean[][] matrix;          // matrix with info about graph
    private ArrayList<Computer> comps;
}
