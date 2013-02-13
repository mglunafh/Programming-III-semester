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
        return this.name;
    }
    public int getVulner() {
        return this.vulner;
    }
    protected int vulner;
    protected String name;
}
