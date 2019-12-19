package com.wintech.datacenter.trafficcabinet.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.wintech.datacenter.trafficcabinet.mapper.UserMapper;
import com.wintech.datacenter.trafficcabinet.pojo.User;
import com.wintech.datacenter.trafficcabinet.service.UserService;
import com.wintech.datacenter.trafficcabinet.util.MybatiesUtil;

public class UserServiceImpl extends MybatiesUtil implements UserService {
	@Override
	public User login(User user) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.login(user);
	}

	@Override
	public int addUser(User user) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.addUser(user);
	}

	@Override
	public String phone(String phone) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.phone(phone);
	}

	@Override
	public String phoneshow(User user) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.phoneshow(user);
	}

	@Override
	public List<User> getAllPageUser(Integer rowNum, int pagecount, String userid) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.getAllPageUser(rowNum, pagecount, userid);
	}

	@Override
	public int totalCount(String userid) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.totalCount(userid);
	}

	@Override
	public int deleteUser(String userid) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.deleteUser(userid);
	}

	@Override
	public int delSelected(String[] id) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.delSelected(id);
	}

	@Override
	public int updateStateLogin(User user) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.updateStateLogin(user);
	}

	@Override
	public int updateStateLogout(User user) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.updateStateLogout(user);
	}

	@Override
	public List<User> getUsers(String[] id) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.getUsers(id);
	}

	@Override
	public int updateTime(String logintime, String userid, String password) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.updateTime(logintime, userid, password);
	}

	@Override
	public int updateTimes(String logouttime, String userid) {
		SqlSession session = getSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		return mapper.updateTimes(logouttime, userid);
	}

}
