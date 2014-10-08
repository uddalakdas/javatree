package javatree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.File;
class PostFixToBinTree {
	Scanner sc;
	String line;
	private char expression[];
	private BinTree tree;
	
	PostFixToBinTree(String expression) {
		this.expression = expression.toCharArray();
	}

	public BinTree getBinTree()throws Exception{
		sc = new Scanner(new File("c:\\input.txt"));
		String trash=sc.nextLine();
		String trash1=sc.nextLine();
		String trash2=sc.nextLine();
		int index=0;
		Stack stack = new Stack();		
		while(index < expression.length){
			char element = expression[index];
			if(element == '+' || element == '*'){
				Node operand2 = stack.pop();
				Node operand1 = stack.pop();
				Node temp = new Node();
				temp.setCharacter(element);
				temp.setLeft(operand1);
				temp.setRight(operand2);
				temp.setHeight(0.0);
				temp.setWidth(0.0);
				temp.setVoltage(0.0);
				stack.push(temp);
			}
			else {
				Node temp = new Node();
				temp.setCharacter(element);
				temp.setLeft(null);
				temp.setRight(null);
				line = sc.nextLine();
				inputNodeDetails(temp);		 
				stack.push(temp);
			}
			index++;
		}
		tree = new BinTree();
		tree.setRoot(stack.pop());
		return tree;
	
	}
	public void inputNodeDetails(Node node){
		try {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Scanner pc=new Scanner(line);
		System.out.println("Enter values for the Node with character : "+node.getCharacter());
		System.out.print("Enter Height: ");
		//node.setHeight(Double.parseDouble(br.readLine()));
		node.setHeight(pc.nextDouble());
		System.out.print("Enter width: ");
		//node.setWidth(Double.parseDouble(br.readLine()));
		node.setWidth(pc.nextDouble());
		System.out.print("Enter Voltage: ");
		//node.setVoltage(Double.parseDouble(br.readLine()));
		node.setVoltage(pc.nextDouble());
		//sc.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
		




