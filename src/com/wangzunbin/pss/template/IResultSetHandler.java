package com.wangzunbin.pss.template;

import java.sql.ResultSet;

public interface IResultSetHandler<T> {
	/**
	 * 处理结果集方法
	 * @param rs 传入的结果集对象
	 * @return 返回处理结果界后的对象或值对象的集合
	 */
	T handle(ResultSet rs);
}
