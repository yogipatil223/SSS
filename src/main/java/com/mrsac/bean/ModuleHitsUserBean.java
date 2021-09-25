package com.mrsac.bean;


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
@Table(name = "tbl_usr_hit_logs")
public class ModuleHitsUserBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hit_id;
	
	
	private int mod_id;
	private String hit_time_date;
	private long attempt_id;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "mod_id", referencedColumnName="module_id",insertable = false,updatable = false)
    private ModuleBean modbean;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@JsonIgnore
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name = "attempt_id", referencedColumnName="attempt_id",insertable = false,updatable = false)
	private LoginAttemptBean attemptbean;
	
	public ModuleBean getModbean() {
		return modbean;
	}
	public void setModbean(ModuleBean modbean) {
		this.modbean = modbean;
	}
	public LoginAttemptBean getAttemptbean() {
		return attemptbean;
	}
	public void setAttemptbean(LoginAttemptBean attemptbean) {
		this.attemptbean = attemptbean;
	}
	public long getHit_id() {
		return hit_id;
	}
	public void setHit_id(long hit_id) {
		this.hit_id = hit_id;
	}
	public int getMod_id() {
		return mod_id;
	}
	public void setMod_id(int mod_id) {
		this.mod_id = mod_id;
	}
	public String getHit_time_date() {
		return hit_time_date;
	}
	public void setHit_time_date(String hit_time_date) {
		this.hit_time_date = hit_time_date;
	}
	public long getAttempt_id() {
		return attempt_id;
	}
	public void setAttempt_id(long attempt_id) {
		this.attempt_id = attempt_id;
	}

}
