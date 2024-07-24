package code;

public class IterativeDeepeningResult {
	
	String result;
	int nodesExpanded;
	String visualize;
	public IterativeDeepeningResult(String result, int nodesExpanded, String visualize) {
		super();
		this.result = result;
		this.nodesExpanded = nodesExpanded;
		this.visualize = visualize;
	}
	public String getVisualize() {
		return visualize;
	}
	public void setVisualize(String visualize) {
		this.visualize = visualize;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public int getNodesExpanded() {
		return nodesExpanded;
	}
	public void setNodesExpanded(int nodesExpanded) {
		this.nodesExpanded = nodesExpanded;
	}
	
	public static void main(String[] args) {
		
	}
	

}
