package code;


import java.util.HashSet;
import java.util.LinkedList;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class GenericSearch {

	

	public static SearchResult generalSearch(SearchProblem p, String qFun) {

		
		State s = p.getInitialState();

		Node root = new Node(s, null, " ", 0, 0);

		if (qFun == "BF") {

			return breadthFirstSearch(p, root);
		}

		else if (qFun == "DF") {

			return depthFirstSearch(p, root);
		}

		else if (qFun == "ID") {

			return IterativeDeepeningSearch(p, root);

		} else if (qFun == "UC") {

			return uniformCostSearch(p, root);
		} else if (qFun == "GR1") {

			return greedySearch1(p, root);
		} else if (qFun == "AS1") {

			return AStarSearch1(p, root);
		} else if (qFun == "GR2") {

			return greedySearch2(p, root);
		} else if (qFun == "AS2") {

			return AStarSearch2(p, root);
		}

		return new SearchResult("NOSOLUTION", "");

	}

	public static void bfs(Queue<Node> queue, Queue<Node> expandedNodes) {

		for (Node node : expandedNodes) {

			queue.add(node);

		}

	}

	public static void dfs(Stack<Node> stack, Queue<Node> expandedNodes) {

		for (Node node : expandedNodes) {

			stack.push(node);

			// what to do about the queue??

		}

	}

	public static SearchResult breadthFirstSearch(SearchProblem p, Node n) {

		Queue<Node> queue = new LinkedList<>();
		int nodesExpanded = 0;
		String plan = "";
		String visualize = "";
		queue.add(n);
		Node node;
		while (!(queue.isEmpty())) {

			node = queue.remove();
			// System.out.println(visualizeNode(node));
			nodesExpanded++;

			if (goalTest(node, p)) {

				int cost = node.getPathCost();
				while (node != null) {

					plan = node.getOperator() + "," + plan;
					visualize = node.getState().display()+ "A: "+ node.getOperator() + "\n" + visualize;
					node = node.getParent();
				}

				plan = plan.substring(2, plan.length() - 1);
				String response = plan + ";" + cost + ";" + nodesExpanded;

				return new SearchResult(response, visualize);
			}

			Queue<Node> expandedNodes = p.expand(node);
			bfs(queue, expandedNodes);

		}

		return new SearchResult("NOSOLUTION", visualize);

	}

	public static SearchResult depthFirstSearch(SearchProblem p, Node n) {
		Stack<Node> stack = new Stack<>();
		String plan = "";
		String visualize = "";
		int nodesExpanded = 0;
		stack.push(n);
		// Node node = new Node();
		while (!(stack.isEmpty())) {
			// Node node = new Node();
			Node node = stack.pop();
			// System.out.println(visualizeNode(node));
			nodesExpanded++;

			if (goalTest(node, p)) {
				int moneySpent = node.getPathCost();
				while (node != null) {

					plan = node.getOperator() + "," + plan;
					visualize = node.getState().display()+ "A: "+ node.getOperator() + "\n" + visualize;
					node = node.getParent();
				}

				plan = plan.substring(2, plan.length() - 1);
				String response = plan + ";" + moneySpent + ";" + nodesExpanded;
				return new SearchResult(response, visualize);
			}

			Queue<Node> expandedNodes = p.expand(node);
			dfs(stack, expandedNodes);

		}

		return new SearchResult("NOSOLUTION", visualize);
	}

	public static SearchResult uniformCostSearch(SearchProblem p, Node n) {
		Queue<Node> ucqueue = new PriorityQueue<>(new NodeCostComparator());

		int nodesExpanded = 0;

		String plan = "";
		String visualize = "";
		ucqueue.add(n);

		Node node = new Node();
		while (!(ucqueue.isEmpty())) {
			// Node node = new Node();
			node = ucqueue.remove();
			// System.out.println(visualizeNode(node));
			nodesExpanded++;

			if (goalTest(node, p)) {
				int cost = node.getPathCost();
				while (node != null) {

					plan = node.getOperator() + "," + plan;
					visualize = node.getState().display()+ "A: "+ node.getOperator() + "\n" + visualize;
					node = node.getParent();
				}

				plan = plan.substring(2, plan.length() - 1);
				String response = plan + ";" + cost + ";" + nodesExpanded;
				return new SearchResult(response, visualize);
				}

			Queue<Node> expandedNodes = p.expand(node);
			bfs(ucqueue, expandedNodes);

		}

		return new SearchResult("NOSOLUTION", visualize);
	}

	public static IterativeDeepeningResult depthLimitedSearch(SearchProblem p, Node n, int depth,
			int totalNodesExpanded) {
		Stack<Node> stack = new Stack<>();
		String plan = "";
		String visualize = "";
		int nodesExpanded = 0;
		stack.push(n);
		Node node = new Node();
		while (!(stack.isEmpty())) {
			// Node node = new Node();
			node = stack.pop();
			// System.out.println(visualizeNode(node));
			nodesExpanded++;

			if (goalTest(node, p)) {
				int cost = node.getPathCost();
				while (node != null) {

					plan = node.getOperator() + "," + plan;
					visualize = node.getState().display()+ "A: "+ node.getOperator() + "\n" + visualize;
					node = node.getParent();
				}

				plan = plan.substring(2, plan.length() - 1);

				totalNodesExpanded += nodesExpanded;
				String response = plan + ";" + cost + ";" + totalNodesExpanded;
				return new IterativeDeepeningResult(response, nodesExpanded,visualize);
			}
			// System.out.println("current deth of node " + node.getDepth() + " depth: " +
			// depth);
			if (node.getDepth() < depth) {
				// System.out.println("Expanding at " + node.getDepth() + " " + depth);
				Queue<Node> expandedNodes = p.expand(node);
				dfs(stack, expandedNodes);
			}

		}

		return new IterativeDeepeningResult("NOSOLUTION", nodesExpanded, visualize);

	}

	public static SearchResult IterativeDeepeningSearch(SearchProblem p, Node n) {

		int totalNodesExpanded = 0;
		int nodesExpanded = 0;
		int currentNodesExpanded = 0;

		for (int depth = 0; depth < Integer.MAX_VALUE; depth++) {

			IterativeDeepeningResult result = depthLimitedSearch(p, n, depth, totalNodesExpanded);
			currentNodesExpanded = result.getNodesExpanded();

			// System.out.println(result + " at depth " + depth);
			// HashSet<String> states = new HashSet<>();
			p.setStates(new HashSet<>());
			if (result.getResult() != "NOSOLUTION") {
				// System.out.println(result);
				return new SearchResult(result.getResult(), result.getVisualize());
			} else if (currentNodesExpanded == nodesExpanded) {
				return new SearchResult("NOSOLUTION", result.getVisualize());
			} else {
				nodesExpanded = currentNodesExpanded;
			}
		}

		return new SearchResult("NOSOLUTION", "");
	}

	public static SearchResult greedySearch1(SearchProblem p, Node n) {

		Queue<Node> gqueue = new PriorityQueue<>(new Greedy1(p));

		int nodesExpanded = 0;

		String plan = "";
		String visualize = "";
		gqueue.add(n);
		Node node = new Node();
		while (!(gqueue.isEmpty())) {
			// Node node = new Node();
			node = gqueue.remove();
			// System.out.println(visualizeNode(node));
			nodesExpanded++;

			if (goalTest(node, p)) {
				int cost = node.getPathCost();
				while (node != null) {

					plan = node.getOperator() + "," + plan;
					visualize = node.getState().display()+ "A: "+ node.getOperator() + "\n" + visualize;
					node = node.getParent();
				}

				plan = plan.substring(2, plan.length() - 1);
				String response = plan + ";" + cost + ";" + nodesExpanded;
				return new SearchResult(response, visualize);
			}

			Queue<Node> expandedNodes = p.expand(node);
			bfs(gqueue, expandedNodes);

		}

		return new SearchResult("NOSOLUTION", visualize);

	}

	public static SearchResult greedySearch2(SearchProblem p, Node n) {

		Queue<Node> gqueue = new PriorityQueue<>(new Greedy2(p));

		int nodesExpanded = 0;

		String plan = "";
		String visualize = "";
		gqueue.add(n);
		Node node = new Node();
		while (!(gqueue.isEmpty())) {
			// Node node = new Node();
			node = gqueue.remove();
			// System.out.println(visualizeNode(node));
			nodesExpanded++;

			if (goalTest(node, p)) {
				int cost = node.getPathCost();
				while (node != null) {

					plan = node.getOperator() + "," + plan;
					visualize = node.getState().display()+ "A: "+ node.getOperator() + "\n" + visualize;
					node = node.getParent();
				}

				plan = plan.substring(2, plan.length() - 1);
				String response = plan + ";" + cost + ";" + nodesExpanded;
				return new SearchResult(response, visualize);
			}

			Queue<Node> expandedNodes = p.expand(node);
			bfs(gqueue, expandedNodes);

		}

		return new SearchResult("NOSOLUTION", visualize);

	}

	public static SearchResult AStarSearch1(SearchProblem p, Node n) {

		Queue<Node> gqueue = new PriorityQueue<>(new AStar1(p));

		int nodesExpanded = 0;

		String plan = "";
		String visualize = "";
		gqueue.add(n);
		Node node = new Node();
		while (!(gqueue.isEmpty())) {
			// Node node = new Node();
			node = gqueue.remove();
			// System.out.println(visualizeNode(node));
			nodesExpanded++;

			if (goalTest(node, p)) {
				int cost = node.getPathCost();
				while (node != null) {

					plan = node.getOperator() + "," + plan;
					visualize = node.getState().display()+ "A: "+ node.getOperator() + "\n" + visualize;
					node = node.getParent();
				}

				plan = plan.substring(2, plan.length() - 1);
				String response = plan + ";" + cost + ";" + nodesExpanded;
				return new SearchResult(response, visualize);
			}

			Queue<Node> expandedNodes = p.expand(node);
			bfs(gqueue, expandedNodes);

		}

		return new SearchResult("NOSOLUTION", visualize);

	}

	public static SearchResult AStarSearch2(SearchProblem p, Node n) {

		Queue<Node> gqueue = new PriorityQueue<>(new AStar2(p));

		int nodesExpanded = 0;

		String plan = "";
		String visualize = "";
		gqueue.add(n);
		Node node = new Node();
		while (!(gqueue.isEmpty())) {
			// Node node = new Node();
			node = gqueue.remove();
			// System.out.println(visualizeNode(node));
			nodesExpanded++;

			if (goalTest(node,p)) {
				int cost = node.getPathCost();
				while (node != null) {

					plan = node.getOperator() + "," + plan;
					visualize = node.getState().display()+ "A: "+ node.getOperator() + "\n" + visualize;
					node = node.getParent();
				}

				plan = plan.substring(2, plan.length() - 1);
				String response = plan + ";" + cost + ";" + nodesExpanded;
				return new SearchResult(response, visualize);
			}

			Queue<Node> expandedNodes = p.expand(node);
			bfs(gqueue, expandedNodes);

		}

		return new SearchResult("NOSOLUTION", visualize);

	}

	public static boolean goalTest(Node n, SearchProblem p) {
		return p.goalTest(n);
	}

	/*public static String visualizeNode(Node node) {

		String n = "Depth: " + node.getDepth() + " Prosperity: " + node.getState().getProsperity() + " Food: "
				+ node.getState().getFood() + " Materials: " + node.getState().getMaterials() + " Energy: "
				+ node.getState().getEnergy() + " Money Spent: " + node.getState().getMoneySpent() + " Action: "
				+ node.getOperator() + " Waiting For Food: " + node.getState().getDelayCountFood()
				+ " Waiting For Energy: " + node.getState().getDelayCountEnergy() + " Waiting for Materials: "
				+ node.getState().getDelayCountMaterials();

		return n;
	}*/

	public static void main(String[] args) {

	}

}