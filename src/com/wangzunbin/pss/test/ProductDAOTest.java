package com.wangzunbin.pss.test;

import java.math.BigDecimal;
import java.util.List;

import org.junit.Test;

import com.wangzunbin.pss.dao.IProductDAO;
import com.wangzunbin.pss.dao.impl.ProductDAOImpl;
import com.wangzunbin.pss.domain.Product;
import com.wangzunbin.pss.query.ProductQueryObject;

public class ProductDAOTest {

	IProductDAO dao = new ProductDAOImpl();
	
	@Test
	public void testSave() {
		Product p = new Product(20L, "办公键盘4", 1L, new BigDecimal(39), "梨子",
				"梨子", 0.5, new BigDecimal(29));
		dao.save(p);
	}
	
	@Test
	public void testDelete() {
		dao.delete(2l);
	}
	
	@Test
	public void testUpdate() {
		Product newProduct = new Product(20L, "办公鼠标1", 1L, new BigDecimal(29), "橘子",
				"橘子", 0.5, new BigDecimal(66));
		dao.update(newProduct, 3l);
	}
	
	@Test
	public void testQuerySingle() {
		System.out.println(dao.get(3L));
	}
	
	@Test
	public void testQueryAll() {
		System.out.println(dao.list());
	}
	
	/**
	 * 高级查询
	 */
	@Test
	public void testMoreQuery() {
		List<Product> query = dao.query("键盘", null, null);
		System.out.println(query.toString());
	}
	
	/**
	 * 高级查询升级版
	 */
	@Test
	public void testMoreQuery1() {
		ProductQueryObject pqo = new ProductQueryObject("鼠标", null, null);
		List<Product> query = dao.query(pqo);
		System.out.println(query.toString());
	}
	
	/**
	 * 高级查询升级版
	 */
	@Test
	public void testMoreQuery2() {
		ProductQueryObject pqo = new ProductQueryObject("鼠标", null, null);
		List<Product> query = dao.query2(pqo);
		System.out.println(query.toString());
	}
	
}
