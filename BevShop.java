
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

public class BevShop implements BevShopInterface {
	private int numberOfAlcohol;
	private int keepIndex=0;
	private ArrayList<Order> orders= new ArrayList<Order>() ;

	@Override
	public boolean isValidTime(int time) {
		
		if(time>=MIN_TIME && time<=MAX_TIME) {
			return true;
		}
		return false;
	}

	@Override
	public int getMaxNumOfFruits() {
		
		return MAX_FRUIT;
	}

	@Override
	public int getMinAgeForAlcohol() {
		
		return MIN_AGE_FOR_ALCOHOL;
	}

	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits > MAX_FRUIT) {
			return true;
			}
			return false;
	}

	@Override
	public int getMaxOrderForAlcohol() {
		
		return MAX_ORDER_FOR_ALCOHOL;
	}

	@Override
	public boolean isEligibleForMore() {
		if (numberOfAlcohol < 3) {
			return true;
		}
	
		return false;
	}

	@Override
	public int getNumOfAlcoholDrink() {
		
		return this.numberOfAlcohol;
	}

	@Override
	public boolean isValidAge(int age) {
		
		if (age >= MIN_AGE_FOR_ALCOHOL) {
			return true;
		}
		return false;
	}

	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {
		Customer customer = new Customer(customerName, customerAge);
		Order order = new Order(time, day, customer);
		this.orders.add(order);
		keepIndex = orders.indexOf(order);
		numberOfAlcohol = 0;
		
		
	}

	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		
		orders.get(keepIndex).addNewBeverage(bevName, size, extraShot, extraSyrup);
		
	}

	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		
		if( isEligibleForMore() ) {
		
		orders.get(keepIndex).addNewBeverage(bevName, size);
		numberOfAlcohol++;
		}
		
	}

	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		
		orders.get(keepIndex).addNewBeverage(bevName, size, numOfFruits, addProtein);		
	}

	@Override
	public int findOrder(int orderNo) {
		int found=0;
		
		for(int i=0;i<orders.size();++i) {
			if(orders.get(i).getOrderNumber()== orderNo) {
				found=i;
			}else {
				found=-1;
			}
			
		}
		return found;
	}

	@Override
	public double totalOrderPrice(int orderNo) {

		double orderSale = 0;

		for (Order order : orders) {
			if (order.getOrderNumber() == orderNo) {
				for (Beverage b : order.getBeverages()) {
					orderSale += b.calcPrice();
				}
			}
		}

		return orderSale;

		


	}

	@Override
	public double totalMonthlySale() {
		double totalSale = 0;

		for (Order o : orders) {
			for (Beverage b : o.getBeverages()) {
				totalSale += b.calcPrice();
			}
		}

		return totalSale;
	}

	@Override
	public int totalNumOfMonthlyOrders() {
		
		return orders.size();
	}

	@Override
	public Order getCurrentOrder() {
		
		return orders.get(keepIndex);
	}

	@Override
	public Order getOrderAtIndex(int index) {
		
		return orders.get(index);
	}

	@Override
	public void sortOrders() {

		for (int i = 0; i < orders.size()-1; i++) {
			int minOrderNumIdx = i;
			for (int j = i+1; j < orders.size(); j++) {
				if (orders.get(j).getOrderNumber() < orders.get(minOrderNumIdx).getOrderNumber()) {
					minOrderNumIdx = j;
				}
			}
		}


	}
}
