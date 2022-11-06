package com.epam.onetoonerelationship;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "SHOP")
public class Shop {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "shop_id")
	private Integer shopId;
	
	@Column(name = "shop_name")
	private String shopName;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "shop_id")
	private List<ProductCategory> productCategoryCollection;

	public List<ProductCategory> getProductCategoryCollection() {
		return productCategoryCollection;
	}

	public void setProductCategoryCollection(List<ProductCategory> productCategoryCollection) {
		this.productCategoryCollection = productCategoryCollection;
	}

	public Integer getShopId() {
		return shopId;
	}

	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	
}
