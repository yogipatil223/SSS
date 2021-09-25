package com.mrsac.bean;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_module_permission")
public class ModPermissionBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long pr_id;
	private int	sevarthnum;
	private int mod_id;
    private int per_view;
	private int per_validate;
    private int per_dataentry;
    private int per_desk;
    private int per_gis;
    
    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(cascade=CascadeType.ALL)
  	@JoinColumn(name = "sevarthnum", referencedColumnName="usrid",insertable = false,updatable = false)
    private UsersBean usrbean;
    
	
	public UsersBean getUsrbean() {
		return usrbean;
	}
	public void setUsrbean(UsersBean usrbean) {
		this.usrbean = usrbean;
	}
	public int getPer_desk() {
		return per_desk;
	}
	public void setPer_desk(int per_desk) {
		this.per_desk = per_desk;
	}
	public int getPer_gis() {
		return per_gis;
	}
	public void setPer_gis(int per_gis) {
		this.per_gis = per_gis;
	}
	public ModuleBean getBean() {
		return bean;
	}
	public void setBean(ModuleBean bean) {
		this.bean = bean;
	}
	private int applied_by;
    private String applied_on;  
	  
    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "mod_id", referencedColumnName="module_id",insertable = false,updatable = false)
    private ModuleBean bean;
    
    
	   
   public int getSevarthnum() {
		return sevarthnum;
	}
	public void setSevarthnum(int sevarthnum) {
		this.sevarthnum = sevarthnum;
	}
public long getPr_id() {
		return pr_id;
	}
	public void setPr_id(long pr_id) {
		this.pr_id = pr_id;
	}
	
	public int getMod_id() {
		return mod_id;
	}
	public void setMod_id(int mod_id) {
		this.mod_id = mod_id;
	}
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

	
}
