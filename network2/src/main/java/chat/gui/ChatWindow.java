package chat.gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.Socket;
import java.net.SocketException;

public class ChatWindow {

	private Frame frame;
	private Panel pannel;
	private Button buttonSend;
	private TextField textField;
	private TextArea textArea;
	private String nickname;
	private Socket socket;
	private PrintWriter pw;
	private BufferedReader br;

	public ChatWindow(String nickname, Socket socket) {
		frame = new Frame(nickname);
		pannel = new Panel();
		buttonSend = new Button("Send");
		textField = new TextField();
		textArea = new TextArea(30, 80);
		this.nickname = nickname;
		this.socket = socket;
	}

	public void show() {
		/**
		 * 1. UI 초기화
		 */
		// Button
		buttonSend.setBackground(Color.GRAY);
		buttonSend.setForeground(Color.WHITE);
		buttonSend.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
				sendMessage();
			}
		});

		// Textfield
		textField.setColumns(80);
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char keyCode = e.getKeyChar();
				if (keyCode == KeyEvent.VK_ENTER) {
					sendMessage();
				}
			}
		});

		// Pannel
		pannel.setBackground(Color.LIGHT_GRAY);
		pannel.add(textField);
		pannel.add(buttonSend);
		frame.add(BorderLayout.SOUTH, pannel);

		// TextArea
		textArea.setEditable(false);
		frame.add(BorderLayout.CENTER, textArea);

		// Frame
		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				finish();
			}
		});
		frame.setVisible(true);
		frame.pack();

		/**
		 * 2. IOStream 생성
		 */

		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "UTF-8"), true);
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));

		} catch (IOException e1) {
			e1.printStackTrace();
		}

		/**
		 * 3. Chat Client Thread 생성(Receive Thread)
		 */
		new ChatClientThread().start();
	}

	private void finish() {

		try {
			if (socket != null && socket.isClosed() == false) {
				socket.close();
			}
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	private void sendMessage() {
		String message = textField.getText();
		pw.println("MESSAGE:" + message);

		textField.setText("");
		textField.requestFocus();
	}

	private void updateTextArea(String message) {
		textArea.append(message);
		textArea.append("\n");
	}

	private class ChatClientThread extends Thread {

		@Override
		public void run() {
			try {
				while (true) {
					String message = br.readLine();
					if (message == null) {
						break;
					}
					updateTextArea(message);
				}
			} catch (SocketException ex) {
				consoleLog("" + ex);
			} catch (IOException ex) {
				consoleLog("다음 이유로 프로그램을 종료 합니다 :" + ex);
			} finally {
				finish();
			}
		}
	}

	public static void consoleLog(String message) {
		System.out.println("\n[chat client]" + message);
	}
}