package chapter03;

public class Goods2 {
	private String name;
	private int price;
	private int countSold;
	private int countStock;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price < 0) {
			price = 0;
		}
		this.price = price;
	}

	public int getCountSold() {
		return countSold;
		
	}

	public void setCountSold(int countSold) {
		this.countSold = countSold;
	}

	public int getCountStock() {
		return countStock;
	}

	public void setCountStock(int countStock) {
		this.countStock = countStock;
	}

	public void showInfo() {
		System.out.println(
				"name : " + name + ", price : " + price + ", countStock : " + countStock + ", countSold : " + countSold);
	}
	
	public int calcDiscountPrice(double rate) {
		int i =10;
		double d = (double)i;
		
//		double d2 = 2.5;
//		int i2 = d2
		int discountPrice = (int)(price * rate);
		return discountPrice;
	}

}
