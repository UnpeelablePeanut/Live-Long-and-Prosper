package code;

import java.util.HashSet;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SearchProblem  {
	private int prosperity;
	private int food;
	private int materials;
	private int energy;
	private int budget = 100000;

	private int unitPriceFood;
	private int unitPriceMaterials;
	private int unitPriceEnergy;

	private int amountRequestFood;
	private int delayRequestFood;

	private int amountRequestMaterials;
	private int delayRequestMaterials;

	private int amountRequestEnergy;
	private int delayRequestEnergy;

	private int priceBUILD1;
	private int foodUseBUILD1;
	private int materialsUseBUILD1;
	private int energyUseBUILD1;
	private int prosperityBUILD1;

	private int priceBUILD2;
	private int foodUseBUILD2;
	private int materialsUseBUILD2;
	private int energyUseBUILD2;
	private int prosperityBUILD2;

	private int delayCountFood = 0;
	private int delayCountMaterials = 0;
	private int delayCountEnergy = 0;

	private int moneySpent = 0;
	
	private State initialState;

	private HashSet<String> states = new HashSet<>();
	
	

	public SearchProblem(int prosperity, int food, int materials, int energy, int unitPriceFood, int unitPriceMaterials,
			int unitPriceEnergy, int amountRequestFood, int delayRequestFood, int amountRequestMaterials,
			int delayRequestMaterials, int amountRequestEnergy, int delayRequestEnergy, int priceBUILD1,
			int foodUseBUILD1, int materialsUseBUILD1, int energyUseBUILD1, int prosperityBUILD1, int priceBUILD2,
			int foodUseBUILD2, int materialsUseBUILD2, int energyUseBUILD2, int prosperityBUILD2) {
		super();
		this.prosperity = prosperity;
		this.food = food;
		this.materials = materials;
		this.energy = energy;
		this.unitPriceFood = unitPriceFood;
		this.unitPriceMaterials = unitPriceMaterials;
		this.unitPriceEnergy = unitPriceEnergy;
		this.amountRequestFood = amountRequestFood;
		this.delayRequestFood = delayRequestFood;
		this.amountRequestMaterials = amountRequestMaterials;
		this.delayRequestMaterials = delayRequestMaterials;
		this.amountRequestEnergy = amountRequestEnergy;
		this.delayRequestEnergy = delayRequestEnergy;
		this.priceBUILD1 = priceBUILD1;
		this.foodUseBUILD1 = foodUseBUILD1;
		this.materialsUseBUILD1 = materialsUseBUILD1;
		this.energyUseBUILD1 = energyUseBUILD1;
		this.prosperityBUILD1 = prosperityBUILD1;
		this.priceBUILD2 = priceBUILD2;
		this.foodUseBUILD2 = foodUseBUILD2;
		this.materialsUseBUILD2 = materialsUseBUILD2;
		this.energyUseBUILD2 = energyUseBUILD2;
		this.prosperityBUILD2 = prosperityBUILD2;
		this.initialState = new State(prosperity, food, materials, energy, 0,
				budget, 0, 0, 0);
	}

	public State getInitialState() {
		return initialState;
	}

	public void setInitialState(State initialState) {
		this.initialState = initialState;
	}

	public int getProsperity() {
		return prosperity;
	}

	public void setProsperity(int Prosperity) {
		this.prosperity = Prosperity;
	}

	public int getFood() {
		return food;
	}

	public void setFood(int Food) {
		this.food = Food;
	}

	public int getMaterials() {
		return materials;
	}

	public void setMaterials(int Materials) {
		this.materials = Materials;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int Energy) {
		this.energy = Energy;
	}

	public int getUnitPriceFood() {
		return unitPriceFood;
	}

	public void setUnitPriceFood(int unitPriceFood) {
		this.unitPriceFood = unitPriceFood;
	}

	public int getUnitPriceMaterials() {
		return unitPriceMaterials;
	}

	public void setUnitPriceMaterials(int unitPriceMaterials) {
		this.unitPriceMaterials = unitPriceMaterials;
	}

	public int getUnitPriceEnergy() {
		return unitPriceEnergy;
	}

	public void setUnitPriceEnergy(int unitPriceEnergy) {
		this.unitPriceEnergy = unitPriceEnergy;
	}

	public int getAmountRequestFood() {
		return amountRequestFood;
	}

	public void setAmountRequestFood(int amountRequestFood) {
		this.amountRequestFood = amountRequestFood;
	}

	public int getDelayRequestFood() {
		return delayRequestFood;
	}

	public void setDelayRequestFood(int delayRequestFood) {
		this.delayRequestFood = delayRequestFood;
	}

	public int getAmountRequestMaterials() {
		return amountRequestMaterials;
	}

	public void setAmountRequestMaterials(int amountRequestMaterials) {
		this.amountRequestMaterials = amountRequestMaterials;
	}

	public int getDelayRequestMaterials() {
		return delayRequestMaterials;
	}

	public void setDelayRequestMaterials(int delayRequestMaterials) {
		this.delayRequestMaterials = delayRequestMaterials;
	}

	public int getAmountRequestEnergy() {
		return amountRequestEnergy;
	}

	public void setAmountRequestEnergy(int amountRequestEnergy) {
		this.amountRequestEnergy = amountRequestEnergy;
	}

	public int getDelayRequestEnergy() {
		return delayRequestEnergy;
	}

	public void setDelayRequestEnergy(int delayRequestEnergy) {
		this.delayRequestEnergy = delayRequestEnergy;
	}

	public int getPriceBUILD1() {
		return priceBUILD1;
	}

	public void setPriceBUILD1(int priceBUILD1) {
		this.priceBUILD1 = priceBUILD1;
	}

	public int getFoodUseBUILD1() {
		return foodUseBUILD1;
	}

	public void setFoodUseBUILD1(int foodUseBUILD1) {
		this.foodUseBUILD1 = foodUseBUILD1;
	}

	public int getMaterialsUseBUILD1() {
		return materialsUseBUILD1;
	}

	public void setMaterialsUseBUILD1(int materialsUseBUILD1) {
		this.materialsUseBUILD1 = materialsUseBUILD1;
	}

	public int getEnergyUseBUILD1() {
		return energyUseBUILD1;
	}

	public void setEnergyUseBUILD1(int energyUseBUILD1) {
		this.energyUseBUILD1 = energyUseBUILD1;
	}

	public int getProsperityBUILD1() {
		return prosperityBUILD1;
	}

	public void setProsperityBUILD1(int prosperityBUILD1) {
		this.prosperityBUILD1 = prosperityBUILD1;
	}

	public int getPriceBUILD2() {
		return priceBUILD2;
	}

	public void setPriceBUILD2(int priceBUILD2) {
		this.priceBUILD2 = priceBUILD2;
	}

	public int getFoodUseBUILD2() {
		return foodUseBUILD2;
	}

	public void setFoodUseBUILD2(int foodUseBUILD2) {
		this.foodUseBUILD2 = foodUseBUILD2;
	}

	public int getMaterialsUseBUILD2() {
		return materialsUseBUILD2;
	}

	public void setMaterialsUseBUILD2(int materialsUseBUILD2) {
		this.materialsUseBUILD2 = materialsUseBUILD2;
	}

	public int getEnergyUseBUILD2() {
		return energyUseBUILD2;
	}

	public void setEnergyUseBUILD2(int energyUseBUILD2) {
		this.energyUseBUILD2 = energyUseBUILD2;
	}

	public int getProsperityBUILD2() {
		return prosperityBUILD2;
	}

	public void setProsperityBUILD2(int prosperityBUILD2) {
		this.prosperityBUILD2 = prosperityBUILD2;
	}

	public int getDelayCountFood() {
		return this.delayCountFood;
	}

	public void setDelayCountFood(int delay) {
		this.delayCountFood = delay;
	}

	public int getDelayCountMaterials() {
		return this.delayCountMaterials;
	}

	public void setDelayCountMaterials(int delay) {
		this.delayCountMaterials = delay;
	}

	public int getDelayCountEnergy() {
		return this.delayCountEnergy;
	}

	public void setDelayCountEnergy(int delay) {
		this.delayCountEnergy = delay;
	}

	public int getBudget() {
		return budget;
	}

	public void setBudget(int budget) {
		this.budget = budget;
	}

	public int getMoneySpent() {
		return moneySpent;
	}

	public void setMoneySpent(int moneySpent) {
		this.moneySpent = moneySpent;
	}

	public void addFood(Node n) {
		// n.setFood(n.getState().getFood() + this.getAmountRequestFood());
		State state = n.getState();

		if (state.getFood() + this.getAmountRequestFood() > 50) {
			state.setFood(50);

		} else {
			state.setFood(state.getFood() + this.getAmountRequestFood());
		}

		n.setState(state);
	}

	public void addMaterials(Node n) {
		// n.setMaterials(n.getState().getMaterials() +
		// this.getAmountRequestMaterials());
		State state = n.getState();
		if (state.getMaterials() + this.getAmountRequestMaterials() > 50) {
			state.setMaterials(50);

		} else {
			state.setMaterials(state.getMaterials() + this.getAmountRequestMaterials());
		}
		n.setState(state);
	}

	public void addEnergy(Node n) {
		// n.setEnergy(n.getState().getEnergy() + this.getAmountRequestEnergy());
		State state = n.getState();

		if (state.getEnergy() + this.getAmountRequestEnergy() > 50) {
			state.setEnergy(50);

		} else {
			state.setEnergy(state.getEnergy() + this.getAmountRequestEnergy());
		}

		n.setState(state);
	}

	public Queue<Node> expand(Node node) {

		Queue<Node> children = new LinkedList<>();

		if (!states.contains(node.getState().toString())) {
			states.add(node.getState().toString());
		}

		if (node.getState().getProsperity() < 100) {

			if (node.getState().getDelayCountEnergy() == 0 && node.getState().getDelayCountFood() == 0
					&& node.getState().getDelayCountMaterials() == 0) {
				int price = this.getUnitPriceEnergy() + this.getUnitPriceFood() + this.getUnitPriceMaterials();
				int priceBuild1 = this.getPriceBUILD1() + this.getUnitPriceEnergy() * this.getEnergyUseBUILD1()
						+ this.getUnitPriceFood() * this.getFoodUseBUILD1() + this.getUnitPriceMaterials()
						* this.getMaterialsUseBUILD1();
				int priceBuild2 = this.getPriceBUILD2() + this.getUnitPriceEnergy() * this.getEnergyUseBUILD2()
						+ this.getUnitPriceFood() * this.getFoodUseBUILD2() + this.getUnitPriceMaterials()
						* this.getMaterialsUseBUILD2();
				;
				if (node.getState().getFood() > this.getFoodUseBUILD2()
						&& node.getState().getMaterials() > this.getMaterialsUseBUILD2()
						&& node.getState().getEnergy() > this.getEnergyUseBUILD2()
								& node.getState().getBudget() >= priceBuild2) {

					//Node node2 = this.build2(node);

					if (!(states.contains(this.build2(node).getState().toString()))) {
						//System.out.println(node2.getState().toString().hashCode());
						children.add(this.build2(node));
						states.add(this.build2(node).getState().toString());

					}
				}
				if (node.getState().getFood() > this.getFoodUseBUILD1()
						&& node.getState().getMaterials() > this.getMaterialsUseBUILD1()
						&& node.getState().getEnergy() > this.getEnergyUseBUILD1()
								& node.getState().getBudget() >= priceBuild1) {

					//Node node1 = this.build1(node);

					if (!(states.contains(this.build1(node).getState().toString()))) {
						//System.out.println(node1.getState().toString().hashCode());
						children.add(this.build1(node));
						states.add(this.build1(node).getState().toString());

					}
				}

				/*if (node.getState().getFood() > 0 && node.getState().getMaterials() > 0
						&& node.getState().getEnergy() > 0 & node.getState().getBudget() >= price) {

					//Node node3 = this.Wait(node);

					if(!(states.contains(Wait(node).getState().toString()))) {
						//System.out.println(node3.getState().toString().hashCode());
                        children.add(Wait(node));
                        states.add(Wait(node).getState().toString());

						
					}
				}*/

				// build

				if (node.getState().getFood() > 0 && node.getState().getMaterials() > 0
						&& node.getState().getEnergy() > 0 & node.getState().getBudget() >= price) {

					//Node node4 = this.requestFood(node);
					//Node node5 = this.requestEnergy(node);
					//Node node6 = this.requestMaterials(node);
                    
					if(node.getState().getFood()<50) {
					if(!(states.contains(this.requestFood(node).getState().toString()))) {
						//System.out.println(node4.getState().toString().hashCode());
                        children.add(this.requestFood(node));
                        states.add(this.requestFood(node).getState().toString());

						
					}
					}
					if(node.getState().getEnergy()<50) {
					if(!(states.contains(this.requestEnergy(node).getState().toString()))) {
						//System.out.println(node5.getState().toString().hashCode());
                        children.add(this.requestEnergy(node));
                        states.add(this.requestEnergy(node).getState().toString());

						
					}
				}
					if(node.getState().getEnergy()<50) {
					if(!(states.contains(this.requestMaterials(node).getState().toString()))) {
						//System.out.println(node6.getState().toString().hashCode());
                        children.add(this.requestMaterials(node));
                        states.add(this.requestMaterials(node).getState().toString());

						
					}
					}
				}

			} else {
				// wait and build
				int price = this.getUnitPriceEnergy() + this.getUnitPriceFood() + this.getUnitPriceMaterials();
				int priceBuild1 = this.getPriceBUILD1() + this.getUnitPriceEnergy() * this.getEnergyUseBUILD1()
						+ this.getUnitPriceFood() * this.getFoodUseBUILD1() + this.getUnitPriceMaterials()
						* this.getMaterialsUseBUILD1();
				int priceBuild2 = this.getPriceBUILD2() + this.getUnitPriceEnergy() * this.getEnergyUseBUILD2()
						+ this.getUnitPriceFood() * this.getFoodUseBUILD2() + this.getUnitPriceMaterials()
						*this.getMaterialsUseBUILD2();
				;

				if (node.getState().getFood() > this.getFoodUseBUILD2()
						&& node.getState().getMaterials() > this.getMaterialsUseBUILD2()
						&& node.getState().getEnergy() > this.getEnergyUseBUILD2()
								& node.getState().getBudget() >= priceBuild2) {

					//Node node9 = this.build2(node);

					if(!(states.contains(this.build2(node).getState().toString()))) {
						//System.out.println(node9.getState().toString().hashCode());
                        children.add(this.build2(node));
                        states.add(this.build2(node).getState().toString());

						
					}
				}
				if (node.getState().getFood() > this.getFoodUseBUILD1()
						&& node.getState().getMaterials() > this.getMaterialsUseBUILD1()
						&& node.getState().getEnergy() > this.getEnergyUseBUILD1()
								& node.getState().getBudget() >= priceBuild1) {

					//Node node8 = this.build1(node);

					if(!(states.contains(this.build1(node).getState().toString()))) {
						//System.out.println(node8.getState().toString().hashCode());
                        children.add(this.build1(node));
                        states.add(this.build1(node).getState().toString());

						
					}
				}

				if (node.getState().getFood() > 0 && node.getState().getMaterials() > 0
						&& node.getState().getEnergy() > 0 & node.getState().getBudget() >= price) {

					//Node node7 = this.Wait(node);

					if(!(states.contains(this.Wait(node).getState().toString()))) {
						//System.out.println(node7.getState().toString().hashCode());
                        children.add(this.Wait(node));
                        states.add(this.Wait(node).getState().toString());

						
					}
				}

			}
		}
		return children;
	}

	public HashSet<String> getStates() {
		return states;
	}

	public void setStates(HashSet<String> states) {
		this.states = states;
	}

	public Node requestFood(Node node) {

		int food = node.getState().getFood() - 1;
		int materials = node.getState().getMaterials() - 1;
		int energy = node.getState().getEnergy() - 1;
		int moneySpent = node.getState().getMoneySpent() + this.getUnitPriceEnergy() + this.getUnitPriceFood()
				+ this.getUnitPriceMaterials();
		int budget = node.getState().getBudget() - this.getUnitPriceEnergy() - this.getUnitPriceFood()
				- this.getUnitPriceMaterials();

		int delayCountFood = this.getDelayRequestFood();

		String action = "RequestFood"; // The action that led to this state
		

		State s = new State(node.getState().getProsperity(), food, materials, energy, moneySpent, budget,
				delayCountFood, 0, 0);
		Node n = new Node(s, node, action, node.getDepth() + 1, moneySpent);
		return n;
	}

	public Node requestMaterials(Node node) {
		int food = node.getState().getFood() - 1;
		int materials = node.getState().getMaterials() - 1;
		int energy = node.getState().getEnergy() - 1;
		int moneySpent = node.getState().getMoneySpent() + this.getUnitPriceEnergy() + this.getUnitPriceFood()
				+ this.getUnitPriceMaterials();
		int budget = node.getState().getBudget() - this.getUnitPriceEnergy() - this.getUnitPriceFood()
				- this.getUnitPriceMaterials();

		int delayCountMaterials = this.getDelayRequestMaterials();

		String action = "RequestMaterials"; // The action that led to this state
		
		

		State s = new State(node.getState().getProsperity(), food, materials, energy, moneySpent, budget, 0,
				delayCountMaterials, 0);
		Node n = new Node(s, node, action, node.getDepth() + 1, moneySpent);
		return n;

	}

	public Node requestEnergy(Node node) {
		int food = node.getState().getFood() - 1;
		int materials = node.getState().getMaterials() - 1;
		int energy = node.getState().getEnergy() - 1;
		int moneySpent = node.getState().getMoneySpent() + this.getUnitPriceEnergy() + this.getUnitPriceFood()
				+ this.getUnitPriceMaterials();
		int budget = node.getState().getBudget() - this.getUnitPriceEnergy() - this.getUnitPriceFood()
				- this.getUnitPriceMaterials();

		int delayCountEnergy = this.getDelayRequestEnergy();

		String action = "RequestEnergy"; // The action that led to this state
		
		State s = new State(node.getState().getProsperity(), food, materials, energy, moneySpent, budget, 0, 0,
				delayCountEnergy);
		Node n = new Node(s, node, action, node.getDepth() + 1, moneySpent);
		return n;
	}

	public Node Wait(Node node) {

		int food = node.getState().getFood() - 1;
		int materials = node.getState().getMaterials() - 1;
		int energy = node.getState().getEnergy() - 1;
		int moneySpent = node.getState().getMoneySpent() + this.getUnitPriceEnergy() + this.getUnitPriceFood()
				+ this.getUnitPriceMaterials();
		int budget = node.getState().getBudget() - this.getUnitPriceEnergy() - this.getUnitPriceFood()
				- this.getUnitPriceMaterials();

		String action = "WAIT"; // The action that led to this state
		
		State s = new State(node.getState().getProsperity(), food, materials, energy, moneySpent, budget,
				node.getState().getDelayCountFood(), node.getState().getDelayCountMaterials(),
				node.getState().getDelayCountEnergy());
		Node n = new Node(s, node, action, node.getDepth() + 1, moneySpent);
		this.helperRequests(n);
		return n;
	}

	public void helperRequests(Node n) { // Don't forget to ensure that no two or more delays are active at the same
		// time!!!!!!!
		if (n.getState().getDelayCountFood() > 0) {

			State s = n.getState();
			s.setDelayCountFood(n.getState().getDelayCountFood() - 1);
			n.setState(s);
			if (n.getState().getDelayCountFood() == 0) {
				addFood(n);
			}
		} else if (n.getState().getDelayCountMaterials() > 0) {
			State s = n.getState();
			s.setDelayCountMaterials(n.getState().getDelayCountMaterials() - 1);
			n.setState(s);
			if (n.getState().getDelayCountMaterials() == 0) {
				addMaterials(n);
			}
		} else if (n.getState().getDelayCountEnergy() > 0) {
			State s = n.getState();
			s.setDelayCountEnergy(n.getState().getDelayCountEnergy() - 1);
			n.setState(s);
			if (n.getState().getDelayCountEnergy() == 0) {
				addEnergy(n);
			}
		}
	}

	public Node build1(Node node) {
		int resourcesCost = this.getUnitPriceFood() * this.getFoodUseBUILD1()
				+ this.getUnitPriceEnergy() * this.getEnergyUseBUILD1()
				+ this.getUnitPriceMaterials() * this.getMaterialsUseBUILD1() + this.getPriceBUILD1();

		int food = node.getState().getFood() - this.getFoodUseBUILD1();
		int materials = node.getState().getMaterials() - this.getMaterialsUseBUILD1();
		int energy = node.getState().getEnergy() - this.getEnergyUseBUILD1();
		int moneySpent = node.getState().getMoneySpent() + resourcesCost;
		int budget = node.getState().getBudget() - resourcesCost;
		int prosperity = node.getState().getProsperity() + this.getProsperityBUILD1();
		String action = "BUILD1"; // The action that led to this state
		
		State s = new State(prosperity, food, materials, energy, moneySpent, budget,
				node.getState().getDelayCountFood(), node.getState().getDelayCountMaterials(),
				node.getState().getDelayCountEnergy());
		Node n = new Node(s, node, action, node.getDepth() + 1, moneySpent);
		this.helperRequests(n);
		return n;
		// check that there are sufficient amounts of all the resources before calling
		// the method build in the first place

	}

	public Node build2(Node node) {

		int resourcesCost = this.getUnitPriceFood() * this.getFoodUseBUILD2()
				+ this.getUnitPriceEnergy() * this.getEnergyUseBUILD2()
				+ this.getUnitPriceMaterials() * this.getMaterialsUseBUILD2() + this.getPriceBUILD2();

		int food = node.getState().getFood() - this.getFoodUseBUILD2();
		int materials = node.getState().getMaterials() - this.getMaterialsUseBUILD2();
		int energy = node.getState().getEnergy() - this.getEnergyUseBUILD2();
		int moneySpent = node.getState().getMoneySpent() + resourcesCost;
		int budget = node.getState().getBudget() - resourcesCost;
		int prosperity = node.getState().getProsperity() + this.getProsperityBUILD2();
		String action = "BUILD2"; // The action that led to this state
		
		State s = new State(prosperity, food, materials, energy, moneySpent, budget,
				node.getState().getDelayCountFood(), node.getState().getDelayCountMaterials(),
				node.getState().getDelayCountEnergy());
		Node n = new Node(s, node, action, node.getDepth() + 1, moneySpent);
		this.helperRequests(n);
		return n;
		// check that there are sufficient amounts of all the resources before calling
		// the method build in the first place

	}


	public boolean goalTest(Node node) {
		if (node.getState().getProsperity() >= 100) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {

		//String inputString = "50;30,20,40;5,3,4;15,2;10,1;20,2;100,10,15,5,10;200,20,30,10,20;";
		/*State s=  new State(21, 42, 18, 13, 95550, 4450, 1, 0, 0);
		Node n= new Node(s,null, "", 0, 0);
		LLAPSearch l = new LLAPSearch();
		String initialState4 = "21;" +
                "15,19,13;" +
                "50,50,50;" +
                "12,2;16,2;9,2;" +
                "3076,15,26,28,40;" +
                "5015,25,15,15,38;";
		SearchProblem p =  parse(initialState4);
		
		p.expand(n);*/
	}
}
