package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatClient {

	public static void main(String[] args) {
		Scanner scanner = null;
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;

		try {
			// 1. 키보드 연결
			scanner = new Scanner(System.in);
			// 2. socket 생성
			socket = new Socket();

			// 3. 연결
			socket.connect(new InetSocketAddress(ChatServer.SERVER_IP, ChatServer.SERVER_PORT));
			// 4. reader/writer 생성
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

			// 5. join 프로토콜
			System.out.print("닉네임>>");
			String nickname = scanner.nextLine();
			pw.println("join:" + nickname);
			pw.flush();

			// 6. ChatClientReceiveThread 시작
			new ChatClientThread(socket).start();
			
			// 7. 키보드 입력 처리
			while (true) {
				System.out.print(">>");
				String message = scanner.nextLine();
				if ("quit".equals(message) == true) {
					// 8. quit 프로토콜 처리
					pw.println("quit");
					break;
				} else {
					// 9. 메시지 처리
					pw.println("message:"+message);
				}
			}

		} catch (IOException ex) {
			log("error:" + ex);
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

	public static void log(String message) {
		System.out.println("[client] " + message);
	}

}
