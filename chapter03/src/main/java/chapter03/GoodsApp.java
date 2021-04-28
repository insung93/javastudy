package chapter03;

public class GoodsApp {

	public static void main(String[] args) {
		Goods goods = new Goods();
		goods.name = "camera";
		goods.price = 1000;
		goods.countstock=50;
		goods.countSold=20;
		
		System.out.println(goods.name);
	}

}
