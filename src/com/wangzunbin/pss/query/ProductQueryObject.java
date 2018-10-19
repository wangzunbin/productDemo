package com.wangzunbin.pss.query;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.wangzunbin.pss.util.StringUtil;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor

public class ProductQueryObject {

	private String productName;
	private BigDecimal minSalePrice;
	private BigDecimal maxSalePrice;

	// 存放sql的条件
	private List<String> conditions = new ArrayList<>();
	// 存放sql中的参数的值
	private List<Object> params = new ArrayList<>();

	public String getQuery() {
		StringBuilder sql = new StringBuilder();
		// 根据参数是否有值得情况下来拼sql语句
		if (StringUtil.hasLength(productName)) {
			conditions.add("productName LIKE ?");
			params.add("%" + productName + "%");
		}

		if (minSalePrice != null) {
			conditions.add("salePrice >= ?");
			params.add(minSalePrice);
		}
		if (maxSalePrice != null) {
			conditions.add("salePrice <= ?");
			params.add(maxSalePrice);
		}
		for (int i = 0; i < conditions.size(); i++) {
			if (i == 0) {
				sql.append(" WHERE ");
			} else {
				sql.append(" AND ");
			}
			sql.append(conditions.get(i));
		}
		return sql.toString();
	}

	public ProductQueryObject(String productName, BigDecimal minSalePrice, BigDecimal maxSalePrice) {
		super();
		this.productName = productName;
		this.minSalePrice = minSalePrice;
		this.maxSalePrice = maxSalePrice;
	}
}
