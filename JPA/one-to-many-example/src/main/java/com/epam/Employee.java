package com.epam;

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
@Table(name="EMPLOYEES")
public class Employee {
 
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="EMP_ID")
    private Long empId;
 
    private String name;
 
    private String department;
 
    private Long salary;
 
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="EMP_ID")
    private List<AssetMgnt> assetMgnt;
 
    public List<AssetMgnt> getAssetMgnt() {
        return assetMgnt;
    }
 
    public void setAssetMgnt(List<AssetMgnt> assetMgnt) {
        this.assetMgnt = assetMgnt;
    }
 
    public Long getEmpId() {
        return empId;
    }
 
    public void setEmpId(Long empId) {
        this.empId = empId;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public String getDepartment() {
        return department;
    }
 
    public void setDepartment(String department) {
        this.department = department;
    }
 
    public Long getSalary() {
        return salary;
    }
 
    public void setSalary(Long salary) {
        this.salary = salary;
    }

}
