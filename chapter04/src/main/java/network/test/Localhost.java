package network.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Localhost {

	public static void main(String[] args) {
		try {
			InetAddress inetAddress = InetAddress.getLocalHost();
			
			String hostName = inetAddress.getHostName();
			String hostAddress = inetAddress.getHostAddress();
			InetAddress loopbackaddress = inetAddress.getLoopbackAddress();
			
			System.out.println(hostName);
			System.out.println(hostAddress);
			System.out.println(loopbackaddress);
			
			byte[] addresses = inetAddress.getAddress();
			
			for(byte address : addresses) {
				System.out.print((address & 0xff )+".");
			}
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
