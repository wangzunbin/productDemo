package com.wangzunbin.pss.template.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.wangzunbin.pss.template.IResultSetHandler;


public class BeanListHandler<T> implements IResultSetHandler<List<T>>{
	// 字节码对象
		private Class<T> beanType;

		public BeanListHandler(Class<T> beanType) {
			this.beanType = beanType;
		}

		@Override
		public List<T> handle(ResultSet rs)   {
			List<T> list = new ArrayList<>();
			try {
				//获取beanInfo对象
				BeanInfo beanInfo = Introspector.getBeanInfo(beanType, Object.class);
				// 获取属性描述器对象
				 PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
				while(rs.next()) {
					// 创建字节码所属类对象
					T obj = beanType.newInstance();
					for (PropertyDescriptor pd : pds) {
						// 获取属性名
						String name = pd.getName();
						// 获取数据库相应列名的值
						Object value = rs.getObject(name);
						// 获取setter方法设置属性值
						pd.getWriteMethod().invoke(obj, value);
					}
					list.add(obj);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}


}
