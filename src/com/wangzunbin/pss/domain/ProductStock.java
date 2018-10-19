package com.wangzunbin.pss.domain;

import java.util.Date;

// 库存类

public class ProductStock {
	private Long id; // 库存编号
	private Long product_id; // 商品分类
	private Integer storeNum; // 商品库存
	private Date lastIncomeDate; // 商品入库时间
	private Date lastOutcomeDate; // 商品出库时间
	private Integer warningNum; // 警戒线商品数量

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProduct_id() {
		return product_id;
	}

	public void setProduct_id(Long product_id) {
		this.product_id = product_id;
	}

	public Integer getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(Integer storeNum) {
		this.storeNum = storeNum;
	}

	public Date getLastIncomeDate() {
		return lastIncomeDate;
	}

	public void setLastIncomeDate(Date lastIncomeDate) {
		this.lastIncomeDate = lastIncomeDate;
	}

	public Date getLastOutcomeDate() {
		return lastOutcomeDate;
	}

	public void setLastOutcomeDate(Date lastOutcomeDate) {
		this.lastOutcomeDate = lastOutcomeDate;
	}

	public Integer getWarningNum() {
		return warningNum;
	}

	public void setWarningNum(Integer warningNum) {
		this.warningNum = warningNum;
	}

	@Override
	public String toString() {
		return "ProductStock [id=" + id + ", product_id=" + product_id
				+ ", storeNum=" + storeNum + ", lastIncomeDate="
				+ lastIncomeDate + ", lastOutcomeDate=" + lastOutcomeDate
				+ ", warningNum=" + warningNum + "]";
	}

	public ProductStock(Long id, Long product_id, Integer storeNum,
			Date lastIncomeDate, Date lastOutcomeDate, Integer warningNum) {
		super();
		this.id = id;
		this.product_id = product_id;
		this.storeNum = storeNum;
		this.lastIncomeDate = lastIncomeDate;
		this.lastOutcomeDate = lastOutcomeDate;
		this.warningNum = warningNum;
	}

	public ProductStock() {
		super();
	}

}
