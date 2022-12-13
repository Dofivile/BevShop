

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
import java.util.ArrayList;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order> {
	private int orderNumber;
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private ArrayList<Beverage> beverages;
	

	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderTime=orderTime;
		this.orderDay=orderDay;
		this.cust=cust;
		this.orderNumber= generateOrder();
		beverages = new ArrayList<>();
	}

	public int generateOrder() {
		Random rand_number= new Random();
		int randInt = rand_number.nextInt(90000-10000)+10_000;
		return randInt;
	}
	 

	@Override
	public boolean isWeekend() {
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
			return true;
			}
		return false;
	}

	@Override
	public Beverage getBeverage(int itemNo) {
		return beverages.get(itemNo);
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee c = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(c);
	}

	@Override
	public void addNewBeverage(String bevName, Size size) {
		boolean isWeekend = false;
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) {
		isWeekend = true;
		}
		Alcohol a = new Alcohol(bevName, size, isWeekend);
		beverages.add(a);
		
	}

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie s = new Smoothie(bevName, size, numOfFruits, addProtein);
		beverages.add(s);
		
	}

	@Override
	public double calcOrderTotal() {
		double orderTotal = 0;

		for (Beverage b : beverages) {
		orderTotal += b.calcPrice();
		}

		return orderTotal;
	}

	@Override
	public int findNumOfBeveType(Type type) {
		int count = 0;

		for (Beverage b : beverages) {
		if (b.getType() == type) {
		count++;
		}
		}

		return count;
	}

	@Override
	public int compareTo(Order o) {
		if(this.orderNumber== o.orderNumber) {
			return 0;
		} else if(this.orderNumber>o.orderNumber) {
			return 1;
		}else {
			return -1;
		}
	}

	public int getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(int orderNumber) {
		this.orderNumber = orderNumber;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(int orderTime) {
		this.orderTime = orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public void setOrderDay(Day orderDay) {
		this.orderDay = orderDay;
	}

	public Customer getCustomer() {
		return new Customer(cust);
	}

	public void setCust(Customer cust) {
		this.cust = cust;
	}

	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	public void setBeverages(ArrayList<Beverage> beverages) {
		this.beverages = beverages;
	}
	public int getTotalItems() {
		return beverages.size();
		
	}
	
	public String toString() {
		String s = "__________________________________"
		+orderDay.toString() +", " +orderTime
		+"\n" +cust.toString() +" Order Num: " +orderNumber;

		for (Beverage b : beverages) {
		s += "\n" +b.toString();
		}
		s += "\n Order Total: " +calcOrderTotal();

		return s;
		}

}
