package javatree;
class NodeDistance{
	private Node node1,node2;
	private int distance;
	private double cost;

	public Node getNode1(){
		return node1;
	}
	public void setNode1(Node node1){
		this.node1=node1;
	}
	public Node getNode2(){
		return node2;
	}
	public void setNode2(Node node2){
		this.node2=node2;
	}
	public int getDistance(){
		return distance;
	}
	public void setDistance(int distance){
		this.distance=distance;
	}
	public double getCost(){
		return cost;
	}
	public void setCost(double cost){
		this.cost=cost;
	}
		
}