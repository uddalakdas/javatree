package javatree;
class Stack {
	private NodeStack top;
	public Stack(){
		top = null;
	}
	
	public void push(Node node){
		if(top == null){
			top = new NodeStack();
			top.setNode(node);
			top.setNext(null);
		}
		else{
			NodeStack temp = new NodeStack();
			temp.setNode(node);
			temp.setNext(top);
			top = temp;
		}
	}
	
	public Node pop(){
		if(top == null)
			return null;
		NodeStack temp = top;
		top=top.getNext();
		return temp.getNode();
	} 
}
