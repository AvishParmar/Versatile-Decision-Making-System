package Homework4;

import java.util.Scanner;
/**
 * Tree class that creates the tree and does operations on it
 * @author Avish Parmar
 */
public class Tree {
	
	private TreeNode root;
	private TreeNode cursor;

	/**
	 * Default Tree Constructor
	 */
	public Tree() {
		setRoot(null);
		setCursor(null);
	}
	/**
	 * Sets the cursor 
	 * @param cursor
	 * Cursor pointer
	 */
	public void setCursor(TreeNode cursor) {
		this.cursor = cursor;
	}
	/**
	 * Returns the cursor pointer
	 * @return cursor
	 * Cursor pointer
	 */
	public TreeNode getCursor() {
		return this.cursor;
	}
	/**
	 * Sets the root of the tree
	 * @param root
	 * Root of the tree
	 */
	public void setRoot(TreeNode root) {
		this.root = root;
	}
	/**
	 * Returns the root of the tree
	 * @return root
	 * Root of the tree
	 */
	public TreeNode getRoot() {
		return this.root;
	}
	/**
	 * Adds a node to the tree in a left-justified manner.
	 * @param label
	 * Label of the tree node
	 * @param prompt
	 * Prompt of the tree node
	 * @param message
	 * Message of the tree node
	 * @param parentLabel
	 * Parent label of the tree node
	 * @return true: if node is added, false: if an error occurs
	 */
	public boolean addNode(String label, String prompt, String message, String parentLabel){
		
		if(getRoot() == null) {
			setRoot(new TreeNode(label, prompt, message, parentLabel));
			setCursor(getRoot());
			
			return true;
		}
		setCursor(getNodeReference(parentLabel));
		if(getCursor() == null) {
			return false;
		}
		if(getCursor().getLeft() == null) {
			
			getCursor().setLeft(new TreeNode(label, prompt, message, parentLabel));
			
			return true;
		}
		else if(getCursor().getMiddle() == null) {
			
			getCursor().setMiddle(new TreeNode(label, prompt, message, parentLabel));
			
			return true;
		}
		else if(getCursor().getRight() == null) {
		
			getCursor().setRight(new TreeNode(label, prompt, message, parentLabel));
			
			return true;
		}
		
		return false;
	}
	/**
	 * Helper method for getNodeReference
	 * @param cursor
	 * Current node
	 * @param label
	 * Parent label of a node
	 * @return 
	 * reference to the parent of the new node that is about to be added, if it exists.
	 * or returns null if it doesn't exist.
	 */
	public TreeNode getNodeReferenceHelper(TreeNode cursor, String label) {

		if(cursor.getLabel().trim().equals(label)) 
			return cursor;
		
		else if(cursor.getLeft() != null) 
			if(cursor.getLeft().getLabel().trim().equals(label))
				return cursor.getLeft();
	
		else if(cursor.getMiddle() != null)
			if(cursor.getMiddle().getLabel().trim().equals(label))
				return cursor.getMiddle(); 
		
		else if(cursor.getRight() != null) 
			if(cursor.getRight().getLabel().trim().equals(label))
				return cursor.getRight();
	
		if(cursor.getLeft() != null)
			if(getNodeReferenceHelper(cursor.getLeft(), label) != null) 
				return getNodeReferenceHelper(cursor.getLeft(), label);
				
		if(cursor.getMiddle() != null)
			if(getNodeReferenceHelper(cursor.getMiddle(), label) != null) 
				return getNodeReferenceHelper(cursor.getMiddle(), label);
			
		if(cursor.getRight() != null)
			if(getNodeReferenceHelper(cursor.getRight(), label) != null) 
				return getNodeReferenceHelper(cursor.getRight(), label);
			
		return null;
	}
	/**
	 * Searches for the parent of a node
	 * @param label
	 * Label of the node's parent
	 * @return
	 * reference to the parent of the new node that is about to be added, if it exists.
	 * or returns null if it doesn't exist.
	 */
	public TreeNode getNodeReference(String label) {
		setCursor(getRoot());
		return getNodeReferenceHelper(getCursor(), label.trim());
	}
	/**
	 * Traverses the tree using preorder traversal.
	 */
	public void preOrder(){
		
		if(getRoot() == null) {
			System.out.println("\nTree does not exist!\n");
			return;
		}
		
		System.out.println("\nTraversing the tree in preorder:");
		setCursor(getRoot());
		preOrderHelper(getCursor());
	}
	/**
	 * preOrder method helper which actually traverses the tree and prints out node information.
	 * @param cursor
	 * References to the currently selected node.
	 */
	public void preOrderHelper(TreeNode cursor) {
		
		cursor.toString();
		
		if(cursor.getLeft() != null) {
			preOrderHelper(cursor.getLeft());
		}
		if(cursor.getMiddle() != null) {
			preOrderHelper(cursor.getMiddle());
		}
		if(cursor.getRight() != null) {
			preOrderHelper(cursor.getRight());
		}
	}
	
	@SuppressWarnings("resource")
	/**
	 * Starts the automated questioning service
	 */
	public void beginSession() {
		Scanner stdin = new Scanner(System.in);
		if(this.root == null) {
			System.out.println("Tree does not exist!");
			return;
		}
		System.out.println("\nHelp Session Starting...");
		
		
		setCursor(getRoot());
		
		while(true) {
			int count = 0;
			System.out.println("\n"+cursor.getMessage());
			
			if(cursor.isLeaf()) {
				break;
			}
			if(cursor.getLeft() != null) {
				count++;
				System.out.println(count+". "+cursor.getLeft().getPrompt());
			}
			if(cursor.getMiddle() != null) {
				count++;
				System.out.println(count+". "+cursor.getMiddle().getPrompt());
			}
			if(cursor.getRight() != null) {
				count++;
				System.out.println(count+". "+cursor.getRight().getPrompt());
			}
			System.out.println("0. Exit Session.");
			System.out.print("\nChoice> ");
			
			String choice = stdin.nextLine();
			while(!(Character.isDigit(choice.charAt(0)))) {
				System.out.print("Please input a digit: ");
				choice = stdin.nextLine();
			}
			while(Integer.parseInt(choice) > count) {
				System.out.print("Please input a proper choice: ");
				choice = stdin.nextLine();
			}
			if(choice.equals("1") && Integer.parseInt(choice) <= count) {
				setCursor(cursor.getLeft());
			}
			else if(choice.equals("2") && Integer.parseInt(choice)<= count) {
				setCursor(cursor.getMiddle()); 
			}
			else if(choice.equals("3") && Integer.parseInt(choice) <= count) {
				setCursor(cursor.getRight());
			}
			else if(choice.equals("0")) {
				break;
			}
		}
		
	}
	
	
}
