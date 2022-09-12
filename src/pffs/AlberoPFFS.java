package pffs;

import java.util.LinkedList;

public class AlberoPFFS<T> {

    private NodoPFFS<T> root;
    private int numberNodes;

    /*
     * returns the root
     */
    public NodoPFFS<T> getRoot() {
	return root;
    }
    
    /*
     * Set the tree root
     */
    public NodoPFFS<T> addRoot(T info) {
	this.root = new NodoPFFS<T>(info);
	numberNodes++;
	return root;
    }
    
    /*
     * Add a node v to the tree as a child of u and with information 'info'
     */
    public NodoPFFS<T> addChild(NodoPFFS<T> u, T info) {
	NodoPFFS<T> v = new NodoPFFS<T>(info);
	v.setNextSibling(u.getFirstChild());
	u.setFirstChild(v);
	v.setFather(u);

	numberNodes++;
	return v;
    }
    
    /*
     * Change the tree root. The old root becomes the daughter of the new one
     */
    public NodoPFFS<T> addNewRoot(NodoPFFS<T> newRoot) {
	if (root == null) {
	    System.out.println("Albero sul quale si vuole inserire la nuova radice è vuoto, "
		    + "dunque viene impostata come radice dell'albero.");
	    return addRoot(newRoot.getInfo());
	}
	numberNodes++;
	newRoot.setFather(null);
	newRoot.setFirstChild(root);
	root.setFather(newRoot);
	root = newRoot;
	return root;

    }
    
    /*
     * returns a node list of the tree visited in Depth
     * (iterative algorithm)
     */
    public LinkedList<T> visitDFS() {
	LinkedList<NodoPFFS<T>> stack = new LinkedList<>();
	LinkedList<T> nodeInfoList = new LinkedList<>();
	NodoPFFS<T> temp;
	stack.push(root);
	while (!stack.isEmpty()) {
	    temp = stack.pop();
	    nodeInfoList.add(temp.getInfo());
	    for (int i = childs(temp).size() - 1; i >= 0; i--) {
		stack.push(childs(temp).get(i));
	    }
	}
	return nodeInfoList;
    }
    
    /*
     * returns INFO list of a node list of tree visited in breadth
     * (iterative algorithm)
     */
    public LinkedList<T> visitBFS() {
	LinkedList<NodoPFFS<T>> queue = new LinkedList<>();
	LinkedList<T> nodeInfoList = new LinkedList<>();
	NodoPFFS<T> temp;
	queue.addFirst(root);
	while (!queue.isEmpty()) {
	    temp = queue.removeLast();
	    nodeInfoList.add(temp.getInfo());
	    for (int i = 0; i <= childs(temp).size() - 1; i++) {
		queue.addFirst(childs(temp).get(i));
	    }
	}
	return nodeInfoList;
    }

    /*
     *  restituire i numeri di nodo
     */
    public int numberNodes() {
	return numberNodes;
    }

    /*
     * returns the children list of a node
     */
    public LinkedList<NodoPFFS<T>> childs(NodoPFFS<T> v) {
	LinkedList<NodoPFFS<T>> childs = new LinkedList<>();
	NodoPFFS<T> temp = v.getFirstChild();
	while (temp != null) {
	    childs.addFirst(temp);
	    temp = temp.getNextSibling();
	}
	return childs;
    }
    
    /*
     * counts recursively the number of tree leaves 
     */
    public int numberLeafs(NodoPFFS<T> node) {
	if (node == root && node.grade() == 0) {
	    return 0;
	}
	if (node.grade() == 0) {
	    return 1;
	}
	int leafs = 0;
	for (int i = 0; i <= childs(node).size() - 1; i++) {
	    leafs = leafs + numberLeafs(childs(node).get(i));
	}
	return leafs;
    }

    /*
     * returns a list OF NODES of the visited tree in breadth
     * (iterative algorithm)
     */
    public LinkedList<NodoPFFS<T>> visitBFSNodes() {
	LinkedList<NodoPFFS<T>> queue = new LinkedList<>();
	LinkedList<NodoPFFS<T>> nodeList = new LinkedList<>();
	NodoPFFS<T> temp;
	queue.addFirst(root);
	while (!queue.isEmpty()) {
	    temp = queue.removeLast();
	    nodeList.add(temp);
	    for (int i = 0; i <= childs(temp).size() - 1; i++) {
		queue.addFirst(childs(temp).get(i));
	    }
	}
	return nodeList;
    }

    /*
     * height, which represents the maximum nodes level
     */
    public int height() {
	NodoPFFS<T> lastNode = visitBFSNodes().get(numberNodes - 1);
	return lastNode.level();
    }



    /*
     * returns the representative string of the tree
     */
    public String toString() {
	String[] treeRapresentation = { "" };
	processString(root, treeRapresentation);
	return treeRapresentation[0];
    }

    /*
     * processes the string with the tree representation
     */
    private void processString(NodoPFFS<T> node, String[] treeRapr) {
	NodoPFFS<T> temp = node.getFather();
	treeRapr[0] = treeRapr[0] + node.toString();
	if (!childs(node).isEmpty()) {
	    treeRapr[0] = treeRapr[0] + "[";
	}
	for (int i = 0; i <= childs(node).size() - 1; i++) {
	    processString(childs(node).get(i), treeRapr);
	}
	if (node.getFirstChild() != null) {
	    treeRapr[0] = treeRapr[0] + "]";
	}
	if (node != root) {
	    if (node != childs(temp).get(childs(temp).size() - 1)) {
		treeRapr[0] = treeRapr[0] + ",";
	    }
	}
    }
}