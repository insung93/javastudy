package prob6;

public class Rectangle extends Shape implements Resizable {

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public void resize(double arg) {
		// TODO Auto-generated method stub
		this.width *= arg;
		this.height *= arg;
	}

	@Override
	double getArea() {
		// TODO Auto-generated method stub
		return this.width * this.height;
	}

	@Override
	double getPerimeter() {
		// TODO Auto-generated method stub
		return (width+height)*2;
	}

}
