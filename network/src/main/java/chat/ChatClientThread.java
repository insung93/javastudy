package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class ChatClientThread extends Thread {
	private BufferedReader br;
	Socket socket;

	public ChatClientThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			
			while(true) {
				String data = br.readLine();
				if(data==null) {
					break;
				}
				System.out.println(data);
			}
			
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException ex) {
			log("error:" + ex);
		} finally {
			try {
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void log(String log) {
		System.out.println("[clientThread] " + log);
	}
}
