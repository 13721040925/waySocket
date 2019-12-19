package com.wintech.datacenter.trafficcabinet.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.wintech.datacenter.trafficcabinet.mapper.AlarmdataMapper;
import com.wintech.datacenter.trafficcabinet.pojo.Alarmdata;
import com.wintech.datacenter.trafficcabinet.service.AlarmdataService;
import com.wintech.datacenter.trafficcabinet.util.MybatiesUtil;

public class AlarmdataServiceImpl extends MybatiesUtil implements AlarmdataService {

	@Override
	public int addAlarmdata(Alarmdata alarmdata) {
		SqlSession session = getSession();
		AlarmdataMapper mapper = session.getMapper(AlarmdataMapper.class);
		return mapper.addAlarmdata(alarmdata);
	}

}
