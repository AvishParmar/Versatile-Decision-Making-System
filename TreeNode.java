package Homework4;
/**
 * TreeNode class that creates a tree node object and instantiates it
 * @author Avish Parmar
 * SBUID: 112647892
 * Email: avish.parmar@stonybrook.edu
 * Course: CSE214
 * Recitation: Section 01
 */
public class TreeNode {
	
	public TreeNode left;
	private TreeNode middle;
	private TreeNode right;
	private String label;
	private String message;
	private String prompt;
	private String parentLabel;
	
	/**
	 * Default TreeNode constructor
	 */
	public TreeNode() {
		
	}
	/**
	 * TreeNode constructor
	 * @param label
	 * TreeNode label
	 * @param message
	 * TreeNode message
	 * @param prompt
	 * TreeNode prompt
	 * @param parentLabel
	 * TreeNode parent label
	 */
	public TreeNode(String label, String message, String prompt, String parentLabel) {
		setLabel(label);
		setMessage(message);
		setPrompt(prompt);
		setParentLabel(parentLabel);
	}
	/**
	 * Sets the label for the TreeNode
	 * @param label
	 * Label of tree node
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * Returns the label of the tree node
	 * @return label
	 * Label of tree node
	 */
	public String getLabel() {
		return this.label;
	}
	/**
	 * Sets the message for the TreeNode
	 * @param message
	 * Message of tree node
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * Returns the message of the tree node
	 * @return message
	 * Message of tree node
	 */
	public String getMessage() {
		return this.message;
	}
	/**
	 * Sets the prompt for the TreeNode
	 * @param prompt
	 * Prompt of tree node
	 */
	public void setPrompt(String prompt) {
		this.prompt = prompt;
	}
	/**
	 * Returns the prompt for the TreeNode
	 * @return prompt
	 * Prompt of tree node
	 */
	public String getPrompt() {
		return this.prompt;
	}
	/**
	 * Sets the parent label for the TreeNode
	 * @param parentLabel
	 * parent label of tree node
	 */
	public void setParentLabel(String parentLabel) {
		this.parentLabel = parentLabel;
	}
	/**
	 * Returns the parent label of the TreeNade
	 * @return parentLabel
	 * parent label of tree node
	 */
	public String getParentLabel() {
		return this.parentLabel;
	}
	/**
	 * Returns the left child of the tree node
	 * @return left
	 * Left child of this node
	 */
	public TreeNode getLeft() {
		return this.left;
	}
	/**
	 * Returns the right child of the tree node
	 * @return right
	 * Right child of this node
	 */
	public TreeNode getRight() {
		return this.right;	
	}
	/**
	 * Returns the middle child of the tree node
	 * @return middle
	 * Middle child of this node
	 */
	public TreeNode getMiddle() {
		return this.middle;
	}
	/**
	 * Sets the left child of the tree node
	 * @param left
	 * Left child of this node
	 */
	public void setLeft(TreeNode left) {
		this.left = left;
	}
	/**
	 * Sets the right child of the tree node
	 * @param right
	 * Right child of this node
	 */
	public void setRight(TreeNode right) {
		this.right = right;
	}
	/**
	 * Sets the middle child of the tree node
	 * @param middle
	 * Middle child of this node
	 */
	public void setMiddle(TreeNode middle) {
		this.middle = middle;
	}
	/**
	 * Traverses through the tree recursively using preorder traversal
	 */
	public void preorder() {
		if(getLeft() != null) 
			getLeft().preorder();
		if(getMiddle() != null)
			getMiddle().preorder();
		if(getRight() != null)
			getRight().preorder();
		
	}
	/**
	 * Checks if this node is a leaf
	 * @return true: if node is leaf, false: if node has a child
	 * 
	 */
	public boolean isLeaf() {
		if(getLeft() == null && getMiddle() == null && getRight() == null) {
			return true;
		}
		return false;
	}
	/**
	 * toString() method for TreeNode. Prints node information
	 */
	public String toString() {
		
		System.out.println("Label: "+getLabel());
		System.out.println("Prompt: "+getPrompt());
		System.out.println("Message: "+getMessage());
		System.out.println();
		
		return "";
	}
}
