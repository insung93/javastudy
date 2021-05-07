package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UDPTimeServer {
	public static final int PORT = 7000;

	public static void main(String[] args) {
		DatagramSocket socket = null;

		try {
			// 2. 데이터 수신
			socket = new DatagramSocket(PORT);
			while (true) {
				DatagramPacket receivePacket = new DatagramPacket(new byte[0], 0);
				socket.receive(receivePacket); // blocking

				// 3. 데이터 송신
				String now = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a").format(new Date());
				byte[] sendData = now.getBytes();
				DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, receivePacket.getAddress(),
						receivePacket.getPort());
				socket.send(sendPacket);
			}

		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null && socket.isClosed() == false) {
				socket.close();
			}
		}

	}

}