/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchtree;

/**
 *
 * @author Fedor Uvarychev
 */
public class SearchTree {

    public SearchTree() {
        this.top = new TreeElement(0);
    }

    /**
     *
     * @return number of elements of the tree.
     */
    public int sizeOfTree() {
        return this.count;
    }

    /**
     * Inserts a given value into the tree.
     *
     * @param value
     */
    public void add(int value) {
        if (0 == this.count) {
            this.top.value = value;
            count++;
        } else {
            this.top.insert(value);
        }
    }

    /**
     * Learns, if the given number belongs to search tree.
     *
     * @param value
     * @return 'true', if element was found, and 'false' otherwise.
     */
    public boolean find(int value) {
        return (null != this.findPosition(value));
    }

    private TreeElement findPosition(int value) {
        if (0 != this.count) {
            TreeElement temp = this.top;
            while (value != temp.value || null != temp) {
                if (value < temp.value) {
                    temp = temp.leftSon;
                } else {
                    temp = temp.rightSon;
                }
            }
            return temp;
        } else {
            return null;
        }
    }

    /*
     * public void delete(int value) { if (0 == count) {
     * System.out.println("Tree is empty NAPRIMER."); } else { TreeElement
     * parent = this.findParentalPosition(value);
     *
     * // this branch is not ready yet. if (value == parent.value) { } else {
     * TreeElement deleted = this.getCorrectSon(parent, value); if (null ==
     * deleted) { System.out.println("Given value does not exist."); } else {
     * TreeElement theClosestLeft = this.theClosestLeftSon(parent); TreeElement
     * theClosestRight = this.theClosestRightSon(parent);
     *
     * if (null != theClosestRight) { if (null == theClosestRight.leftSon) {
     * deletedElement.value = theClosestRight.value; deletedElement.rightSon =
     * null; } else { while (null != theClosestRight.leftSon) { theClosestRight
     * = theClosestRight.leftSon; } deletedElement.value =
     * theClosestRight.value; } } else if (null != theClosestLeft) { } else { }
     * } } } }
     *
     */
    /**
     * Class which corresponds to element of the tree.
     */
    private class TreeElement {

        private TreeElement(int value) {
            this.value = value;
        }

        /**
         * Function recursively finding the place where the insertion is
         * possible.
         *
         * @param value
         */
        private void insert(int value) {
            if (value < this.value) {
                if (this.leftSon == null) {
                    this.leftSon = new TreeElement(value);
                    this.leftSon.batya = this;
                    count++;
                } else {
                    this.leftSon.insert(value);
                }
            } else if (value > this.value) {
                if (this.rightSon == null) {
                    this.rightSon = new TreeElement(value);
                    this.rightSon.batya = this;
                    count++;
                } else {
                    this.rightSon.insert(value);
                }
            } else {
            }
        }
        private int value;
        private TreeElement batya;
        private TreeElement leftSon;
        private TreeElement rightSon;
    }
    private int count;
    private TreeElement top;
}
