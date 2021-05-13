package echo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class EchoClient2 {

	public static void main(String[] args) {
		Socket socket = null;
		Scanner scanner = null;

		try {
			socket = new Socket();
			socket.connect(new InetSocketAddress("127.0.0.1", EchoServer.PORT));
			
			BufferedReader br = new BufferedReader((new InputStreamReader(socket.getInputStream(),"utf-8")));
			PrintWriter pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(),"utf-8"),true);
			scanner = new Scanner(System.in);
			while (true) {
				System.out.print(">");
				String line = scanner.nextLine();
				if ("exit".equals(line)) {
					break;
				}
				//pw.write(line);
				pw.println(line);
				String data = br.readLine();
				if (data == null) {
					
					break;
				}

				// 8. 콘솔 출력
				System.out.println("<" + data);

			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (scanner != null) {
					scanner.close();
				}
				if (socket != null && socket.isClosed() == false) {
					socket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
