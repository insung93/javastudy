package tv;

public class WatchTV {

	public static void main(String[] args) {
		TV tv = new TV(7, 20, false);

		tv.status();

		tv.power(true);
		
		tv.volume(120);
		
		tv.volume(false);

		tv.channel(0);

		tv.channel(256);
		
		tv.channel(true);

		tv.volume(50);
		
		tv.volume(100);
		
		tv.volume(false);
		
		tv.channel(true);
		
		tv.channel(true);
		
		tv.power(false);

		tv.status();
	}

}
