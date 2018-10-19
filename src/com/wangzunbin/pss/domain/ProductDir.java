package com.wangzunbin.pss.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDir {
	private Long id; //商品分类编号
	private String dirName; //分类名称
	private Long parent_id; // 分类的父分类
}
