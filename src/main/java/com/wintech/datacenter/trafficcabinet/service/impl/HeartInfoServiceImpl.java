package com.wintech.datacenter.trafficcabinet.service.impl;

import org.apache.ibatis.session.SqlSession;

import com.wintech.datacenter.trafficcabinet.mapper.HeartInfoMapper;
import com.wintech.datacenter.trafficcabinet.pojo.HeartInfo;
import com.wintech.datacenter.trafficcabinet.service.HeartInfoService;
import com.wintech.datacenter.trafficcabinet.util.MybatiesUtil;

public class HeartInfoServiceImpl extends MybatiesUtil implements HeartInfoService {
	@Override
	public int addHeartInfo(HeartInfo heartInfo) {
		SqlSession session = getSession();
		HeartInfoMapper mapper = session.getMapper(HeartInfoMapper.class);
		return mapper.addHeartInfo(heartInfo);
	}

}
