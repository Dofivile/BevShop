
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

public class Alcohol extends Beverage {
	
	private final double WEEKEND_FEE = .6;
	private boolean isWeekend;

public Alcohol(String bev_name, Size size, boolean isWeekend) {
		super(bev_name, Type.ALCOHOL, size);
		this.isWeekend=isWeekend;
	}

	@Override
	public double calcPrice() {
		double price=super.addSizePrice();
		
		price= super.addSizePrice();
		
		if(isWeekend) {
			price+=WEEKEND_FEE;
		}
		
		return price;
		
		
	}
	
	public boolean isWeekend() {
		return isWeekend;
	}

	public void setWeekend(boolean isWeekend) {
		this.isWeekend = isWeekend;
	}
	public double getWEEKEND_FEE() {
		return WEEKEND_FEE;
	}

	@Override
	public String toString() {
		
		String str = getBevName() +"," +getSize();

		if (isWeekend) {
		str +=","+ isWeekend+",";
		}
		str += +calcPrice();
		
		return str;

	}
	@Override
	
	public boolean equals(Object anotherBev) {
		
		Alcohol a= (Alcohol) anotherBev;
		
		return (super.equals(a) && this.isWeekend == a.isWeekend());
		
	}
	
	
}
