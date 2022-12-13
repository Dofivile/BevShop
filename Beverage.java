
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



public abstract class Beverage {
	private final double BASE_PRICE=2.0; 
	private final int SIZE_PRICE=1;
	private String bev_name;
	private  Type bev_type;
	private Size size;
	
	public Beverage(String bev_name, Type bev_type, Size size) {
		this.bev_name=bev_name;
		this.bev_type=bev_type;
		this.size=size;
	}
	
	public double getBasePrice() {
		return this.BASE_PRICE;
	}
	
	public Type getType() {
		return this.bev_type;
	}
	
	public String getBevName() {
		return this.bev_name;
	}
	public Size getSize() {
		return this.size;
	}
	public double addSizePrice() {
		double price=0.0;
		if(this.size.equals(Size.SMALL)) {
			price= BASE_PRICE;
		}else if(this.size.equals(Size.MEDIUM)) {
			price= (SIZE_PRICE + BASE_PRICE);

		}else {
			price= ((2*SIZE_PRICE) + BASE_PRICE);
		}
		return price;
		
	}
	
	public String getBev_name() {
		return bev_name;
	}

	public void setBev_name(String bev_name) {
		this.bev_name = bev_name;
	}

	public Type getBev_type() {
		return bev_type;
	}

	public void setBev_type(Type bev_type) {
		this.bev_type = bev_type;
	}

	public double getBASE_PRICE() {
		return BASE_PRICE;
	}

	public int getSIZE_PRICE() {
		return SIZE_PRICE;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public abstract double calcPrice();
	
	public String toString() {
		return this.bev_name+ " "+ this.bev_type +" "+ this.size;
	}
	@Override
	public boolean equals(Object anotherBev) {
		Beverage new_bev= (Beverage) anotherBev;
		
		return(this.bev_name.equals(new_bev.bev_name) && this.bev_type.equals(new_bev.bev_type) && this.size.equals(new_bev.size));
		
	} 
}
