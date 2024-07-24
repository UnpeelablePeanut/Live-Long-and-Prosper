package code;



public class LLAPSearch extends GenericSearch {

	public static SearchProblem parse(String inputString) {
		String[] parts = inputString.split(";");

		// Parse and store initial values
		int prosperity = Integer.parseInt(parts[0].replace("Prosperity", "").trim());

		String[] resourceInitials = parts[1].split(",");
		int food = Integer.parseInt(resourceInitials[0].replace("Food", "").trim());

		int materials = Integer.parseInt(resourceInitials[1].replace("Materials", "").trim());

		int energy = Integer.parseInt(resourceInitials[2].replace("Energy", "").trim());

		// Parse and store resource prices
		String[] resourcePrices = parts[2].split(",");
		int unitPriceFood = Integer.parseInt(resourcePrices[0].replace("unitPriceFood", "").trim());

		int unitPriceMaterials = Integer.parseInt(resourcePrices[1].replace("unitPriceMaterials", "").trim());

		int unitPriceEnergy = Integer.parseInt(resourcePrices[2].replace("unitPriceEnergy", "").trim());

		// Parse and store delivery requests
		String[] foodRequest = parts[3].split(",");
		int amountRequestFood = Integer.parseInt(foodRequest[0].replace("amountRequestFood", "").trim());
		int delayRequestFood = Integer.parseInt(foodRequest[1].replace("delayRequestFood", "").trim());

		String[] materialsRequest = parts[4].split(",");
		int amountRequestMaterials = Integer.parseInt(materialsRequest[0].replace("amountRequestMaterials", "").trim());
		int delayRequestMaterials = Integer.parseInt(materialsRequest[1].replace("delayRequestMaterials", "").trim());

		String[] energyRequest = parts[5].split(",");
		int amountRequestEnergy = Integer.parseInt(energyRequest[0].replace("amountRequestEnergy", "").trim());
		int delayRequestEnergy = Integer.parseInt(energyRequest[1].replace("delayRequestEnergy", "").trim());

		// Parse and store BUILD1 and BUILD2 values
		String[] build1 = parts[6].split(",");
		int priceBUILD1 = Integer.parseInt(build1[0].replace("priceBUILD1", "").trim());
		int foodUseBUILD1 = Integer.parseInt(build1[1].replace("foodUseBUILD1", "").trim());
		int materialsUseBUILD1 = Integer.parseInt(build1[2].replace("materialsUseBUILD1", "").trim());
		int energyUseBUILD1 = Integer.parseInt(build1[3].replace("energyUseBUILD1", "").trim());
		int prosperityBUILD1 = Integer.parseInt(build1[4].replace("prosperityBUILD1", "").trim());

		String[] build2 = parts[7].split(",");
		int priceBUILD2 = Integer.parseInt(build2[0].replace("priceBUILD2", "").trim());
		int foodUseBUILD2 = Integer.parseInt(build2[1].replace("foodUseBUILD2", "").trim());
		int materialsUseBUILD2 = Integer.parseInt(build2[2].replace("materialsUseBUILD2", "").trim());
		int energyUseBUILD2 = Integer.parseInt(build2[3].replace("energyUseBUILD2", "").trim());
		int prosperityBUILD2 = Integer.parseInt(build2[4].replace("prosperityBUILD2", "").trim());

		SearchProblem p = new SearchProblem(prosperity, food, materials, energy, unitPriceFood, unitPriceMaterials,
				unitPriceEnergy, amountRequestFood, delayRequestFood, amountRequestMaterials, delayRequestMaterials,
				amountRequestEnergy, delayRequestEnergy, priceBUILD1, foodUseBUILD1, materialsUseBUILD1,
				energyUseBUILD1, prosperityBUILD1, priceBUILD2, foodUseBUILD2, materialsUseBUILD2, energyUseBUILD2,
				prosperityBUILD2);

		return p;
	}

	public static String solve(String initialState, String strategy, boolean visualize) {

		SearchProblem p = parse(initialState);
		

		/*Node root = new Node(p.getProsperity(), p.getFood(), p.getMaterials(), p.getEnergy(), p.getMoneySpent(),
				p.getBudget(), p.getDelayCountFood(), p.getDelayCountMaterials(), p.getDelayCountEnergy(), null, " ", 0,
				false, new ArrayList<>());*/

		
		SearchResult result =  GenericSearch.generalSearch(p, strategy);
		if(visualize) {
			System.out.println(result.getVisualize());
		}
		//System.out.println(result.getResult());
		
		
		
		return result.getResult();
		
		
	}

	
	

	public static void main(String[] args) {

		
		
	}

}
