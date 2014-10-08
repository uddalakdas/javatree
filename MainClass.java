package javatree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
class MainClass { 
	public static void main(String args[])throws Exception
	{
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(new File("c:\\input.txt"));
		System.out.println("Enter a postfix expression : ");
		//String expression = br.readLine();
		String expression = sc.nextLine();
		System.out.println("Enter a Lambda_P : ");
		//Utils.lambdaP = Double.parseDouble(br.readLine());
		Utils.lambdaP = Double.parseDouble(sc.nextLine());
		System.out.println("Enter a Lambda_W : ");
		//Utils.lambdaW = Double.parseDouble(br.readLine());
		Utils.lambdaW = Double.parseDouble(sc.nextLine());
		
		PostFixToBinTree tree = new PostFixToBinTree(expression);
		BinTree binTree = tree.getBinTree();
		System.out.println("\n\nThe nodes displayed in Inorder are: \n\n");
		binTree.displayInorder();
		
		
		Node nodes[] = Utils.getNodesInArray(binTree);
		
		
		
		System.out.println("Nodes-------------");
		
		for (int i=0; i<nodes.length;i++)
			System.out.println("The node character: "+nodes[i].getCharacter());

		NodeDistance nodeDistance[] = Utils.setNodeDistance(nodes,binTree);
		Utils.calculateCost(nodeDistance);
		NodeDistance minNodeDistance = Utils.getMinCost(nodeDistance);
		
		System.out.println("Minimum Cost Function");
		System.out.println("Node1---------------");
		minNodeDistance.getNode1().displayContents("");
		System.out.println("Node2---------------");
		minNodeDistance.getNode2().displayContents("");
		
		System.out.println("Optimum Cost:" + minNodeDistance.getCost());
		System.out.println("Optimum Area: "+ Utils.getOptimumArea(binTree));
		
		
	}
}