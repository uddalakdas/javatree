package javatree;
class NodeStack {
	private Node node;
	private NodeStack next;
	
	public Node getNode(){
		return node;
	}
	public void setNode(Node node){
		this.node = node;
	}
	public NodeStack getNext(){
		return next;
	}
	public void setNext(NodeStack next){
		this.next=next;
	}

	public void displayContents(){
		System.out.println("StackNode value : ");
		
		node.displayContents("\t");
		System.out.println("StackNode pointers: ");
		System.out.println("\t"+next);
		System.out.println();
	}
}