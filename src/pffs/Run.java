package pffs;

public class Run {

    public static void main(String[] args) {
	AlberoPFFS<String> T = new AlberoPFFS<>();
	NodoPFFS<String> A = T.addRoot("A");

	NodoPFFS<String> B = T.addChild(A, "B");
	NodoPFFS<String> C = T.addChild(A, "C");
	NodoPFFS<String> D = T.addChild(A, "D");

	NodoPFFS<String> E = T.addChild(B, "E");
	NodoPFFS<String> F = T.addChild(B, "F");

	NodoPFFS<String> G = T.addChild(C, "G");

	NodoPFFS<String> H = T.addChild(G, "H");
	NodoPFFS<String> I = T.addChild(G, "I");
	NodoPFFS<String> L = T.addChild(G, "L");
	NodoPFFS<String> M = T.addChild(G, "M");

	NodoPFFS<String> newR = new NodoPFFS<>("newR");

	System.out.println("Return the tree string T: " + T.toString());
	System.out.println("Return the tree root of T: " + T.getRoot());
	System.out.println("Return the tree nodes list visited in depth, DFS:, DFS: " + T.visitDFS());
	System.out.println("Return the tree nodes list visited in breadth, BFS: " + T.visitBFS());
	System.out.println("Return the number of tree nodes of T: " + T.numberNodes());
	System.out.println("Children number of " + A.toString() + ": " + A.grade());
	System.out.println("Children number of " + D.toString() + ": " + D.grade());
	System.out.println("Children number of " + M.toString() + ": " + M.grade());
	System.out.println("Children list of a node " + A.toString() + ": " + T.childs(A));
	System.out.println("Children list of a node " + B.toString() + ": " + T.childs(B));
	System.out.println("Children list of a node " + G.toString() + ": " + T.childs(G));
	System.out.println("Children list of a node " + H.toString() + ": " + T.childs(H));
	System.out.println("Node father " + F.toString() + " is: " + F.getFather());
	System.out.println("Node father " + L.toString() + " is: " + L.getFather());
	System.out.println("Number of tree leaves of T are: " + T.numberLeafs(H));
	System.out.println("Tree height of T: " + T.height());
	System.out.println("Node level " + E.toString() + ": " + E.level());
	System.out.println("Node level " + I.toString() + ": " + I.level());
	System.out.println("Node level " + H.toString() + ": " + H.level());
	System.out.println("Numer of children of the T tree are: " + T.numberLeafs(A));

	System.out.println("Change the root of the T tree to: " + T.addNewRoot(newR));
	System.out.println("Return the tree string of T: " + T.toString());
	System.out.println("Return the new root of the T tree: " + T.getRoot());
	System.out.println("Children list of a node " + newR.toString() + ": " + T.childs(newR));
	System.out.println("Children list of a node " + A.toString() + ": " + T.childs(A));

	AlberoPFFS<String> newT = new AlberoPFFS<>();
	NodoPFFS<String> newA = newT.addRoot("newA");
	System.out.println("The number of empty tree (newT) leaves are: " + newT.numberLeafs(newA));
    }

}
