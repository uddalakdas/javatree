package javatree;
class Utils {
	public static Node[] getNodesInArray(BinTree tree) {
		int noOfNodes = getNoOfNodes(tree.getRoot());
		Node nodes[]=new Node[noOfNodes];
		nodes[0] = tree.getRoot();
		pushNodesIntoArray(nodes,1,tree.getRoot());
		return nodes;
		
	}
	private static int getNoOfNodes(Node node){
		int nodes = 1;
		if(node.getLeft()!=null)
			nodes+=(getNoOfNodes(node.getLeft()));
		if(node.getRight()!=null)
			nodes+=getNoOfNodes(node.getRight()));
		return nodes;
	}
	private static void pushNodesIntoArray(Node nodes[],int index,Node node){
		if(node.getLeft() != null){
			nodes[index++]=node.getLeft();
			pushNodesIntoArray(nodes,index,node.getLeft());
		}
		if(node.getRight() != null){
			nodes[index++]=node.getRight();
			pushNodesIntoArray(nodes,index,node.getRight());
		}
	}
	public static 
	
}