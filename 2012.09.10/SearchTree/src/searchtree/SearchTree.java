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
        if (0 != this.count) {
            //We may be in luck and the value to be found may lie in the top.
            if (value == this.top.value) {
                return true;
                //In general case we'll use function 'findParentalPosition'.
            } else {
                return null == this.findCorrectSon(this.findParentalPosition(value), value);
            }
            //There should not be questions, when the tree is empty.
        } else {
            return false;
        }
    }

    public void delete(int value) {
        if (0 == count) {
            System.out.println("Tree is empty NAPRIMER.");
        } else {
            TreeElement deletedElement = this.findParentalPosition(value);
            if (null == deletedElement) {
                System.out.println("Given value does not exist.");
            } else {
                TreeElement theClosestLeft = deletedElement.leftSon;
                TreeElement theClosestRight = deletedElement.rightSon;

                if (null != theClosestRight) {
                    if (null == theClosestRight.leftSon) {
                        deletedElement.value = theClosestRight.value;
                        deletedElement.rightSon = null;
                    } else {
                        while (null != theClosestRight.leftSon) {
                            theClosestRight = theClosestRight.leftSon;
                        }
                        deletedElement.value = theClosestRight.value;
                    }
                } else if (null != theClosestLeft) {
                } else {
                }
            }
        }
    }

    /**
     * Finds a parent of a given value.
     *
     * @param value
     * @return top in case, when value is in the top, the closest un-null position, 
     * if there is not the given value, and the true parent otherwise.
     */
    private TreeElement findParentalPosition(int value) {
        TreeElement result = this.top;
        if (value == result.value) {
            return result;
        }
        TreeElement temp = null;
        if (value < result.value) {
            temp = result.leftSon;
        } else {
            temp = result.rightSon;
        }

        while (temp != null || temp.value != value) {
            if (temp.value > value) {
                result = temp;
                temp = temp.leftSon;
            } else if (temp.value < value) {
                result = temp;
                temp = temp.rightSon;
            }
        }
        return result;
    }

    /**
     *
     * @param treeElement "Parent" of the tree element, containing 'value'.
     * @param value
     * @return null, if 'value' does not belong to the tree, or its position in
     * the structure.
     */
    private TreeElement findCorrectSon(TreeElement treeElement, int value) {
        if (value > treeElement.value) {
            return treeElement.rightSon;
        } else {
            return treeElement.leftSon;
        }
    }

    /**
     * Finds the least number, which is greater than value in 'element'.
     *
     * @param element
     * @return
     */
    private TreeElement theClosestRightSon(TreeElement element) {
        TreeElement temp = element.rightSon;
        if (temp == null) {
            return temp;
        }
        while (temp.leftSon != null) {
            temp = temp.leftSon;
        }
        return temp;
    }

    /**
     * Finds the greatest number, which is less than than value in 'element'.
     *
     * @param element
     * @return
     */
    private TreeElement theClosestLeftSon(TreeElement element) {
        TreeElement temp = element.leftSon;
        if (temp == null) {
            return temp;
        }
        while (temp.rightSon != null) {
            temp = temp.rightSon;
        }
        return temp;
    }

    /**
     * Class which corresponds to element of the tree.
     */
    private class TreeElement {

        private TreeElement(int value) {
            this.value = value;
        }
        private int value;
        private TreeElement leftSon;
        private TreeElement rightSon;

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
                    count++;
                } else {
                    this.leftSon.insert(value);
                }
            } else if (value > this.value) {
                if (this.rightSon == null) {
                    this.rightSon = new TreeElement(value);
                    count++;
                } else {
                    this.rightSon.insert(value);
                }
            } else {
            }
        }
    }
    private int count;
    private TreeElement top;
}
