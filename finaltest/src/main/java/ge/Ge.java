package ge;

public class Ge<K,V> {
	private K key;
	private V value;
	
	public Ge(K key, V value) {
		this.key = key;
		this.value = value;
	}
	public void pr() {
		System.out.println(this.key+"  "+this.value);
	}
}
