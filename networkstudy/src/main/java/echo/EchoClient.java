package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EchoClient {
	private static String SERVER = "127.0.0.1";

	public static void main(String[] args) {
		Socket socket = null;
		BufferedReader br;
		PrintWriter pw;
		Scanner scanner = new Scanner(System.in);
		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress(SERVER, EchoServer.PORT));

			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8), true);
			while (true) {
				String input = scanner.nextLine();
				pw.println(input);
				String read = br.readLine();
				System.out.println(read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (socket != null && socket.isClosed() == false) {
				try {
					socket.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			scanner.close();
		}
	}

}
