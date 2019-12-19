package com.wintech.datacenter.trafficcabinet.util;

import com.wintech.datacenter.trafficcabinet.pojo.Device_info;
import com.wintech.datacenter.trafficcabinet.pojo.HeartInfo;

public class Heart implements ThreadUtil {
	private byte[] bt;

	public Heart() {
	}

	public Heart(byte[] b) {
		this.bt = b;
	}

	@Override
	public void run() {
		HeartInfo heartInfo = new HeartInfo();
		Device_info device_info = new Device_info();
		Register r = new Register();
		byte[] bt3 = new byte[1024];

		System.arraycopy(bt, 3, bt3, 0, 7);

		// 机柜ID
		String deviceid = new String(bt3);

		// 机柜湿度
		int v = (int) bt[10];
		String liquid = Integer.toString(r.register(v));

		// 机柜温度
		int w = (int) bt[11];
		String temp = Integer.toString(r.register(w));

		// 机柜状态
		Integer doorone = ((bt[12] & 0x01) != 0) ? 1 : 0; // "门1关闭" : "门1打开");
		Integer doortwo = ((bt[12] & 0x02) != 0) ? 1 : 0; // "门2关闭" : "门2打开");
		Integer zhendong = ((bt[12] & 0x04) != 0) ? 1 : 0;// "无振动" : "振动");
		Integer camera = ((bt[12] & 0x08) != 0) ? 1 : 0; // "摄像头打开" : "摄像头关闭");
		Integer lockstate = ((bt[12] & 0x10) != 0) ? 1 : 0; // "解锁中" : "正常工作");
		heartInfo.setDeviceid(deviceid);
		heartInfo.setLiquid(liquid);
		heartInfo.setTemp(temp);
		heartInfo.setDoorone(doorone);
		heartInfo.setDoortwo(doortwo);
		heartInfo.setCamera(camera);
		heartInfo.setLockstate(lockstate);
		heartInfo.setZhendong(zhendong);
		System.out.println(heartInfo);
		// HeartInfoService heartInfoService = app.getBean("heartInfoService",
		// HeartInfoService.class);
		// int i = heartInfoService.addHeartInfo(heartInfo);
		// if (i > 0) {
		// System.out.println("添加报警信息成功！");
		// }
		device_info.setDeviceId(deviceid);
		device_info.setTempnow(temp);
		device_info.setWetnow(liquid);
		// Device_infoService device_infoService = app.getBean("Device_infoService",
		// Device_infoService.class);
		// int x = device_infoService.updateDevice(device_info);
		// if (x > 0) {
		// System.out.println("温湿度修改成功！");
		// }

	}

}
