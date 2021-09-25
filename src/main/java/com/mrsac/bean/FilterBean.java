package com.mrsac.bean;

public class FilterBean {

	private String branch;
	private String joinCode;
	private String level0;
	private String level1;
	private String level2;
	private String level3;
	private int mod_id;
	private String usr_rank;
	private int applied_by;
	private String applied_on;
	
	private int per_view;
	private int per_validate;
	private int per_dataentry;
	private int deskOfficer;
	private int gisViewer;
	
	public int getPer_view() {
		return per_view;
	}
	public void setPer_view(int per_view) {
		this.per_view = per_view;
	}
	public int getPer_validate() {
		return per_validate;
	}
	public void setPer_validate(int per_validate) {
		this.per_validate = per_validate;
	}
	public int getPer_dataentry() {
		return per_dataentry;
	}
	public void setPer_dataentry(int per_dataentry) {
		this.per_dataentry = per_dataentry;
	}
	public int getDeskOfficer() {
		return deskOfficer;
	}
	public void setDeskOfficer(int deskOfficer) {
		this.deskOfficer = deskOfficer;
	}
	public int getGisViewer() {
		return gisViewer;
	}
	public void setGisViewer(int gisViewer) {
		this.gisViewer = gisViewer;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getJoinCode() {
		return joinCode;
	}
	public int getApplied_by() {
		return applied_by;
	}
	public void setApplied_by(int applied_by) {
		this.applied_by = applied_by;
	}
	public String getApplied_on() {
		return applied_on;
	}
	public void setApplied_on(String applied_on) {
		this.applied_on = applied_on;
	}
	public void setJoinCode(String joinCode) {
		this.joinCode = joinCode;
	}
	public String getLevel0() {
		return level0;
	}
	public void setLevel0(String level0) {
		this.level0 = level0;
	}
	public String getLevel1() {
		return level1;
	}
	public void setLevel1(String level1) {
		this.level1 = level1;
	}
	public String getLevel2() {
		return level2;
	}
	public void setLevel2(String level2) {
		this.level2 = level2;
	}
	public String getLevel3() {
		return level3;
	}
	public void setLevel3(String level3) {
		this.level3 = level3;
	}
	public int getMod_id() {
		return mod_id;
	}
	public void setMod_id(int mod_id) {
		this.mod_id = mod_id;
	}
	public String getUsr_rank() {
		return usr_rank;
	}
	public void setUsr_rank(String usr_rank) {
		this.usr_rank = usr_rank;
	}
}
