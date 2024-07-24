package code;

import java.util.Comparator;

public class AStar1 implements Comparator<Node>{
	
	private SearchProblem p;
	
	

	public AStar1(SearchProblem p) {
		super();
		this.p = p;
	}
	
	public SearchProblem getP() {
		return p;
	}

	public void setP(SearchProblem p) {
		this.p = p;
	}

	@Override
    public int compare(Node n1, Node n2) {

		int build1Price = this.getP().getUnitPriceFood() * this.getP().getFoodUseBUILD1()
				+ this.getP().getUnitPriceEnergy() * this.getP().getEnergyUseBUILD1()
				+ this.getP().getUnitPriceMaterials() * this.getP().getMaterialsUseBUILD1() + this.getP().getPriceBUILD1();
		
		int build2Price = this.getP().getUnitPriceFood() * this.getP().getFoodUseBUILD2()
				+ this.getP().getUnitPriceEnergy() * this.getP().getEnergyUseBUILD2()
				+ this.getP().getUnitPriceMaterials() * this.getP().getMaterialsUseBUILD2() + this.getP().getPriceBUILD2();
		
		int n1ProsperityNeeded =  Math.max(100 - n1.getState().getProsperity(),0);
		double n1build1s = Math.ceil(n1ProsperityNeeded/this.getP().getProsperityBUILD1());
		double n1build2s = Math.ceil(n1ProsperityNeeded/this.getP().getProsperityBUILD2());
		double n1builds = Math.max(Math.min(n1build1s, n1build2s),0);
		//get the resources by distinguishing which one uses the minimum total number of resources and use it
		
		double n1cost = n1builds*Math.min(build1Price, build2Price) + n1.getPathCost();
		
		
		int n2ProsperityNeeded = Math.max(100 - n2.getState().getProsperity(),0);
		double n2build1s = Math.ceil(n2ProsperityNeeded/this.getP().getProsperityBUILD1());
		double n2build2s = Math.ceil(n2ProsperityNeeded/this.getP().getProsperityBUILD2());
		double n2builds = Math.max(Math.min(n2build1s, n2build2s),0);
		
		double n2cost = n2builds*Math.min(build1Price, build2Price) + n2.getPathCost();
		
        return n1cost < n2cost ? -1 : 1;
    }


}
