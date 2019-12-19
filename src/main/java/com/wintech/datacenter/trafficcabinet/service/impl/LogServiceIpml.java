package com.wintech.datacenter.trafficcabinet.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wintech.datacenter.trafficcabinet.mapper.LogMapper;
import com.wintech.datacenter.trafficcabinet.pojo.Useractionlog;
import com.wintech.datacenter.trafficcabinet.service.LogService;
import com.wintech.datacenter.trafficcabinet.util.MybatiesUtil;

public class LogServiceIpml extends MybatiesUtil implements LogService {

	@Override
	public int addLog(Useractionlog log) {
		SqlSession session = getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		return mapper.addLog(log);
	}

	@Override
	public int totalCount(Integer id) {
		SqlSession session = getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		return mapper.totalCount(id);
	}

	@Override
	public int getMaxId() {
		SqlSession session = getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		return mapper.getMaxId();
	}

	@Override
	public List<Useractionlog> getAlllog() {
		SqlSession session = getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		return mapper.getAlllog();
	}

	@Override
	public List<Useractionlog> getAllPageLog(Integer rowNum, int pagecount, String timemin, String timemax,
			String userid) {
		SqlSession session = getSession();
		LogMapper mapper = session.getMapper(LogMapper.class);
		return mapper.getAllPageLog(rowNum, pagecount, timemin, timemax, userid);
	}

}
