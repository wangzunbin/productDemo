package com.wangzunbin.pss.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

// 获取JDBC连接对象, 并释放资源的工具类
public class JdbcUtil {

	//数据库源对象
	private static DataSource dataSource;
	
	static {
		// 读取数据库的配置文件
		Properties p = new Properties();
		InputStream in = Thread.currentThread().getContextClassLoader()
		.getResourceAsStream("db.properties");
		try {
			// 加载读入的配置
			p.load(in);
			dataSource = DruidDataSourceFactory.createDataSource(p);
		} catch (Exception e) {
			throw new RuntimeException("加载db.properties配置文件错误");
		}
		
	}
	
	//获取数据库连接对象
	public static Connection getConn() {
		try {
			return dataSource.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("加载数据库错误.......");
	}
	
	// 释放资源
		public static void close(Connection conn, Statement ps, ResultSet rs) {
			try {
				if (rs != null) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (ps != null) {
						ps.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}finally{
					try {
						if (conn != null) {
							conn.close();
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
		}
}
