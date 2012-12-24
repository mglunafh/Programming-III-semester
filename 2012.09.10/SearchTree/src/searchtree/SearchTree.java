/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package searchtree;

import java.util.Iterator;
import java.util.LinkedList;

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

    /**
     * Tries to establish a position of given value, if it's indeed in the tree.
     *
     * @param value
     * @return a position in tree, or in case of fail -- null.
     */
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

    /**
     * Tries to delete a given value from the tree.
     *
     * @param value
     */
    public void delete(int value) {
        TreeElement victim = this.findPosition(value);
        if (null == victim) {
            // do nothing.
        } else {
            if (null != victim.leftSon) {
                TreeElement temp = this.theClosestLeftSon(victim);
                victim.value = temp.value;
                temp.delete();
            } else if (null != victim.rightSon) {
                TreeElement temp = this.theClosestRightSon(victim);
                victim.value = temp.value;
                temp.delete();
            } else {
                victim.delete();
            }
        }
    }

    /**
     * Function, returning the closest descendant of given node from its left
     * branch.
     *
     * @param element
     * @return null if there's no branch, and the true descendant otherwise.
     */
    private TreeElement theClosestLeftSon(TreeElement element) {
        TreeElement temp = element.leftSon;
        if (temp == null) {
            return null;
        }
        while (temp.rightSon != null) {
            temp = temp.rightSon;
        }
        return temp;
    }

    /**
     * Function, returning the closest descendant of given node from its right
     * branch.
     *
     * @param element
     * @return null if there's no branch, and the true descendant otherwise.
     */
    private TreeElement theClosestRightSon(TreeElement element) {
        TreeElement temp = element.rightSon;
        if (temp == null) {
            return null;
        }
        while (temp.leftSon != null) {
            temp = temp.leftSon;
        }
        return temp;
    }

    public class SearchTreeIterator implements Iterator {

        /**
         *
         */
        private SearchTreeIterator() {
            // Initializing a 'path' to the least element of a tree. 
            this.path = new LinkedList<>();
            TreeElement temp = top;
            while (null != temp) {
                this.path.add(temp);
                temp = temp.leftSon;
            }
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet.");
        }

        /**
         * Implementation of the 'next' method of 'Iterator' interface.
         *
         * @return elements of tree in order of growth.
         */
        @Override
        public Object next() {
            TreeElement temp = this.path.getLast();
            int result = temp.value;

            if (null == temp.leftSon) {
                if (null == temp.rightSon) {
                    this.path.removeLast();
                } else {
                    temp = temp.rightSon;
                    while (null != temp) {
                        this.path.add(temp);
                        temp = temp.leftSon;
                    }
                }
                return result;
                // This case means that we have already met all children of 
                // current node,so we push it out, move upward and then descend 
                // to the closest son from the right side.
            } else {
                temp = temp.batya;
                result = temp.value;
                this.path.removeLast();
                while (null != temp) {
                    this.path.add(temp);
                    temp = temp.leftSon;
                }
                return result;
            }
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
        private LinkedList<TreeElement> path;
    }

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

        /**
         * Deletes a node if the tree, must be applied to leaves only.
         */
        private void delete() {
            if (top == this) {
                top.value = 0;
            } else {
                if (this == this.batya.leftSon) {
                    this.batya.leftSon = null;
                } else {
                    this.batya.rightSon = null;
                }
            }
            count--;
        }
        private int value;
        private TreeElement batya;
        private TreeElement leftSon;
        private TreeElement rightSon;
    }
    private int count;
    private TreeElement top;
}
