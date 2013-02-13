/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package internet;

import java.util.Random;

/**
 *
 * @author FedorUvarychev
 */
public class ReleaseRandomizer implements Randomizer{

    @Override
    public int nextInt(int bound) {
        Random rand = new Random();
        return rand.nextInt(bound);
    }
    
}
