package javatree;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class PostFixToBinTree {

	private char expression[];
	private BinTree tree;
	
	PostFixToBinTree(String expression) {
		this.expression = expression.toCharArray();
	}

	public BinTree getBinTree(){
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Enter values for the Node with character : "+node.getCharacter());
		System.out.print("Enter Height: ");
		node.setHeight(Double.parseDouble(br.readLine()));
		System.out.print("Enter width: ");
		node.setWidth(Double.parseDouble(br.readLine()));
		System.out.print("Enter Voltage: ");
		node.setVoltage(Double.parseDouble(br.readLine()));
		//sc.close();
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
		




