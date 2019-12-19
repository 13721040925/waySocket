package com.wintech.datacenter.trafficcabinet.server;

import java.net.ServerSocket;
import java.net.Socket;

import com.wintech.datacenter.server.WTServer;
import com.wintech.datacenter.trafficcabinet.util.JGThread.SendThread;
import com.wintech.datacenter.trafficcabinet.util.JGThread.ServerThread;

public class TCServer implements WTServer {
	private ServerSocket server;//

	@Override
	public void connect(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("服务器启动！");
			while (true) {
				Socket socket = server.accept();
				ServerThread serverThread = new ServerThread(socket);
				Thread th = new Thread(serverThread);
				SendThread sendThread = new SendThread(socket);
				Thread th1 = new Thread(sendThread);
				th.start();
				th1.start();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
