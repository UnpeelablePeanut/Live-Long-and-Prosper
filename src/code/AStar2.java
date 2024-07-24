package code;

import java.util.Comparator;

public class AStar2 implements Comparator<Node>{
	
	
	
private SearchProblem p;
	
	

	public AStar2(SearchProblem p) {
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
		double n1builds = Math.min(n1build1s, n1build2s);
		//get the resources by distinguishing which one uses the minimum total number of resources and use it
		
		double n1cost = n1builds*Math.min(build1Price, build2Price) + n1.getPathCost();
		
		
		
		
		int n2ProsperityNeeded = Math.max(100 - n2.getState().getProsperity(),0);
		double n2build1s = Math.ceil(n2ProsperityNeeded/this.getP().getProsperityBUILD1());
		double n2build2s = Math.ceil(n2ProsperityNeeded/this.getP().getProsperityBUILD2());
		double n2builds = Math.min(n2build1s, n2build2s);
		
		double n2cost = n2builds*Math.min(build1Price, build2Price) + n2.getPathCost();
		
		int minBuilds1= Math.min((int)n1build1s, (int)n1build2s);
		
		int minFoodBuildn1 = Math.min(this.getP().getFoodUseBUILD1(), this.getP().getFoodUseBUILD2())* minBuilds1;
		int foodResourcesNeededn1 = Math.max(0,minFoodBuildn1-n1.getState().getFood());
		
        int minMaterialsBuildn1 = Math.min(this.getP().getMaterialsUseBUILD1(), this.getP().getMaterialsUseBUILD2())* minBuilds1;
		int materialsResourcesNeededn1 = Math.max(0,minMaterialsBuildn1-n1.getState().getMaterials());
		
        int minEnergyBuildn1 = Math.min(this.getP().getEnergyUseBUILD1(), this.getP().getEnergyUseBUILD2())* minBuilds1;
		int energyResourcesNeededn1 = Math.max(0,minEnergyBuildn1-n1.getState().getEnergy());
		
		int foodRequests1 = (int)Math.ceil(foodResourcesNeededn1/this.getP().getAmountRequestFood());
		int materialsRequests1 = (int)Math.ceil(materialsResourcesNeededn1/this.getP().getAmountRequestMaterials());
		int energyRequests1 = (int)Math.ceil(energyResourcesNeededn1/this.getP().getAmountRequestFood());
		
		int totalRequestsPricen1= (foodRequests1 + materialsRequests1 + energyRequests1)*(this.getP().getUnitPriceFood()+this.getP().getUnitPriceMaterials()+this.getP().getUnitPriceEnergy()) ;
		
		
        int minBuilds2= Math.min((int)n2build1s, (int)n2build2s);
		
		int minFoodBuildn2 = Math.min(this.getP().getFoodUseBUILD1(), this.getP().getFoodUseBUILD2())* minBuilds2;
		int foodResourcesNeededn2 = Math.max(0,minFoodBuildn2-n2.getState().getFood());
		
        int minMaterialsBuildn2 = Math.min(this.getP().getMaterialsUseBUILD1(), this.getP().getMaterialsUseBUILD2())* minBuilds2;
		int materialsResourcesNeededn2 = Math.max(0,minMaterialsBuildn2-n2.getState().getMaterials());
		
        int minEnergyBuildn2 = Math.min(this.getP().getEnergyUseBUILD1(), this.getP().getEnergyUseBUILD2())* minBuilds2;
		int energyResourcesNeededn2 = Math.max(0,minEnergyBuildn2-n2.getState().getEnergy());
		
		int foodRequests2 = (int)Math.ceil(foodResourcesNeededn2/this.getP().getAmountRequestFood());
		int materialsRequests2 = (int)Math.ceil(materialsResourcesNeededn2/this.getP().getAmountRequestMaterials());
		int energyRequests2 = (int)Math.ceil(energyResourcesNeededn2/this.getP().getAmountRequestFood());
		
		int totalRequestsPricen2= (foodRequests2 + materialsRequests2 + energyRequests2)*(this.getP().getUnitPriceFood()+this.getP().getUnitPriceMaterials()+this.getP().getUnitPriceEnergy()) ;
		
		n1cost += totalRequestsPricen1;
		n2cost += totalRequestsPricen2;
        return n1cost < n2cost ? -1 : 1;
    }


}
