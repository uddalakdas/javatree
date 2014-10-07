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
			nodes+=getNoOfNodes(node.getRight());
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
	public static NodeDistance[] setNodeDistance(Node nodes[],BinTree tree){
		int noOfOperands = 0;
		for(int i=0;i<nodes.length;i++)
			if(nodes[i].getCharacter() != '+' && nodes[i].getCharacter() != '*')
				noOfOperands++;
		
		int nodOfDistances = combination(noOfOperands,2);
		NodeDistance nodeDistance[]=new NodeDistance[nodOfDistances];
		int index = 0;
		for(int i=0;i<nodes.length;i++){
			if(node[i].getCharacter()!='*' && node[i].getCharacter()!='+'){
				for(int j=0;j<nodes.length;j++){
					if(node[j].getCharacter()!='*' && node[j].getCharacter()!='+'){
						int distance = calculateDistance(node[i],node[j],tree);
						nodeDistance[index].setNode1(node[i]);
						nodeDistance[index].setNode2(node[j]);
						nodeDistance[index].setDistance(distance);
					}
				}
			}
		}
		
	}
	public static int combination(int n,int r){
		return (factorial(n)/(factorial(n-r)*factorial(r)));
	}
	public static int factorial(int n){
		int fact = 1;
		for(int i=1;i<=n;i++)
			fact*=i;
		return fact;
	}
	private static int height,minHeight,node1Found,node2Found;
	public static int calculateDistance(Node node1,Node node2,BinTree tree){
		height = 0;
		minHeight = 100;
		node1Found = -1;
		node2Found = -1;
		traverse(node1,node2,tree.getRoot());
		return (node1Found+node2Found-2*minHeight);
	}
	public void traverse(Node node1,Node node2,Node node){
		if(node1Found == -1){
			if(node1.getCharacter() == node.getCharacter()){
				node1Found = height;
			}
		}
		else if(node1Found !=-1 && node2Found == -1){
			if(node2.getCharacter() == node.getCharacter()){
				node2Found = height;
			}
			else{
				if(height<minHeight)
					minHeight=height;
			}
		}
		if(node.getLeft()!=null){
			height++;
			traverse(node1,node2,node.getLeft());
			height--;
		}
		if(node.getRight()!=null){
			height++;
			traverse(node1,node2,node.getRight());
			height--;
		}
		
	}
	public static double lambdaP,lambdaW;
	public static void calculateCost(NodeDistance nodeDistance[]){
		for(int i=0;i<nodeDistance.length;i++){
			if(nodeDistance[i].getNode1().getVoltage()==nodeDistance[i].getNode2().getVoltage()){
				double areaNode1 = nodeDistance[i].getNode1().getHeight()*nodeDistance[i].getNode1().getWidth();
				double areaNode2 = nodeDistance[i].getNode2().getHeight()*nodeDistance[i].getNode2().getWidth();
				double area;
				if(areaNode1<areaNode2)
					area=areaNode1;
				else
					area=areaNode2;
				nodeDistance[i].setCost(area+(lambdaW*nodeDistance[i].getDistance())+(lambdaP*Math.pow(nodeDistance[i].getNode1().getVoltage(),2)*area));	
			}
		}
	}
	public static NodeDistance getMinCost(NodeDistance nodeDistance[]){
		NodeDistance min = nodeDistance[0];
		for(i=1;i<nodeDistance.length;i++){
			if(min.getCost()<nodeDistance[i].getCost())
				min = nodeDistance[i];
		}
		return min;
	}
	
}