package prob5;

public class MyStack {
	private String[] data;
	private int top = -1;

	public MyStack(int size) {
		data = new String[size];
		this.top=-1;
	}

	public void push(String data) {
		top++;
		if (this.data.length == top) {
			resize();
		}
		this.data[top]=data;
	}

	public String pop() throws MyStackException {
		if(top<0) {
			throw new MyStackException();
		}
		return data[top--];
	}

	public boolean isEmpty() {
		return (top == 0)?true:false;
	}
	
	public void resize() {
		int it = data.length;
		String[] temp = data;
		data = new String[data.length*2];
		for(int i=0;i<it;i++) {
			data[i]=temp[i];
		}
	}
	
}