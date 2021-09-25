package com.mrsac.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "master_sss_users")
public class UsersBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int usrid;
	private String sevarth_no;
	private String branch;	
	private String first_name;
	private String middle_name;
	private String last_name;
	private String level0;
	private String level1;
	private String level2;
	private String level3;
	private String mobile_num;
	private String emailid;
	private String creator_name;
	private String status;
	
	private String user_type;
	
	private int rank_status;
	private String password;
	private String usr_rank;
	private String gender;
	private String sevarth_id;
	private String created_on;
	private String modified_on;
	private String modified_by;
	private int priority;
	private int visit_status;
	private String profile_code;
	
	
	public int getVisit_status() {
		return visit_status;
	}
	public void setVisit_status(int visit_status) {
		this.visit_status = visit_status;
	}
	public String getProfile_code() {
		return profile_code;
	}
	public void setProfile_code(String profile_code) {
		this.profile_code = profile_code;
	}
	
	
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public String getCreated_on() {
		return created_on;
	}
	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}
	public String getModified_on() {
		return modified_on;
	}
	public void setModified_on(String modified_on) {
		this.modified_on = modified_on;
	}
	public String getModified_by() {
		return modified_by;
	}
	public void setModified_by(String modified_by) {
		this.modified_by = modified_by;
	}
	public String getSevarth_id() {
		return sevarth_id;
	}
	public void setSevarth_id(String sevarth_id) {
		this.sevarth_id = sevarth_id;
	}
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	public String getUsr_rank() {
		return usr_rank;
	}
	public void setUsr_rank(String usr_rank) {
		this.usr_rank = usr_rank;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public int getRank_status() {
		return rank_status;
	}
	public void setRank_status(int rank_status) {
		this.rank_status = rank_status;
	}
	public int getUsrid() {
		return usrid;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getMiddle_name() {
		return middle_name;
	}
	public void setMiddle_name(String middle_name) {
		this.middle_name = middle_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public void setUsrid(int usrid) {
		this.usrid = usrid;
	}
	public String getSevarth_no() {
		return sevarth_no;
	}
	public void setSevarth_no(String sevarth_no) {
		this.sevarth_no = sevarth_no;
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
	public String getMobile_num() {
		return mobile_num;
	}
	public void setMobile_num(String mobile_num) {
		this.mobile_num = mobile_num;
	}
	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreator_name() {
		return creator_name;
	}
	public void setCreator_name(String creator_name) {
		this.creator_name = creator_name;
	}
	
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	
	
}
