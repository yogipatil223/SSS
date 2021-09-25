package com.mrsac.bean;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Table(name="tbl_login_attempt")
public class LoginAttemptBean {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long attempt_id;
    private int usr_id;
	private String ip_address;
	private String start_session;
	private String end_session;
	
	@NotFound(action = NotFoundAction.IGNORE)
	@ManyToOne(cascade = CascadeType.ALL )
	@JoinColumn(name = "usr_id", referencedColumnName="usrid",insertable = false,updatable = false)
	private UsersBean usrbean;
    
	public Set<ModuleHitsUserBean> getModulehitsbean() {
		return modulehitsbean;
	}
	public UsersBean getUsrbean() {
		return usrbean;
	}
	public void setUsrbean(UsersBean usrbean) {
		this.usrbean = usrbean;
	}
	public void setModulehitsbean(Set<ModuleHitsUserBean> modulehitsbean) {
		this.modulehitsbean = modulehitsbean;
	}
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY, mappedBy = "attemptbean" )	
	private Set<ModuleHitsUserBean> modulehitsbean = new HashSet<ModuleHitsUserBean>() ;
    
	public long getAttempt_id() {
		return attempt_id;
	}
	public void setAttempt_id(long attempt_id) {
		this.attempt_id = attempt_id;
	}
	public int getUsr_id() {
		return usr_id;
	}
	public void setUsr_id(int usr_id) {
		this.usr_id = usr_id;
	}
	public String getIp_address() {
		return ip_address;
	}
	public void setIp_address(String ip_address) {
		this.ip_address = ip_address;
	}
	public String getStart_session() {
		return start_session;
	}
	public void setStart_session(String start_session) {
		this.start_session = start_session;
	}
	public String getEnd_session() {
		return end_session;
	}
	public void setEnd_session(String end_session) {
		this.end_session = end_session;
	}
	
	
}
