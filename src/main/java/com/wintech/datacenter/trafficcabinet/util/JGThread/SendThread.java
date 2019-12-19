package com.wintech.datacenter.trafficcabinet.util.JGThread;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread implements Runnable {
	private BufferedReader in;
	private Socket socket;
	private PrintWriter pw;
	private String msg;

	public SendThread(Socket socket) {
		this.socket = socket;
	}

	private void sendMsg() {
		try {
			pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			pw.println(msg);
			pw.flush();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			System.out.println("SendThread");
			in = new BufferedReader(new InputStreamReader(new FileInputStream(new File("a.txt")), "utf-8"));
			while ((msg = in.readLine()) != null) {
				System.out.println(msg);
				sendMsg();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
