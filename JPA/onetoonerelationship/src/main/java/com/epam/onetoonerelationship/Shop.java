package com.epam.onetoonerelationship;

import java.io.Serializable;
import java.util.Collection;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "SHOP")
public class Shop implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "shop_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shopId;
	
	@Column(name = "shop_name")
	private String shopName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_category_id")
	private Collection<ProductCategory> productCategoryCollection;

	public int getShopId() {
		return shopId;
	}

	public void setShopId(int shopId) {
		this.shopId = shopId;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public Collection<ProductCategory> getProductCategoryCollection() {
		return productCategoryCollection;
	}

	public void setProductCategoryCollection(Collection<ProductCategory> productCategoryCollection) {
		this.productCategoryCollection = productCategoryCollection;
	}
	
}
