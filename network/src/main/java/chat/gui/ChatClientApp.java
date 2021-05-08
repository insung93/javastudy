package chat.gui;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClientApp {

	public static void main(String[] args) {
		String name = null;
		Scanner scanner = new Scanner(System.in);

		while( true ) {
			
			System.out.println("대화명을 입력하세요.");
			System.out.print(">>> ");
			name = scanner.nextLine();
			
			if (name.isEmpty() == false ) {
				break;
			}
			
			System.out.println("대화명은 한글자 이상 입력해야 합니다.\n");
		}
		
		scanner.close();
		
		//1. create socket
		Socket socket = new Socket();
		//2. connect to server
		try {
			socket.connect(new InetSocketAddress("127.0.0.1",9999));
			//3. create iostream
			PrintWriter pw = new PrintWriter( new OutputStreamWriter(socket.getOutputStream(), "UTF-8" ), true );
			BufferedReader br = new BufferedReader( new InputStreamReader(socket.getInputStream(), "UTF-8" ) );
			//4. join
			pw.println("JOIN:"+name);
			String line = br.readLine();
			
			if("JOIN:OK".equals(line)) {
				new ChatWindow(name).show();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}