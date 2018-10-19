package com.wangzunbin.pss.template.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

import com.wangzunbin.pss.template.IResultSetHandler;



public class BeanHander<T> implements IResultSetHandler<T> {
	// 字节码对象
	private Class<T> beanType;

	public BeanHander(Class<T> beanType) {
		this.beanType = beanType;
	}

	@Override
	public T handle(ResultSet rs) {
		try {
			//获取beanInfo对象
			BeanInfo beanInfo = Introspector
					.getBeanInfo(beanType, Object.class);
			// 获取属性描述器对象
			PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
			if (rs.next()) {
				// 创建字节码所属类对象
				T obj = beanType.newInstance();
				for (PropertyDescriptor pd : pds) {
					// 获取属性名
					String name = pd.getName();
					// 获取数据库相应列名的值
					Object value = rs.getObject(name);
					
					// 获取setter方法设置属性值
					pd.getWriteMethod().invoke(obj,value);
				}
				return obj;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
