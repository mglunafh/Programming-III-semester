/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package harvesters;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Lars and Octavia from terran colony Bhekar-Ro decided to collect gas from
 * Vespene deposits appeared soon after the earthquake. Deposits are situated in
 * vertices of graph. On every turn brother's and sister's robo-harvesters can
 * jump through one vertex, or just stay. Unfortunately, if vessel moves into
 * the place where another mech already is, it will obviously destroy both the
 * latter and itself. Our agenda is to find out if the Lars and Octavia have
 * possibility to break their robots down by unadvertedly.
 *
 * @author Fedor Uvarychev
 */
public class Harvesters {

    /**
     *
     */
    private class Vertex {

        private boolean reachableForLars;
    }

    /**
     * Test method.
     *
     * @return
     */
    public boolean[][] getVespField() {
        return this.vespField;
    }

    /**
     * Method which gathers informantion from the given file.
     *
     * @param fileName
     * @throws FileNotFoundException
     */
    public void getData(String fileName) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {

            //creating a matrix of ways and a list of vertices
            int size = scanner.nextInt();

            vespField = new boolean[size][size];
            vertices = new ArrayList<>(size);
            for (int i = 0; i < vespField.length; i++) {
                vertices.add(new Vertex());
            }

            while (scanner.hasNext()) {
                int firstVertex = scanner.nextInt();
                int secondVertex = scanner.nextInt();
                vespField[firstVertex][secondVertex] = true;
                vespField[secondVertex][firstVertex] = true;
            }
            for (int i = 0; i < vespField.length; i++) {
                vespField[i][i] = true;
            }
        }
    }

    /**
     *
     * @param larsPos
     * @param octaviaPos
     * @return
     */
    public boolean ifLarsCanDestroy(String fileName, int larsPos, int octaviaPos) {
        try {
            getData(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("CykN!");
        }

        //queue for vertices which are to be marked as reachable.
        ArrayList<Integer> reachable = new ArrayList<>();
        reachable.add(larsPos);
        Iterator<Integer> iterator = reachable.iterator();
        vertices.get(larsPos).reachableForLars = true;
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            for (int i = 0; i < vespField.length; i++) {
                // if 'num' and 'i' vertices are connected, go further
                if (vespField[next][i]) {
                    // there are all vertices Lars can reach on his vehicle
                    for (int j = 0; i < vespField.length; i++) {
                        if (vespField[i][j] && !vertices.get(j).reachableForLars) {
                            reachable.add(j);
                            vertices.get(j).reachableForLars = true;
                        }
                    }
                }
            }
        }
        
        // now we can check if Lars is able to crush such significant machines
        return vertices.get(octaviaPos).reachableForLars;
    }
    private boolean[][] vespField;
    private ArrayList<Vertex> vertices;
}
