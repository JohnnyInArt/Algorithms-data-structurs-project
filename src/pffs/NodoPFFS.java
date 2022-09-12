package pffs;

public class NodoPFFS<T> {

    private T info;

    /*
     * Each node has 3 pointers
     *  - 'firstChild' is the pointer to the first child of a node
     *  - 'nextSibling' is the pointer to the first sibling on the right of a node
     *  - 'father' is the pointer to the father
     */
    private NodoPFFS<T> firstChild, nextSibling, father;

    // Constructor
    public NodoPFFS(T info) {
	this.info = info;
    }

    // Accessories and mutators
    public T getInfo() {
	return info;
    }

    public void setInfo(T info) {
	this.info = info;
    }

    public NodoPFFS<T> getFirstChild() {
	return firstChild;
    }

    public void setFirstChild(NodoPFFS<T> firstChild) {
	this.firstChild = firstChild;
    }

    public NodoPFFS<T> getNextSibling() {
	return nextSibling;
    }

    public void setNextSibling(NodoPFFS<T> nextSibling) {
	this.nextSibling = nextSibling;
    }

    public NodoPFFS<T> getFather() {
	return father;
    }

    public void setFather(NodoPFFS<T> father) {
	this.father = father;
    }

    
    /*
     * returns the number of children node
     */
    public int grade() {
	NodoPFFS<T> temp = firstChild;
	int grade = 1;
	if (firstChild == null) {
	    return 0;
	}
	while (temp.getNextSibling() != null) {
	    grade++;
	    temp = temp.getNextSibling();
	}
	return grade;
    }

   /*
    *  returns the node level
    */
    public int level() {
	NodoPFFS<T> temp = father;
	int level = 0;
	while (temp != null) {
	    level++;
	    temp = temp.getFather();
	}
	return level;
    }

    /*
     *  facilitates the printing of node information
     */
    public String toString() {
	return info.toString();
    }

}
