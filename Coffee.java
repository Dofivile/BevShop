

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

public class Coffee extends Beverage {
	private final double SHOT_COST = 0.5;
	private final double SYRUP_COST = 0.5;
	private boolean extraShot;
	private boolean extraSyrup;
	
	
	

	public Coffee(String bev_name, Size size, boolean extraShot, boolean extraSyrup) {
		super(bev_name, Type.COFFEE, size);
		this.extraShot=extraShot;
		this.extraSyrup=extraSyrup;
	}

	@Override
	public double calcPrice() {
		double price=super.addSizePrice();
		
		if (extraShot) {
			price += SHOT_COST;
			
		}else if (extraSyrup) {
			price += SYRUP_COST;
		}
		
		return price;
		

	}
	public boolean getExtraShot() {
		return extraShot;
		
	}
	public boolean getExtraSyrup() {
		return extraSyrup;

		
	}
	
	@Override
	public boolean equals(Object anotherBev) {
		
		Coffee c= (Coffee) anotherBev;
		
		return (super.equals(c) && this.extraShot==c.extraShot && this.extraSyrup==c.extraSyrup);
	}


	@Override
	public String toString() {
		String str = getBevName() +", " +getSize();

		if (extraShot) {
		str += extraShot;
		}
		if (extraSyrup) {
		str += extraSyrup;
		}

		str += ", $" +calcPrice();

		return str;
		}

}
