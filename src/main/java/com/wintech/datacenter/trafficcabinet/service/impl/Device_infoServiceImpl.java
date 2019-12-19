package com.wintech.datacenter.trafficcabinet.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wintech.datacenter.trafficcabinet.mapper.Device_infoMapper;
import com.wintech.datacenter.trafficcabinet.pojo.Device_info;
import com.wintech.datacenter.trafficcabinet.service.Device_infoService;
import com.wintech.datacenter.trafficcabinet.util.MybatiesUtil;

public class Device_infoServiceImpl extends MybatiesUtil implements Device_infoService {
	@Override
	public List<Device_info> getDevice() {
		SqlSession session = getSession();
		Device_infoMapper mapper = session.getMapper(Device_infoMapper.class);
		return mapper.getDevice();
	}

	@Override
	public int totalCount(String deviceId) {
		SqlSession session = getSession();
		Device_infoMapper mapper = session.getMapper(Device_infoMapper.class);
		return mapper.totalCount(deviceId);
	}

	@Override
	public List<Device_info> getPageDevice(Integer rowNum, int pageCount, String deviceId) {
		SqlSession session = getSession();
		Device_infoMapper mapper = session.getMapper(Device_infoMapper.class);
		return mapper.getPageDevice(rowNum, pageCount, deviceId);
	}

	@Override
	public Device_info getDevice_info(String deviceId) {
		SqlSession session = getSession();
		Device_infoMapper mapper = session.getMapper(Device_infoMapper.class);
		System.out.println("Device_info=" + mapper.getDevice_info(deviceId));
		return mapper.getDevice_info(deviceId);
	}

	@Override
	public int updateDevice(Device_info device_info) {
		SqlSession session = getSession();
		Device_infoMapper mapper = session.getMapper(Device_infoMapper.class);
		return mapper.updateDevice(device_info);
	}

}
