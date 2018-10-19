package com.wangzunbin.pss.dao.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.wangzunbin.pss.dao.IProductDAO;
import com.wangzunbin.pss.domain.Product;
import com.wangzunbin.pss.query.ProductQueryObject;
import com.wangzunbin.pss.template.JdbcTemplate;
import com.wangzunbin.pss.template.handler.BeanHander;
import com.wangzunbin.pss.template.handler.BeanListHandler;
import com.wangzunbin.pss.util.StringUtil;

public class ProductDAOImpl implements IProductDAO {

	@Override
	public void save(Product product) {
		String sql = "INSERT INTO product(productName, dir_id, salePrice, supplier, brand, cutoff, costprice) VALUES(?,?,?,?,?,?,?)";
		JdbcTemplate.update(sql, product.getProductName(), product.getDir_id(), product.getSalePrice(),
				product.getSupplier(), product.getBrand(), product.getCutoff(), product.getCostPrice());

	}

	@Override
	public void delete(Long productId) {
		String sql = "DELETE FROM product where id = ?";
		JdbcTemplate.update(sql, productId);
	}

	@Override
	public void update(Product newProduct, Long productId) {
		String sql = "UPDATE product SET productName=?, dir_id=?, salePrice=?, supplier=?, brand=?, cutoff=?, costprice=? WHERE id=?";
		JdbcTemplate.update(sql, newProduct.getProductName(), newProduct.getDir_id(), newProduct.getSalePrice(),
				newProduct.getSupplier(), newProduct.getBrand(), newProduct.getCutoff(), newProduct.getCostPrice(),
				productId);
	}

	@Override
	public Product get(Long id) {
		String sql = "SELECT * FROM product WHERE id=?";
		return (Product) JdbcTemplate.query(sql, new BeanHander(Product.class), id);
	}

	@Override
	public List<Product> list() {
		String sql = "SELECT * FROM product";
		return JdbcTemplate.query(sql, new BeanListHandler<>(Product.class));
	}

	@Override
	public List<Product> query(String productName, BigDecimal minSalePrice, BigDecimal maxSalePrice) {
		StringBuilder sql = new StringBuilder("SELECT * FROM product WHERE 1=1");
		List<Object> params = new ArrayList<>();
		if (StringUtil.hasLength(productName)) {
			sql.append(" AND productName LIKE ?");
			params.add("%" + productName + "%");
		}
		if (minSalePrice != null) {
			sql.append(" AND salePrice >= ?");
			params.add(minSalePrice);
		}
		if (maxSalePrice != null) {
			sql.append(" AND salePrice <= ?");
			params.add(maxSalePrice);
		}
		System.out.println(sql.toString());
		return JdbcTemplate.query(sql.toString(), new BeanListHandler<Product>(Product.class), params.toArray());
	}

	@Override
	public List<Product> query(ProductQueryObject pqo) {
		StringBuilder sql = new StringBuilder("SELECT * FROM product WHERE 1=1");
		List<Object> params = new ArrayList<>();
		// 根据参数是否有值得情况下来拼sql语句
		if (StringUtil.hasLength(pqo.getProductName())) {
			sql.append(" AND productName LIKE ?");
			params.add("%" + pqo.getProductName() + "%");
		}

		if (pqo.getMinSalePrice() != null) {
			sql.append(" AND salePrice >= ?");
			params.add(pqo.getMinSalePrice());
		}
		if (pqo.getMaxSalePrice() != null) {
			sql.append(" AND salePrice <= ?");
			params.add(pqo.getMaxSalePrice());
		}
		System.out.println(sql.toString());
		return JdbcTemplate.query(sql.toString(), new BeanListHandler<Product>(Product.class), params.toArray());
	}

	@Override
	public List<Product> query2(ProductQueryObject pqo) {
		String sql = "SELECT * FROM product" + pqo.getQuery();
		System.out.println(sql.toString());
		return JdbcTemplate.query(sql.toString(), new BeanListHandler<Product>(Product.class),
				pqo.getParams().toArray());
	}

}
