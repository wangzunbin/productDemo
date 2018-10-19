package com.wangzunbin.pss.dao;

import java.math.BigDecimal;
import java.util.List;

import com.wangzunbin.pss.domain.Product;
import com.wangzunbin.pss.query.ProductQueryObject;

public interface IProductDAO {

	void save(Product p);
	
	void delete(Long productId);
	
	void update(Product newProduct, Long productId);
	
	Product get(Long id);
	
	List<Product> list();
	
	/**
	 *       高级查询
	 * @param productName 商品名称
	 * @param minSalePrice 最低零售价
	 * @param maxSalePrice 最高零售价
	 * @return  查询结果
	 */
	List<Product> query(String productName, BigDecimal minSalePrice,
			BigDecimal maxSalePrice);
	
	/**
	 * 高级查询升级版本
	 * @param pqo
	 * @return
	 */
	List<Product> query(ProductQueryObject pqo);
	
	/**
	 * 1解决以下的问题:
	 * 1). 使用1=1效率低,
	 * 2). 责任分离
	 * @param pqo
	 * @return
	 */
	List<Product> query2(ProductQueryObject pqo);
}
