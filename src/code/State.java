package code;
public class State {

	private int prosperity;
    private int food;
    private int materials;
    private int energy;
    private int moneySpent;
    private int budget;
    
    private int delayCountFood = 0;
	private int delayCountMaterials = 0;
	private int delayCountEnergy = 0;

	public State(int prosperity, int food, int materials, int energy, int moneySpent, int budget, int delayCountFood,
			int delayCountMaterials, int delayCountEnergy) {
		super();
		this.prosperity = prosperity;
		this.food = food;
		this.materials = materials;
		this.energy = energy;
		this.moneySpent = moneySpent;
		this.budget = budget;
		this.delayCountFood = delayCountFood;
		this.delayCountMaterials = delayCountMaterials;
		this.delayCountEnergy = delayCountEnergy;
	}

	public int getProsperity() {
		return prosperity;
	}
	public void setProsperity(int prosperity) {
		this.prosperity = prosperity;
	}
	public int getFood() {
		return food;
	}
	public void setFood(int food) {
		this.food = food;
	}
	public int getMaterials() {
		return materials;
	}
	public void setMaterials(int materials) {
		this.materials = materials;
	}
	public int getEnergy() {
		return energy;
	}
	public void setEnergy(int energy) {
		this.energy = energy;
	}
	public int getMoneySpent() {
		return moneySpent;
	}
	public void setMoneySpent(int moneySpent) {
		this.moneySpent = moneySpent;
	}
	public int getBudget() {
		return budget;
	}
	public void setBudget(int budget) {
		this.budget = budget;
	}
	public int getDelayCountFood() {
		return delayCountFood;
	}
	public void setDelayCountFood(int delayCountFood) {
		this.delayCountFood = delayCountFood;
	}
	public int getDelayCountMaterials() {
		return delayCountMaterials;
	}
	public void setDelayCountMaterials(int delayCountMaterials) {
		this.delayCountMaterials = delayCountMaterials;
	}
	public int getDelayCountEnergy() {
		return delayCountEnergy;
	}
	public void setDelayCountEnergy(int delayCountEnergy) {
		this.delayCountEnergy = delayCountEnergy;
	}
	public String toString() {
		
		return this.getProsperity()+ " " +this.getFood() + " " + this.getMaterials() +" "+ this.getEnergy() +" "+ this.getMoneySpent() + " " +this.getBudget()+ " " +this.getDelayCountFood() + " " +this.getDelayCountMaterials() + " " + this.getDelayCountEnergy();
	}
	
    public String display() {
		
		return "P: "+this.getProsperity()+ " " +"F: " +this.getFood() + " " +"M: "+ this.getMaterials() +" "+ "E: "+ this.getEnergy() +" "+ "MS: "+this.getMoneySpent() + " " +"B: "+this.getBudget()+ " " +"DF: "+this.getDelayCountFood() + " " +"DM: "+this.getDelayCountMaterials() + " " +"DE: "+ this.getDelayCountEnergy();
	}
	
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        State otherState = (State) obj;
        // Compare the string representations of the states
        return this.toString().equals(otherState.toString());
    }

    @Override
    public int hashCode() {
        // Generate a hash code based on the string representation
        return this.toString().hashCode();
    }
	
	
	public static void main(String[] args) {
		
	}


	
    

}
