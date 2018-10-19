package com.wangzunbin.pss.domain;

import java.math.BigDecimal;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
	private Long id; // 商品编号
	private String productName; // 商品名称
	private Long dir_id; //商品分类
	private BigDecimal salePrice; // 售价
	private String supplier; // 供应商
	private String brand; // 商标
	private Double cutoff; // 折价
	private BigDecimal costPrice; // 成本价
}
