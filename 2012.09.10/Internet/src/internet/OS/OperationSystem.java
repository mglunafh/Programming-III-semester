/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package internet.OS;

/**
 * Ok, this class would be pretty enough if it was implemented as Flyweight.
 * @author FedorUvarychev
 */
public class OperationSystem {
    public String getName() {
        return OperationSystem.name;
    }
    public int getVulner() {
        return OperationSystem.vulner;
    }
    protected static int vulner;
    protected static String name;
}
