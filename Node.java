package javatree;
class Node {
	
	private char character;
	private double width,height,voltage;
	private Node left,right;
	
	public char getCharacter() {
		return character;
	}
	public void setCharacter(char character){
		this.character = character;
	}

	public double getWidth() {
		return width;
	}
	public void setWidth(double width){
		this.width = width;
	}
	
	public double getVoltage() {
		return voltage;
	}
	public void setVoltage(double voltage){
		this.voltage = voltage;
	}
	
	public double getHeight(){
		return height;
	}
	
	public void setHeight(double height) {
		this.height=height;
	}

	public Node getLeft(){
		return left;
	}
	public void setLeft(Node left)
	{
		this.left=left;
	}
	public Node getRight(){
		return right;
	}
	public void setRight(Node right)
	{
		this.right=right;
	}

	public void displayContents(String gap) {
		gap = gap+"\t";
		System.out.println("Node values :");
		System.out.println(gap+"Character : "+character);
		System.out.println(gap+"Width : "+width);
		System.out.println(gap+"Height : "+height);
		System.out.println(gap+"Voltage : "+voltage);
		System.out.println("Node pointers :");
		System.out.println(gap+"Left : "+left);
		System.out.println(gap+"Right : "+right);
	}
}