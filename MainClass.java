package javatree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class MainClass { 
	public static void main(String args[])throws IOException
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter a postfix expression : ");
		String expression = br.readLine();
		System.out.println("Enter a Lambda_P : ");
		Util.lambdaP = Double.parseDouble(br.readLine());
		System.out.println("Enter a Lambda_W : ");
		Util.lambdaW = Double.parseDouble(br.readLine());
		
		PostFixToBinTree tree = new PostFixToBinTree(expression);
		BinTree binTree = tree.getBinTree();
		System.out.println("\n\nThe nodes displayed in Inorder are: \n\n");
		binTree.displayInorder();
		
		
		Node nodes[] = Utils.getNodesInArray(binTree);
		int n = Utils.getNoOfNodes(binTree.getRoot());
		System.out.println("No of Nodes: "+n);
		
		
		System.out.println("Nodes-------------");
		
		for (int i=0; i<nodes.length;i++)
			System.out.println("The node character: "+nodes[i].getCharacter());

		NodeDistance nodeDistance[] = setNodeDistance(nodes,binTree);
		Utils.calculateCost(nodeDistance);
		NodeDistance minNodeDistance = Utils.getMinCost(nodeDistance);
		
		System.out.println("Minimum Cost Function");
		System.out.println("Node1---------------");
		minNodeDistance.getNode1().displayContents("");
		minNodeDistance.getNode2().displayContents("");
		
		System.out.print("Optimum Cost:" + minNodeDistance.getCost());
	}
}