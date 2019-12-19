package com.wintech.datacenter.trafficcabinet.util.JGThread;

import java.io.DataInputStream;
import java.net.Socket;

import com.wintech.datacenter.trafficcabinet.util.Judge;
import com.wintech.datacenter.trafficcabinet.util.ThreadUtil;

//服务器端的多线程类，可以接收客户端的并发请求
public class ServerThread implements Runnable {
	private Socket socket;// 套接字对象
	private DataInputStream in;// 输入流对象
	private String msg;// 读取到的数据
	// "IG请求注册","IG响应查询消息","IG向IC发心跳消息","IG响应IC向IG发参数设置消息","IG响应IC向IG设置IP参数消息","IG响应IC向IG设置同步时间消息","IG向IC上报紧急事件","IG响应IC向IG发解琐命令"
	// private final byte[] bts = { 0x30, 0x33, 0x43, 0x46, 0x48, 0x4A, 0x4B, 0x4F
	// };

	public ServerThread(Socket socket) {
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			System.out.println(socket);
			System.out.println(socket.getInputStream());
			// 读取客户端发送的请求信息
			in = new DataInputStream(socket.getInputStream());
			msg = "客户端 :" + socket.getInetAddress() + "/" + socket.getPort() + "连接成功 !";
			System.out.println(msg);
			// String st = "";
			// 一直监听客户端的请求信息
			while (in != null) {
				// while (true) {
				System.out.println("已进入");
				// 7f 0a 4b 31 30 30 30 30 30 31 01 27
				byte[] bt = new byte[1024];// st.getBytes();
				in.read(bt);
				System.out.println("bt[0]==" + Integer.toHexString(bt[0]));
				if (bt[0] == 0x7f) {
					System.out.println("指令是7f");
					byte bt1 = 0;
					for (int i = 0; i < bt.length - 1; i++) {// 5 1 2 8
						bt1 += bt[i];
						System.out.print(" " + Integer.toHexString(bt[i]));
					}
					System.out.println(" " + Integer.toHexString(bt[bt.length - 1]));
					// System.out.println(msg);
					System.out.println(
							Integer.toHexString(bt1) + "," + (byte) bt1 + "," + Integer.toHexString(bt[bt.length - 1]));
					// if ((byte) bt1 == bt[bt.length - 1]) {
					// System.out.println("校验码正确");
					// System.out.println("byte的长度=" + bt.length);
					ThreadUtil judge = new Judge(bt);
					Thread th = new Thread(judge, "判断");
					th.start();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
