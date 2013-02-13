/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internet;

import internet.OS.*;
import java.util.Random;

/**
 *
 * @author FedorUvarychev
 */
public class Computer {

    /**
     * Class which represents a computer with operation system and ability to
     * become infested. i hope it'll work.
     *
     * @param string is one of 'windows' 'ubuntu' 'macos'
     */
    public Computer(int num, int opSystem, int info) {
        number = num;
        switch (info) {
            case 1:
                this.isInfected = true;
            case 0:
                this.isInfected = false;
        }
        switch (opSystem) {
            case 1:
                this.installedOS = new Windows();
            case 2:
                this.installedOS = new Ubuntu();
            case 3:
                this.installedOS = new MacOS();
        }
    }

    /**
     * Function imitating a procedure of infestation and a work of antivirus :D.
     */
    public void infestation() {
        Random rand = new Random();
        if (!isInfected && installedOS.getVulner() > rand.nextInt(100)) {
            isInfected = true;
        }
    }
    
    public int getNumber() {
        return number;
    }
    public boolean getState() {
        return isInfected;
    }
    public String getOS() {
        return installedOS.getName();
    }
    
    private int number;
    private boolean isInfected;
    private OperationSystem installedOS;
}
