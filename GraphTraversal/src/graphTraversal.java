package mygraphtraversal;

import static java.lang.System.out;
import java.lang.*;
import java.io.*;
import java.util.*;

class Node {
	public int id;
	public ArrayList<Node> left = new ArrayList<Node>();
	public ArrayList<Node> right = new ArrayList<Node>();
	
	public Node (int id) {  // Constructor for leaf nodes
		this.id = id;
	}
	
	public Node (int id, Node left, Node right) {
		this.id = id;
		
		this.left.add(left);
		this.right.add(right);
	}
}

public class graphTraversal {
	
	static void printLeafNode(Node node) {
		
		if (node.left.size() != 0) {
			printLeafNode(node.left.get(0));	// traversal left first
		} 		
		
		if (node.right.size() != 0) {
		    printLeafNode(node.right.get(0));   // then right
		}
		
		if (node.left.size() == 0 && node.right.size() == 0) {
			System.out.printf(node.id + "\n");
		}
	}
		
	static boolean isInt(String s)
	{
		try {
			int i = Integer.parseInt(s); 
			return true; 
		}
		catch(NumberFormatException er) {
			return false; 
		}
	}	
	
	public static void main(String[] args) {
				
        Node node1 = new Node (1);
        Node node4 = new Node (4);
        Node node7 = new Node (7);
        Node node10 = new Node (10);
	    Node node3 = new Node (3, node1, node4);
		Node node8 = new Node (8, node7, node10);
		Node node5 = new Node (5, node3, node8);
		
		// Store all nodes in array list in random order
		// nodes are not used actually.
		ArrayList<Node> nodes = new ArrayList<Node>();
		
		nodes.add (node5);  // Root is the first one
		nodes.add (node4);  // The rest are stored randomly
	    nodes.add (node10);		
		nodes.add (node3);
		nodes.add (node1);
		nodes.add (node8);		
		nodes.add (node7);	
		
		// Now traversal nodes to find the leaf node, starting from the root node.
		// But it really has nothing to do with nodes, 
		// as each node contains the pointers of children for traversal which is sufficient.
		
		printLeafNode(node5);
	}
}
		
