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
		
		PostFixToBinTree tree = new PostFixToBinTree(expression);
		BinTree binTree = tree.getBinTree();
		System.out.println("\n\nThe nodes displayed in Inorder are: \n\n");
		binTree.displayInorder();
	}
}