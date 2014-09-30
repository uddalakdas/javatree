package javatree;
class BinTree {
	private Node root;
	public Node getRoot(){
		return root;
	}
	public void setRoot(Node root){
		this.root = root;
	}
	public void displayInorder(){
		inorder(root);	
	}
	private void inorder(Node node){
		if(node.getLeft() != null)
		inorder(node.getLeft());

		node.displayContents("");
		
		if(node.getRight() != null)
		inorder(node.getRight());
	}
}
