<br />
<div align="center">
  <h1>Algorithms and Data Structurs project</h1>
  <p>
    This repository contains the implementation for the laboratory project of Algorithms and Data Structurs class at the University of Florence
  </p>
  <p align="center">
    <img src="images/animation.gif" width='390'/>
</p>
</div>

<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#getting-started">Getting Started</a>
    </li>
    <li>
      <a href="#description">Description</a>
    </li>
    <li>
      <a href="#assignment-and-report">Assignment and report</a>
      </li>
    <li>
      <a href="#license">License</a>
    </li>
  </ol>
</details>

# Getting Started
In order to run this [java code](/src/), download Eclipse on the relative [site page](https://eclipseide.org/) or use your favorite IDE.
Project tested in Eclipse 2022-09, installed on Ubuntu Linux 22.04.


# Description 
Let T be a tree with the following characteristics:

1. each node contains only one piece of information whose type we do not know and
all the information contained in the nodes is of the same type;
2. the maximum number of children each node can have isn't known;
3. inclusion of a node in the tree (excluding the root) is only possible by
specifying the parent of the node that will be inserted and the information that it
will contain.

Such a tree can be stored by keeping for each node a pointer to the first child and a pointer to the next sibling (PFFS).
For example, the tree in Figure 1 becomes the one represented in Figure 2.

The following list contains methods for each of the following operations:

- Enter the root whose information it will contain is known. The method,
that is, receives as input the information of the root.
- Insert a new node V as the child of a node U , already present in the tree.
The method receives as input the parent of the new node, and the information of the latter.
- Insert a new root into a nonempty tree so that the old root is ﬁle with the new one.
- Traverse the tree in depth and return the list of information contained in the nodes thus encountered.
- Traverse the tree in breadth and return the list of information contained in the nodes so encountered.
- Return the number of nodes in the tree.
- Given a node, return the number of its children.
- Given a node, return the list of information of its children.
- Return the contents of a node.
- Change the contents of a node.
- Return the root of the tree.
- Return the parent of a node.
- Return the number of leaves of the tree;
- Return the height of the tree.
- Return the level of a node.
- Return a string representative of the T-tree in which the siblings of a node are enclosed in square brackets and separated by commas, recursively. For example, if the entries of the various nodes resulted in the tree depicted in Figure 1, then the representative string is: A[B[E, F ], C[G[H, I, L, M ]], D].

Since the insertion operation requires knowledge of the parent node, it is advisable that the method implemented for such an operation returns the node itself in order to easily retrieve it for later insertion. Note that the tree description doesn't specify the position where a node
will be inserted among any parent children already present. It must be possible to view the various parameters of a tree or a node, such as the list of information of a node's children, the information of a
node, the list of node information resulting from a certain visit, the height of the tree, etc. For this, it may be useful to implement special methods that facilitate their printing.

# Assignment and report

You can have a look at the project [assignment](doc/assignment.pdf), but beware that they have been written in Italian.
While all the source code is commented in English.

# License

Distributed under the GNU General Public License v3.0 . See [LICENSE](LICENSE) for more information.
