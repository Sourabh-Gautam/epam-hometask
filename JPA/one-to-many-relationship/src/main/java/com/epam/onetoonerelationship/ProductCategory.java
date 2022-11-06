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
@Table(name = "PRODUCTCATEGORY")
public class ProductCategory {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "product_category_id")
	private Integer productCategoryId;
	
	@Column(name = "product_category_name")
	private String productCategoryName;
	
	@Column(name = "shop_id")
	private Integer shopId;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_category_id")
	private List<Product> productCollection;
	
	public List<Product> getProductCollection() {
		return productCollection;
	}

	public void setProductCollection(List<Product> productCollection) {
		this.productCollection = productCollection;
	}

	public Integer getShopId() {
		return shopId;
	}
	
	public void setShopId(Integer shopId) {
		this.shopId = shopId;
	}
	
	public Integer getProductCategoryId() {
		return productCategoryId;
	}

	public void setProductCategoryId(Integer productCategoryId) {
		this.productCategoryId = productCategoryId;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}
	
}
