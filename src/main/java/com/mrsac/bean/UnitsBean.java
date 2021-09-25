package com.mrsac.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="master_unit_table_r1")
public class UnitsBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String branch;
	
	private String Level0;
	private String Level1;
	private String Level2;
	private String Level3;
	private String cityrange_n;
	private String zone_n;
	private String dtename;
	private String ps_name;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getLevel0() {
		return Level0;
	}
	public void setLevel0(String level0) {
		Level0 = level0;
	}
	public String getLevel1() {
		return Level1;
	}
	public void setLevel1(String level1) {
		Level1 = level1;
	}
	public String getLevel2() {
		return Level2;
	}
	public void setLevel2(String level2) {
		Level2 = level2;
	}
	public String getLevel3() {
		return Level3;
	}
	public void setLevel3(String level3) {
		Level3 = level3;
	}
	public String getCityrange_n() {
		return cityrange_n;
	}
	public void setCityrange_n(String cityrange_n) {
		this.cityrange_n = cityrange_n;
	}
	public String getZone_n() {
		return zone_n;
	}
	public void setZone_n(String zone_n) {
		this.zone_n = zone_n;
	}
	public String getDtename() {
		return dtename;
	}
	public void setDtename(String dtename) {
		this.dtename = dtename;
	}
	public String getPs_name() {
		return ps_name;
	}
	public void setPs_name(String ps_name) {
		this.ps_name = ps_name;
	}
	
}
