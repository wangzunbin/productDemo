package com.wangzunbin.pss.template;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.wangzunbin.pss.util.JdbcUtil;

public class JdbcTemplate {

	// 私有化构造器
	private JdbcTemplate() {
	}

	/**
	 * 增加\删除\更新数据库
	 * @param sql 执行数据库的语句
	 * @param params 参数
	 */
	public static void update(String sql, Object... params) {
		// 2:获取连接对象
		Connection conn = JdbcUtil.getConn();
		// 声明资源对象
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			// 4:执行SQL语句
			// 设置占位符参数
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i + 1, params[i]);
			}
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5:释放资源
			JdbcUtil.close(conn, ps, null);
		}

	}

	public static <T> T query(String sql, IResultSetHandler<T> rsh,
			Object... params) {
		// 1:加载注册驱动
		// 2:获取连接对象
		Connection conn = JdbcUtil.getConn();
		// 声明资源对象
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(sql);
			// 4:执行SQL语句
			for (int i = 0; i < params.length; i++) {
				ps.setObject(i+1, params[i]);
			}
			rs = ps.executeQuery();
			// 处理结果集
			return rsh.handle(rs);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			// 5:释放资源
			JdbcUtil.close(conn, ps, rs);
		}

		return null;
	}
}
