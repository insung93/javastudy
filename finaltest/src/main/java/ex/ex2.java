package ex;

public class ex2 {
	private int x;
	private int y;

	public ex2(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public boolean equals(ex2 obj) {
		if (x == obj.x && y == obj.y) {
			return true;
		} else {
			return false;
		}
	}
}
