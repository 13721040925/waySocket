package com.wintech.datacenter.trafficcabinet.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//读取mybatis核心配置文件，构造sqlsession，关闭资源工具类
public class MybatiesUtil {
	private static SqlSessionFactory factory = null;// 数据库会话对象
	static {
		try {
			InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
			System.out.println(is);
			factory = new SqlSessionFactoryBuilder().build(is);
			System.out.println(factory);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public SqlSession getSession() {
		return factory.openSession();
	}

	public void close(SqlSession session) {
		if (session != null) {
			session.close();
		}
	}
}
