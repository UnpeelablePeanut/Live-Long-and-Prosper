package code;

public class SearchResult {

	private String result;
	String visualize;

	public SearchResult(String result, String visualize) {
		super();
		this.result = result;
		this.visualize = visualize;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getVisualize() {
		return visualize;
	}

	public void setVisualize(String visualize) {
		this.visualize = visualize;
	}

}
