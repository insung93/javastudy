package chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.net.Socket;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ChatServerThread extends Thread {
	private String nickname;
	private Socket socket;
	List<PrintWriter> listWriters;

	public ChatServerThread(Socket socket, List<PrintWriter> listPrintWriter) {
		this.socket = socket;
		this.listWriters = listWriters;
	}

	@Override
	public void run() {  

		BufferedReader br = null;
		PrintWriter pw = null;
		listWriters = new ArrayList<PrintWriter>();

//		InetSocketAddress inetRemoteSocketAddress = (InetSocketAddress) socket.getRemoteSocketAddress();
//		String remoteHostAddress = inetRemoteSocketAddress.getAddress().getHostAddress();
//		int remoteHostPort = inetRemoteSocketAddress.getPort();

		try {      
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), StandardCharsets.UTF_8));
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), StandardCharsets.UTF_8));

			while (true) {  
				String request = br.readLine();
				if (request == null) {
					doQuit(pw);
					break;
				}

				// 4. 프로토콜 분석
				String[] tokens = request.split(":");
				if ("join".equals(tokens[0])) {
					doJoin(tokens[1], pw);
					new ChatServerThread(socket,listWriters).start();
				} else if ("message".equals(tokens[0])) {
					doMessage(tokens[1]);
				} else if ("quit".equals(tokens[0])) {
					doQuit(pw);
				} else {
					System.out.println("알수없는 에러 : " + tokens[0]);
					break;
				}

			}

		} catch (SocketException e) {
			e.printStackTrace();
			doQuit(pw);
		} catch (IOException e) {
			e.printStackTrace();
			doQuit(pw);
		} finally {
			try {
				if( socket != null &&
					socket.isClosed() == false ) {
					socket.close();
				}
			}catch( IOException e ) {
				e.printStackTrace();
			}
		}

		super.run();
	}

	private void doQuit(PrintWriter pw) {
		removeWriter(pw);
		String message = nickname + "님이 퇴장 하였습니다";
		broadCast(message);
	}

	private void removeWriter(PrintWriter pw) {
		synchronized (listWriters) {
			listWriters.remove(pw);
		}
	}

	private void doMessage(String string) {
		String message = nickname + ":" + string;
		synchronized (listWriters) {
			broadCast(message);
		}
	}

	private void doJoin(String nickName, PrintWriter pw) {
		this.nickname = nickname;

		String data = nickName + "님이 참여하였습니다.";
		System.out.println(data);
		broadCast(data);

		/* writer pool에 저장 */
		addWriter(pw);

		// ack
		pw.println("join:ok");
	}

	private void broadCast(String data) {
		synchronized (listWriters) {
			for (Writer writer : listWriters) {
				PrintWriter printWriter = (PrintWriter) writer;
				printWriter.println(data);
			}
		}
	}

	private void addWriter(PrintWriter pw) {
		// -synchronized 키워드는 여러 스레드가 하나의 공유 객체에 접근할 때,
		// 동기화를 보장해준다.
		synchronized (listWriters) {
			listWriters.add(pw);
		}

	}
	public static void log(String log) {
		System.out.println("[serverThread] " + log);
	}

}
