package code;

public class Node {
	
	private State state;
	private Node parent;
	private String operator;
	private int depth;
	private int pathCost;
	
	
	public Node(State state, Node parent, String operator, int depth, int pathCost) {
		super();
		this.state = state;
		this.parent = parent;
		this.operator = operator;
		this.depth = depth;
		this.pathCost = pathCost;
	}
	
	public Node() {
		super();
	}

	public State getState() {
		return state;
	}


	public void setState(State state) {
		this.state = state;
	}


	public Node getParent() {
		return parent;
	}


	public void setParent(Node parent) {
		this.parent = parent;
	}


	public String getOperator() {
		return operator;
	}


	public void setOperator(String operator) {
		this.operator = operator;
	}


	public int getDepth() {
		return depth;
	}


	public void setDepth(int depth) {
		this.depth = depth;
	}


	public int getPathCost() {
		return pathCost;
	}


	public void setPathCost(int pathCost) {
		this.pathCost = pathCost;
	}
	
	




}

