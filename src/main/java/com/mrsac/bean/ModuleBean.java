package com.mrsac.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name="master_module_tbl")
public class ModuleBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int module_id;
	private String module_name;	
	private String mod_purpose;
	private String created_by;
	private String createdon;
	private String category;
	private String mod_url;
	private String mod_key;
	private String mod_color;
	

	public String getMod_color() {
		return mod_color;
	}
	public void setMod_color(String mod_color) {
		this.mod_color = mod_color;
	}
	private String mod_image;
	
	public String getMod_image() {
		return mod_image;
	}
	public void setMod_image(String mod_image) {
		this.mod_image = mod_image;
	}
	public String getMod_key() {
		return mod_key;
	}
	public void setMod_key(String mod_key) {
		this.mod_key = mod_key;
	}
	public String getMod_url() {
		return mod_url;
	}
	public void setMod_url(String mod_url) {
		this.mod_url = mod_url;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getModule_id() {
		return module_id;
	}
	public void setModule_id(int module_id) {
		this.module_id = module_id;
	}
	public String getModule_name() {
		return module_name;
	}
	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}
	
	public String getMod_purpose() {
		return mod_purpose;
	}
	public void setMod_purpose(String mod_purpose) {
		this.mod_purpose = mod_purpose;
	}
	public String getCreated_by() {
		return created_by;
	}
	public void setCreated_by(String created_by) {
		this.created_by = created_by;
	}
	public String getCreatedon() {
		return createdon;
	}
	public void setCreatedon(String createdon) {
		this.createdon = createdon;
	}
	
	
}
