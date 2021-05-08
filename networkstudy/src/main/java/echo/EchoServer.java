package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServer {
	static int PORT = 6000;

	public static void main(String[] args) {
		Socket socket = null;
		ServerSocket serverSocket = null;
		BufferedReader br;
		PrintWriter pw;
		try {
			
			serverSocket = new ServerSocket();
			socket = new Socket();
			serverSocket.bind(new InetSocketAddress("0.0.0.0", PORT));
			socket = serverSocket.accept();

			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);

			while (true) {
				String line = br.readLine();
				System.out.println(line);
				pw.println("<"+line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (serverSocket != null && serverSocket.isClosed() == false) {
				try {
					serverSocket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}
