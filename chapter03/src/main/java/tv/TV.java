package tv;

public class TV {
	private int channel; // 1~255
	private int volume; // 0~100
	private boolean power;

	public void power(boolean on) {
		this.power=on;
	}

	public void channel(boolean up) {
		channel(channel + (up ? 1 : -1));
//		if(up) {
//			channel(this.channel+1);
//		} else {
//			channel(this.channel-1);
//		}
	}

	public void channel(int channel) {
		if(!power) {
			return;
		}
		
		if(channel>255) {
			channel = channel-255;
		} else if (channel < 0) {
			channel = (-channel);
		} else if (channel == 0) {
			return;
		}
			
		this.channel=channel;
		status();
	}

	public void volume(boolean up) {
		volume(volume + (up ? 1 : -1));
//		if(up) {
//			volume(this.volume+1);
//		}else {
//			volume(this.volume-1);
//		}
	}

	public void volume(int volume) {
		if(!power) {
			return;
		}
		if(volume > 100) {
			volume = 100;
		}else if(volume< 0) {
			volume = 0;
		}
		
		this.volume=volume;
		status();
	}

	public void status() {
		System.out.println("TV[power=" + power + ",channel=" + channel + ", volume=" + volume);
	}

	public TV(int channel, int volume, boolean power) {
		this.channel = channel;
		this.volume = volume;
		this.power = power;
	}
}
