package com.epam;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ASSET_MNGT")
public class AssetMgnt {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="AM_ID")
    private Long amId;
 
    @Column(name="EMP_ID")
    private Long empId;
 
    @Column(name="ASSET_NAME")
    private String assetName;
 
    private String vendor;
 
    public Long getAmId() {
        return amId;
    }
 
    public void setAmId(Long amId) {
        this.amId = amId;
    }
 
    public Long getEmpId() {
        return empId;
    }
 
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
 
    public String getAssetName() {
        return assetName;
    }
 
    public void setAssetName(String assetName) {
        this.assetName = assetName;
    }
 
    public String getVendor() {
        return vendor;
    }
 
    public void setVendor(String vendor) {
        this.vendor = vendor;
    }
 
    public String toString() {
 
        return this.assetName+" | "+this.vendor;
    }
}

