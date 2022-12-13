

/*
 * Class: CMSC203 
 * Instructor:
 * Description: (Give a brief description for each Class)
 * Due: MM/DD/YYYY
 * Platform/compiler:
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Robel Endashaw
*/
public class Smoothie extends Beverage{
	
	private final double COST_OF_PROTEIN= 1.5;
	private final double COST_OF_FRUIT=0.5;
	private int numberOfFruit;
	private boolean addProtein;
	
	
	public Smoothie(String bev_name, Size size, int numberOffruit, boolean addProtein) {
		super(bev_name, Type.SMOOTHIE, size);
		this.numberOfFruit=numberOffruit;
		this.addProtein=addProtein;
	
	}

	@Override
	public double calcPrice() {
		double price=super.addSizePrice();
		
		price += this.numberOfFruit * COST_OF_FRUIT;
		if (addProtein) 
		price += COST_OF_PROTEIN;
		
		return price;

		
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		
		Smoothie s= (Smoothie) anotherBev;
				
		return (super.equals(s) &&this.numberOfFruit==s.numberOfFruit && this.addProtein==s.addProtein);
	}

	public int getNumOfFruits() {
		return numberOfFruit;
	}

	public void setNumberOfFruit(int numberOfFruit) {
		this.numberOfFruit = numberOfFruit;
	}

	public boolean getAddProtein() {
		return addProtein;
	}

	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}
	@Override
	public String toString() {
		String str= super.getBevName() +", " +super.getSize() +" " + this.numberOfFruit +" Fruits";
		
		if (addProtein) {
			str += " Protein powder";
		}
		return (str+" $"+ calcPrice());
	}
}
