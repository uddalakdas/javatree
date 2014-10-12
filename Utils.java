package javatree;
class Utils {
	public static Node[] getNodesInArray(BinTree tree) {
		int noOfNodes = getNoOfNodes(tree.getRoot());
		
		Node nodes[]=new Node[noOfNodes];
		//nodes[0] = tree.getRoot();
		pushNodesIntoArray(nodes,tree.getRoot());
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
	private static int index=0;
	private static void pushNodesIntoArray(Node nodes[],Node node){
		nodes[index++]=node;
		if(node.getLeft() != null){
			pushNodesIntoArray(nodes,node.getLeft());
		}
		
		if(node.getRight() != null){
			pushNodesIntoArray(nodes,node.getRight());
		}
	}
	public static NodeDistance[] setNodeDistance(Node nodes[],BinTree tree){
		int noOfOperands = 0;
		for(int i=0;i<nodes.length;i++)
			if(nodes[i].getCharacter() != '+' && nodes[i].getCharacter() != '*')
				noOfOperands++;
		//System.out.println("No of Operands: "+noOfOperands);
		
		int noOfDistances = combination(noOfOperands,2);
		//System.out.println("No of combinations "+noOfDistances);
		NodeDistance nodeDistance[]=new NodeDistance[noOfDistances];
		int ind = 0;
		for(int i=0;i<nodes.length;i++){
			if(nodes[i].getCharacter()!='*' && nodes[i].getCharacter()!='+'){
				for(int j=i+1;j<nodes.length;j++){
					if(nodes[j].getCharacter()!='*' && nodes[j].getCharacter()!='+'){
						int distance = calculateDistance(nodes[i],nodes[j],tree);
						System.out.println("Distance of "+nodes[i].getCharacter()+" to "+nodes[j].getCharacter()+" is "+distance);
						//System.out.println("Node distance at index "+ind+" and value "+nodeDistance[ind]);
						nodeDistance[ind]=new NodeDistance();
						nodeDistance[ind].setNode1(nodes[i]);
						nodeDistance[ind].setNode2(nodes[j]);
						nodeDistance[ind].setDistance(distance);
						ind++;
					}
					
				}
			}
		}
		return nodeDistance;
		
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
	private static int height,minHeight,node1Found,node2Found,flag;
	public static int calculateDistance(Node node1,Node node2,BinTree tree){
		height = 0;
		minHeight = 100;
		node1Found = -1;
		node2Found = -1;
		flag=0;
		traverse(node1,node2,tree.getRoot());
		//System.out.println("Values of node1,node2 and minHeight are "+node1Found+","+node2Found+","+minHeight);
		return (node1Found+node2Found-2*minHeight);
	}
	public static void traverse(Node node1,Node node2,Node node){
		if(node1Found == -1){
			if(node1.getCharacter() == node.getCharacter()){
				node1Found = height;
				//System.out.println(node.getCharacter()+" found at height "+height);
			}
		}
		else if(node1Found !=-1 && node2Found == -1){
			if(node2.getCharacter() == node.getCharacter()){
				node2Found = height;
				//System.out.println(node.getCharacter()+" found at height "+height);
				flag=1;
				return;
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
			if(node1Found !=-1 && node2Found ==-1){
				if(height<minHeight)
					minHeight=height;
			}
			if(flag==1)
				return;
		}
		if(node.getRight()!=null){
			height++;
			traverse(node1,node2,node.getRight());
			height--;
			if(node1Found !=-1 && node2Found ==-1){
				if(height<minHeight)
					minHeight=height;
			}
			if(flag==1)
				return;
		}
		
	}
	public static double lambdaP,lambdaW;
	public static void calculateCost(NodeDistance nodeDistance[]){
		System.out.println("The nodes with the same voltage are :");
		for(int i=0;i<nodeDistance.length;i++){
			if(nodeDistance[i].getNode1().getVoltage()==nodeDistance[i].getNode2().getVoltage()){
				System.out.println("The nodes with characters "+nodeDistance[i].getNode1().getCharacter()+" and "+nodeDistance[i].getNode2().getCharacter()+" have same voltage : "+nodeDistance[i].getNode1().getVoltage());
				double areaNode1 = (nodeDistance[i].getNode1().getHeight())*(nodeDistance[i].getNode1().getWidth());
				double areaNode2 = (nodeDistance[i].getNode2().getHeight())*(nodeDistance[i].getNode2().getWidth());
				double area;
				if(areaNode1<areaNode2)
					area=areaNode1;
				else
					area=areaNode2;
				nodeDistance[i].setCost(area+(lambdaW*nodeDistance[i].getDistance())+(lambdaP*Math.pow(nodeDistance[i].getNode1().getVoltage(),2)*area));	
			}
			else{
				nodeDistance[i].setCost(999999);
			}
		}
	}
	public static NodeDistance getMinCost(NodeDistance nodeDistance[]){
		NodeDistance min = nodeDistance[0];
		for(int i=1;i<nodeDistance.length;i++){
			if(nodeDistance[i].getCost()!=999999 && min.getCost()>nodeDistance[i].getCost())
				min = nodeDistance[i];
		}
		return min;
	}
	public static double getOptimumArea(BinTree tree){
		setOperatorParameters(tree.getRoot());
		return (tree.getRoot().getWidth()*tree.getRoot().getHeight());
	}
	public static void setOperatorParameters(Node node){
		double wLeft,wRight,hLeft,hRight,width=0,height=0;
		if(node.getLeft().getCharacter()== '+' || node.getLeft().getCharacter()=='*'){
			setOperatorParameters(node.getLeft());
			
		}
		
		wLeft = node.getLeft().getWidth();
		hLeft=node.getLeft().getHeight();
		
		if(node.getRight().getCharacter()== '+' || node.getRight().getCharacter()=='*'){
			setOperatorParameters(node.getRight());
		}		
		
		wRight = node.getRight().getWidth();
		hRight = node.getRight().getHeight();
		
		
		if(node.getCharacter() == '+'){
			width = wLeft+wRight;
			height = hRight; 
			if(hLeft > hRight)
				height = hLeft;
			
		}
		else if(node.getCharacter() == '*'){
			height = hLeft+hRight;
			width = wRight;
			if(wLeft>wRight)
				width = wLeft;
		
		}
		node.setWidth(width);
		node.setHeight(height);
		
		
		
	}
	
}